package com.example.clouddictionary.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clouddictionary.R;
import com.example.clouddictionary.activity.meaning_activity;
import com.example.clouddictionary.activity.phonetic_activity;
import com.example.clouddictionary.modal.DictionaryResponse;

import java.util.ArrayList;

public class PhonoticsAdapter extends RecyclerView.Adapter<PhonoticsAdapter.MyviewHolder> {

    ArrayList<DictionaryResponse.Phonetics> phonoyicsResponses;
    DictionaryResponse.Phonetics phonotResponse;
    Context context;

    public PhonoticsAdapter(ArrayList<DictionaryResponse.Phonetics> phonoList,  Context context) {
        this.phonoyicsResponses = phonoList;
        this.context = context;
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.phonotics_data, parent, false);
        return new MyviewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(PhonoticsAdapter.MyviewHolder holder, @SuppressLint("RecyclerView") int position) {
        phonotResponse = phonoyicsResponses.get(position);

        if(phonotResponse.getLicense()!=null){
            if (phonotResponse.getLicense().getName()!=null) {
                holder.name_val.setText(phonotResponse.getLicense().getName());
            } else {
                holder.name_val.setText("");
            }
            if(phonotResponse.getLicense().getUrl()!=null){
                holder.phonotic_web.loadUrl(phonotResponse.getLicense().getUrl());
            } else {
                holder.phonotic_web.loadUrl("");
            }

        } else {
            holder.name_val.setText("");
            holder.phonotic_web.loadUrl("");

        }
        if (phonotResponse.getSourceUrl()!=null) {
            holder.license_web.loadUrl(phonotResponse.getSourceUrl());
        } else {
            holder.license_web.loadUrl("");
        }

    }

    @Override
    public int getItemCount() {
        return phonoyicsResponses.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView phono_url,name_val;
        ImageButton imageButton;
        AppCompatButton viewMore;
        WebView phonotic_web,license_web;
        RelativeLayout phonotic_web_layout,license_web_layout;

        public MyviewHolder(View itemView) {
            super(itemView);
            viewMore = itemView.findViewById(R.id.viewMore);
            imageButton = itemView.findViewById(R.id.imageButton);
            phonotic_web = itemView.findViewById(R.id.phonotic_web);

            WebSettings mWebSettings = phonotic_web.getSettings();
            mWebSettings.setBuiltInZoomControls(true);
            phonotic_web.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            phonotic_web.setScrollbarFadingEnabled(false);

            license_web = itemView.findViewById(R.id.license_web);
            WebSettings mWebSettings1 = license_web.getSettings();
            mWebSettings1.setBuiltInZoomControls(true);
            license_web.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            license_web.setScrollbarFadingEnabled(false);

            imageButton.setOnClickListener(this);
            phonotic_web_layout = itemView.findViewById(R.id.phonotic_web_layout);
            phonotic_web_layout.setOnClickListener(this);
            phono_url = itemView.findViewById(R.id.phono_url);
            phonotic_web.setVerticalScrollBarEnabled(true);
            license_web.setVerticalScrollBarEnabled(true);
            phono_url.setOnClickListener(this);
            license_web_layout = itemView.findViewById(R.id.license_web_layout);
            name_val = itemView.findViewById(R.id.name_val);
            viewMore.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.imageButton:
                    gotoMusic();
                    break;
                case R.id.phono_url:
                    if (phonotic_web_layout.getVisibility()== View.VISIBLE) {
                        phonotic_web_layout.setVisibility(View.GONE);
                    } else {
                        phonotic_web_layout.setVisibility(View.VISIBLE);
                    }
                    break;
                case R.id.viewMore:
                    if (license_web_layout.getVisibility()== View.VISIBLE) {
                        license_web_layout.setVisibility(View.GONE);
                    } else {
                        license_web_layout.setVisibility(View.VISIBLE);
                    }
                    break;
            }
        }

        private void gotoMusic() {
            try {
                String url = phonoyicsResponses.get(getAdapterPosition()).getAudio(); // your URL here
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                 mediaPlayer.setDataSource(url);
                mediaPlayer.prepare(); // might take long! (for buffering, etc)
                mediaPlayer.start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}

