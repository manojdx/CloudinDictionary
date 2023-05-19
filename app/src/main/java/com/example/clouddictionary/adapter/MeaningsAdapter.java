package com.example.clouddictionary.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clouddictionary.R;
import com.example.clouddictionary.modal.DictionaryResponse;

import java.util.ArrayList;

public class MeaningsAdapter  extends RecyclerView.Adapter<MeaningsAdapter.MyviewHolder> {

    ArrayList<DictionaryResponse.Meanings> meaningsResponses;
    DictionaryResponse.Meanings meaningsResponse;
    Context context;

    public MeaningsAdapter(ArrayList<DictionaryResponse.Meanings> meaningsList,  Context context) {
        this.meaningsResponses = meaningsList;
        this.context = context;
    }

    @Override
    public MeaningsAdapter.MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.meanings_data, parent, false);
        return new MeaningsAdapter.MyviewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MeaningsAdapter.MyviewHolder holder, @SuppressLint("RecyclerView") int position) {
        meaningsResponse = meaningsResponses.get(position);

        if (meaningsResponse.getPartOfSpeech()!=null) {
            holder.part_value.setText(meaningsResponse.getPartOfSpeech());
        } else {
            holder.part_value.setText("");
        }
        if (meaningsResponse.getAntonyms()!=null) {
            holder.anto_val.setText(meaningsResponse.getAntonyms().toString());
        } else {
            holder.anto_val.setText("");
        }
        if (meaningsResponse.getDefinitions()!=null) {
            holder.def_val.setText(meaningsResponse.getDefinitions().toString());
        } else {
            holder.def_val.setText("");
        }

        if (meaningsResponse.getSynonyms()!=null) {
            holder.syn_val.setText(meaningsResponse.getSynonyms().toString());
        } else {
            holder.syn_val.setText("");
        }




    }

    @Override
    public int getItemCount() {
        return meaningsResponses.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView part_value,def_val,syn_val,anto_val;

        public MyviewHolder(View itemView) {
            super(itemView);
            part_value = itemView.findViewById(R.id.part_value);
            def_val = itemView.findViewById(R.id.def_val);
            syn_val = itemView.findViewById(R.id.syn_val);
            anto_val = itemView.findViewById(R.id.anto_val);

        }

        @Override
        public void onClick(View v) {

        }


    }

}


