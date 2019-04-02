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

public class ChallengeRepository implements RepositoryContract {

  public static String TAG = ChallengeRepository.class.getSimpleName();


  public static final String JSON_FILE = "data.json";
  public static final String JSON_ROOT = "challenges";

  private static ChallengeRepository INSTANCE;

  private Context context;
  private List<ChallengesWeeksItem> weeksList;

  public static RepositoryContract getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new ChallengeRepository(context);
    }
    return INSTANCE;
  }

  private ChallengeRepository(Context context) {
    this.context = context;
  }

  @Override
  public void loadWeeks(final FetchWeeksDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        boolean error = !loadWeeksFromJSON(loadJSONFromAsset());
        if (callback != null) {
          callback.onWeeksDataFetched(error);
        }
      }
    });
  }

  @Override
  public void getWeeksList(final ChallengeRepository.GetWeeksListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setWeeksItemList(loadWeekstList());
        }
      }
    });
  }

  @Override
  public void getWeeksItem(int id, ChallengeRepository.GetWeeksItemCallback callback) {

  }

  private boolean loadWeeksFromJSON(String json) {
    Log.e(TAG, "loadWeeksFromJSON()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

      weeksList = new ArrayList();

      if (jsonArray.length() > 0) {

        final List<ChallengesWeeksItem> weeksList = Arrays.asList(
            gson.fromJson(jsonArray.toString(), ChallengesWeeksItem[].class)
        );


        for (ChallengesWeeksItem challengesWeeksItem : weeksList) {
          insertWeeksItem(challengesWeeksItem);
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

  private void insertWeeksItem(ChallengesWeeksItem challengesWeeksItem) {
    weeksList.add(challengesWeeksItem);
  }

  private List<ChallengesWeeksItem> loadWeekstList() {
    return weeksList;
  }

  // TODO: ELIMINAR
  @Override
  public void loadSupport(FetchSupportDataCallback callback) {

  }

  @Override
  public void getSupportList(GetSupportListCallback callback) {

  }

  @Override
  public void getSupportItem(int id, GetSupportItemCallback callback) {

  }
}

