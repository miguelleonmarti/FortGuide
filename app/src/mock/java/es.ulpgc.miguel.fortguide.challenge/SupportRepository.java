package es.ulpgc.miguel.fortguide.challenge;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.SupportItem;

public class SupportRepository implements RepositoryContract {

  public static String TAG = SupportRepository.class.getSimpleName();

  public static final String JSON_FILE = "data.json";
  public static final String JSON_ROOT = "support";

  private static SupportRepository INSTANCE;

  private Context context;
  private List<SupportItem> supportList;

  public static RepositoryContract getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new SupportRepository(context);
    }
    return INSTANCE;
  }

  private SupportRepository(Context context) {
    this.context = context;
  }




  @Override
  public void loadSupport(final FetchSupportDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        boolean error = !loadCatalogFromJSON(loadJSONFromAsset());
        if(callback != null) {
          callback.onSupportDataFetched(error);
        }
      }
    });
  }

  @Override
  public void getSupportList(final SupportRepository.GetSupportListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if(callback != null) {
          callback.setSupportList(loadSupportList());
        }
      }
    });
  }

  @Override
  public void getSupportItem(int id, SupportRepository.GetSupportItemCallback callback) {

  }

  private boolean loadCatalogFromJSON(String json) {
    Log.e(TAG, "loadCatalogFromJSON()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

      supportList = new ArrayList();

      if (jsonArray.length() > 0) {

        final List<SupportItem> supportList = Arrays.asList(
            gson.fromJson(jsonArray.toString(), SupportItem[].class)
        );


        for (SupportItem supportItem: supportList) {
          insertSupportItem(supportItem);
        }

        return true;
      }

    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }

    return false;
  }



  private String loadJSONFromAsset() {
    //Log.e(TAG, "loadJSONFromAsset()");

    String json = null;

    try {

      InputStream is = context.getAssets().open(JSON_FILE);
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();
      json = new String(buffer, "UTF-8");

    } catch (IOException error) {
      Log.e(TAG, "error: " + error);
    }

    return json;
  }

  private void insertSupportItem(SupportItem supportItem) {
    supportList.add(supportItem);
  }

  private List<SupportItem> loadSupportList() {
    return this.supportList;
  }

//TODO Eiminar
@Override
public void loadWeeks(FetchWeeksDataCallback callback) {

}

  @Override
  public void getChallengeDetailList(ChallengesWeeksItem challengesWeeksItem, GetChallengeDetailListCallback callback) {

  }

  @Override
  public void getChallengeDetailList(int weeksId, GetChallengeDetailListCallback callback) {

  }

  @Override
  public void getChallengeDetails(int id, GetChallengeDetailCallback callback) {

  }

  @Override
  public void getWeeksList(GetWeeksListCallback callback) {

  }

  @Override
  public void getWeeksItem(int id, GetWeeksItemCallback callback) {

  }

}
