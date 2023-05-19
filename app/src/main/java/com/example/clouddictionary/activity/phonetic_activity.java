package com.example.clouddictionary.activity;

import static com.example.clouddictionary.utils.Constants.phonoticsList;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clouddictionary.R;
import com.example.clouddictionary.adapter.DictionaryAdapter;
import com.example.clouddictionary.adapter.PhonoticsAdapter;
import com.example.clouddictionary.modal.DictionaryResponse;

import java.util.ArrayList;

public class phonetic_activity extends AppCompatActivity {
    ArrayList<DictionaryResponse.Phonetics> objects;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonotics_acitivity);
        recyclerView = findViewById(R.id.phonotics_recycler);
        objects = new ArrayList<>();
        objects.clear();
         objects.addAll(phonoticsList);
         gotoAdapter(objects);

    }
    private void gotoAdapter(ArrayList<DictionaryResponse.Phonetics> result) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        PhonoticsAdapter phonoticsAdapter = new PhonoticsAdapter(result,getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(phonoticsAdapter);

    }


}