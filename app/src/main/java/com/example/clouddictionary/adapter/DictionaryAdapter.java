package com.example.clouddictionary.adapter;

import static com.example.clouddictionary.utils.Constants.meaningList;
import static com.example.clouddictionary.utils.Constants.phonoticsList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clouddictionary.R;
import com.example.clouddictionary.activity.meaning_activity;
import com.example.clouddictionary.activity.phonetic_activity;
import com.example.clouddictionary.modal.DictionaryResponse;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DictionaryAdapter extends RecyclerView.Adapter<DictionaryAdapter.MyviewHolder> {

    ArrayList<DictionaryResponse> dictionaryResponses;
    DictionaryResponse dictionaryResponse;
    Context context;

    public DictionaryAdapter(ArrayList<DictionaryResponse> dictList,  Context context) {
        this.dictionaryResponses = dictList;
        this.context = context;
    }

    public void updateData() {
        dictionaryResponses.clear();
        notifyDataSetChanged();
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_details_data, parent, false);
        return new MyviewHolder(itemView);
    }


    @Override
    public void onBindViewHolder( MyviewHolder holder, @SuppressLint("RecyclerView") int position) {
        dictionaryResponse = dictionaryResponses.get(position);
        holder.text_value.setText(dictionaryResponse.getWord());
        holder.tv_meanings_name.setText(dictionaryResponse.getLicense().getName());
        holder.tv_url_name.setText(dictionaryResponse.getLicense().getUrl());
        holder.tv_sourceUrl_name.setText(dictionaryResponse.getSourceUrls().toString());
        //holder.count.setText(position+1);
    }

        @Override
    public int getItemCount() {
        return dictionaryResponses.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView text_value,count,tv_meanings_name,tv_url_name,tv_sourceUrl_name;
        CardView phoetics_card_layout,meanings_card_layout,license_card_layout,sourceUrl_card_layout;
        ConstraintLayout licence_info,sourceUrl_info;
        public MyviewHolder(View itemView) {
            super(itemView);
            tv_meanings_name = itemView.findViewById(R.id.tv_meanings_name);
            tv_url_name = itemView.findViewById(R.id.tv_url_name);
            tv_sourceUrl_name = itemView.findViewById(R.id.tv_sourceUrl_name);
            text_value = itemView.findViewById(R.id.text_value);
            phoetics_card_layout = itemView.findViewById(R.id.phoetics_card_layout);
            meanings_card_layout = itemView.findViewById(R.id.meanings_card_layout);
            license_card_layout = itemView.findViewById(R.id.license_card_layout);
            sourceUrl_card_layout = itemView.findViewById(R.id.sourceUrl_card_layout);
            licence_info = itemView.findViewById(R.id.licence_info);
            sourceUrl_info = itemView.findViewById(R.id.sourceUrl_info);
            count = itemView.findViewById(R.id.count);
            phoetics_card_layout.setOnClickListener(this);
            meanings_card_layout.setOnClickListener(this);
            license_card_layout.setOnClickListener(this);
            sourceUrl_card_layout.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.phoetics_card_layout:
                    phonoticsList.clear();
                    phonoticsList.addAll(dictionaryResponse.getPhonetics());
                    Intent phonotic = new Intent(context, phonetic_activity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(phonotic);
                    break;
                case R.id.meanings_card_layout:
                    meaningList.clear();
                    meaningList.addAll(dictionaryResponse.getMeanings());
                    Intent meanigs = new Intent(context, meaning_activity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(meanigs);
                    break;
                case R.id.license_card_layout:
                    if (licence_info.getVisibility()== View.VISIBLE) {
                        licence_info.setVisibility(View.GONE);
                    } else {
                        licence_info.setVisibility(View.VISIBLE);
                    }
                    break;
                case R.id.sourceUrl_card_layout:
                    if (sourceUrl_info.getVisibility()== View.VISIBLE) {
                        sourceUrl_info.setVisibility(View.GONE);
                    } else {
                        sourceUrl_info.setVisibility(View.VISIBLE);
                    }
                    break;


            }
        }
    }

}
