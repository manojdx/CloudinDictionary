package com.example.clouddictionary.utils;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.example.clouddictionary.modal.DictionaryResponse;

import java.util.ArrayList;


public class Constants extends MultiDexApplication {

    public Context context;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setContext(this);
    }

    public void setContext(Context con) {
        context = con;
    }

    public Context getContext() {
        return context;
    }
    public static final String BASE_URL =   "https://api.dictionaryapi.dev/api/v2/";
    public static final String getDictionary = "entries/en/";
    public static String lottiePath ="lottie_cloudin.json";

    public static ArrayList<DictionaryResponse.Phonetics> phonoticsList = new ArrayList<>();
    public static ArrayList<DictionaryResponse.Meanings> meaningList = new ArrayList<>();


}
