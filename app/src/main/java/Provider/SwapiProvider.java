package Provider;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import com.example.starwarslist.MainActivity;
import com.example.starwarslist.SwapAdapter;
import com.example.starwarslist.Task;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import Model.People;

public class SwapiProvider {
    private static final String URL_SWAPI = "https://swapi.co/api/people/";
    public ArrayList<People> list;

    public SwapiProvider(ArrayList<People> list){
        this.list = list;
    }
    public void getAllPeople(SwapAdapter p){
        Task task = new Task(list, p);

        task.execute(URL_SWAPI);

    }

}
