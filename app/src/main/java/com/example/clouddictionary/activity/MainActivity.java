package com.example.clouddictionary.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clouddictionary.R;
import com.example.clouddictionary.adapter.DictionaryAdapter;
import com.example.clouddictionary.interfaces.OnDialogButtonClickListener;
import com.example.clouddictionary.modal.DictionaryResponse;
import com.example.clouddictionary.retrofit.RestClient;
import com.example.clouddictionary.retrofit.RestMethods;
import com.example.clouddictionary.utils.Constants;
import com.example.clouddictionary.utils.ProgressDialog;
import com.example.clouddictionary.utils.Util_function;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnDialogButtonClickListener {
   CardView mCardView;
   RecyclerView mrecyclerView;
    ArrayList<DictionaryResponse> result = new ArrayList<>();
   SearchView msearchView;
    DictionaryAdapter dictionaryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mCardView = findViewById(R.id.cardViewBase);
        mrecyclerView = findViewById(R.id.recyclerViewDict);
        msearchView = findViewById(R.id.searchView);
        msearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                dictionaryAdapter.updateData();
                return false;
            }
        });
        msearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length()>2) {
                    if(Util_function.ConnectivityCheck(MainActivity.this,MainActivity.this)) {
                        getDictionaryData(newText);
                    } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.check_internet), Toast.LENGTH_LONG).show();
                        ProgressDialog.dismissProgress();
                    }
                }
                return false;
            }
        });


    }

    private void getDictionaryData(String text) {
        ProgressDialog.setLottieProgressDialog(MainActivity.this, Constants.lottiePath);
        RestMethods restMethods;
        restMethods = RestClient.buildHTTPClient();
        restMethods.getDictionaryResponse(text).enqueue(new Callback<ArrayList<DictionaryResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<DictionaryResponse>> call, Response<ArrayList<DictionaryResponse>> response) {
                try {
                    if (response.code() == 200) {
                        if (response.isSuccessful()) {
                            result.clear();
                            result.add(response.body().get(0));
                            gotoAdapter(result);
                        } else if (response.code() == 412) {
                            try {
                                String Error = response.errorBody().string();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ProgressDialog.dismissProgress();
                                    }
                                });

                            } catch (Exception e) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ProgressDialog.dismissProgress();
                                    }
                                });

                                e.printStackTrace();
                            }

                        } else {
                            String Error = response.errorBody().string();
                            JSONObject obj = new JSONObject(Error);
                            String text = obj.getString("message");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ProgressDialog.dismissProgress();
                                }
                            });

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ProgressDialog.dismissProgress();
                            }
                        });
                    } catch (WindowManager.BadTokenException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<DictionaryResponse>> call, Throwable t) {
                if (t.toString().contains("Unable to resolve host")) {
                    Util_function.showAlertDialog(MainActivity.this, getString(R.string.check_internet), "OK");
                }
                Util_function.showAlertDialog(MainActivity.this,t.getMessage(),"OK");
                t.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ProgressDialog.dismissProgress();
                    }
                });
            }
        });
    }

    private void gotoAdapter(ArrayList<DictionaryResponse> result) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setNestedScrollingEnabled(false);
         dictionaryAdapter = new DictionaryAdapter(result,getApplicationContext());
        mrecyclerView.setHasFixedSize(true);
        mrecyclerView.setAdapter(dictionaryAdapter);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPositiveButtonClicked(AlertDialog alertDialog) {

    }

    @Override
    public void onNegativeButtonClicked() {

    }
}