package com.example.clouddictionary.activity;

import static com.example.clouddictionary.utils.Constants.meaningList;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clouddictionary.R;
import com.example.clouddictionary.adapter.DictionaryAdapter;
import com.example.clouddictionary.adapter.MeaningsAdapter;
import com.example.clouddictionary.modal.DictionaryResponse;

import java.util.ArrayList;

public class meaning_activity extends AppCompatActivity {
    RecyclerView mrecyclerView;
    ArrayList<DictionaryResponse.Meanings> objects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning);
        mrecyclerView = findViewById(R.id.meanings_recycler);
        objects = new ArrayList<>();
        objects.clear();
        objects.addAll(meaningList);
        gotoAdapter(objects);



    }
    private void gotoAdapter(ArrayList<DictionaryResponse.Meanings> result) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setNestedScrollingEnabled(false);
        MeaningsAdapter dictionaryAdapter = new MeaningsAdapter(result,getApplicationContext());
        mrecyclerView.setHasFixedSize(true);
        mrecyclerView.setAdapter(dictionaryAdapter);
    }
}