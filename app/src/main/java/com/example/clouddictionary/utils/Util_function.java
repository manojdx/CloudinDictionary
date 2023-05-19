package com.example.clouddictionary.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clouddictionary.R;
import com.example.clouddictionary.interfaces.OnDialogButtonClickListener;


public class Util_function {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static void Show_Toast(Context context, String msg, boolean isShort) {
        Toast toast = Toast.makeText(context, "" + msg, Toast.LENGTH_LONG);
        if (isShort) {
            toast = Toast.makeText(context, "" + msg, Toast.LENGTH_SHORT);
        }
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

    public static void showAlertDialog(Context context, String title, String BtnText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog alertDialog;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutView = inflater.inflate(R.layout.alert, null);
        builder.setView(layoutView);
        alertDialog = builder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setCancelable(false);
        TextView alert_title = layoutView.findViewById(R.id.alert_title);
        alert_title.setText(title);
        Button alert_ok = layoutView.findViewById(R.id.alert_yes);
        alert_ok.setText(BtnText);
        alertDialog.show();
        alert_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.hide();
                alertDialog.cancel();
                alertDialog.dismiss();
            }
        });
    }

    public static Boolean ConnectivityCheck(Context context, OnDialogButtonClickListener listener) {

        Boolean connectivity=false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED){
            connectivity=true;
          /*  try {
                connectivity=true;
                InetAddress ipAddr = InetAddress.getByName("google.com");
                //You can replace it with your name
                return !ipAddr.equals("");

            } catch (Exception e) {
                ShowAlertError(context,"Check Your Internet Connection","ok",listener);
                return false;

            }*/


        }

        else {
            connectivity=false;

        }
        return connectivity;

    }


}
