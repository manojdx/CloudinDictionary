package com.example.clouddictionary.retrofit;



import com.example.clouddictionary.modal.DictionaryResponse;
import com.example.clouddictionary.utils.Constants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by manoj.m on may/03/2023.
 */

public interface RestMethods
{

    @GET(Constants.getDictionary+"{word}")
    Call<ArrayList<DictionaryResponse>> getDictionaryResponse(@Path("word") String word);

}