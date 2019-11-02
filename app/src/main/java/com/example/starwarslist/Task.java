package com.example.starwarslist;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Adapter;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import Model.People;

public class Task extends AsyncTask<String, Void, Void> {
    private ArrayList<People> list;
    private SwapAdapter swapAdapter;
    private boolean next;
    private String nextS;

    public Task(ArrayList<People> list, SwapAdapter swapAdapter) {
        this.list = list;
        this.swapAdapter = swapAdapter;
        next = true;
    }

    @Override
    protected Void doInBackground(String... strings) {
        try {
            URL urlService = new URL(strings[0]);
            HttpsURLConnection connection = (HttpsURLConnection) urlService.openConnection();
            connection.setRequestMethod("GET");
            InputStream responseBody = connection.getInputStream();

            if (connection.getResponseCode() == 200) {
                // Success
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                BufferedReader in = new BufferedReader(responseBodyReader);
                Log.i("MARLON", "HERE");
                JSONObject obj = new JSONObject(in.readLine());


                JSONArray a = obj.getJSONArray("results");
                Gson gson = new Gson();
                for (int i = 0; i < a.length(); i++) {
                    list.add(gson.fromJson(a.get(i).toString(), People.class));
                }

                if(!obj.getString("next").equals("null")){
                    nextS = obj.getString("next");
                    next = true;
                }

            } else {
                // Error handling code goes here
                Log.v("ERROR", "ERROR");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressLint("WrongThread")
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        swapAdapter.notifyDataSetChanged();
    }
}
