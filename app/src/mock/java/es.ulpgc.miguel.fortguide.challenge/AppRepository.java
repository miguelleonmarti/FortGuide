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

import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.PlaceItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.SupportItem;

public class AppRepository implements RepositoryContract {

  public static String TAG = AppRepository.class.getSimpleName();

  public static final String JSON_FILE = "data.json";
  public static final String JSON_ROOT_SUPPORT = "support";
  public static final String JSON_ROOT_PLACE = "place"; //TODO: NO SE HA IMPLEMENTADO ESTA PARTE
  public static final String JSON_ROOT_CHALLENGE = "challengesweeks";

  private static AppRepository INSTANCE;

  private Context context;
  private List<SupportItem> supportList;
  private List<PlaceItem> placeList; // TODO: NO SE HA IMPLEMENTADO ESTA PARTE
  private List<ChallengesWeeksItem> challengeList;

  public static RepositoryContract getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new AppRepository(context);
    }
    return INSTANCE;
  }

  private AppRepository(Context context) {
    this.context = context;
  }

  // support

  @Override
  public void loadSupport(final FetchSupportDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        boolean error = !loadCatalogFromJSON(loadJSONFromAsset());
        if (callback != null) {
          callback.onSupportDataFetched(error);
        }
      }
    });
  }

  @Override
  public void getSupportList(final AppRepository.GetSupportListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setSupportList(loadSupportList());
        }
      }
    });
  }

  @Override
  public void getSupportItem(int id, AppRepository.GetSupportItemCallback callback) {

  }

  private void insertSupportItem(SupportItem supportItem) {
    supportList.add(supportItem);
  }

  private List<SupportItem> loadSupportList() {
    return this.supportList;
  }

  // challenge

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
  public void getChallengeDetailList(ChallengesWeeksItem challengesWeeksItem, GetChallengeDetailListCallback callback) {
    getChallengeDetailList(challengesWeeksItem.id, callback);
  }

  @Override
  public void getChallengeDetailList(final int weeksId, final GetChallengeDetailListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setChallengeDetailList(loadChallenges(weeksId)); //TODO: FALTA EL METODO
        }
      }
    });
  }

  @Override
  public void getChallengeDetails(final int id, final GetChallengeDetailCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setChallengeDetail(loadChallenge(id));
        }
      }
    });
  }

  @Override
  public void getWeeksList(final GetWeeksListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setWeeksItemList(loadWeeksList());
        }
      }
    });
  }

  @Override
  public void getWeeksItem(final int id, final GetWeeksItemCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setWeeksItem(loadChallengesWeeksItem(id)); //TODO: FALTAN METODOS
        }
      }
    });
  }

  // loading data from JSON

  private boolean loadCatalogFromJSON(String json) {
    Log.e(TAG, "loadCatalogFromJSON()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT_SUPPORT);

      supportList = new ArrayList();

      if (jsonArray.length() > 0) {

        final List<SupportItem> supportList = Arrays.asList(
            gson.fromJson(jsonArray.toString(), SupportItem[].class)
        );


        for (SupportItem supportItem : supportList) {
          insertSupportItem(supportItem);
        }

        return true;
      }

    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }

    return false;
  }

  private boolean loadWeeksFromJSON(String json) {
    Log.e(TAG, "loadWeeksFromJSON()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT_CHALLENGE);

      challengeList = new ArrayList();

      if (jsonArray.length() > 0) {

        final List<ChallengesWeeksItem> weeksList = Arrays.asList(
            gson.fromJson(jsonArray.toString(), ChallengesWeeksItem[].class)
        );


        for (ChallengesWeeksItem challengesWeeksItem : weeksList) {
          insertWeeksItem(challengesWeeksItem); //TODO: FALTAN METODOS
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

  // TODO: REVISAR

  private List<ChallengeItem> loadChallenges(int weeksId) {
    List<ChallengeItem> challenges = new ArrayList();

    for (ChallengesWeeksItem challengesWeeksItem : challengeList) {
      if (challengesWeeksItem.id == weeksId) {
        challenges = challengesWeeksItem.items;
      }
    }
    return challenges;
  }

  private ChallengeItem loadChallenge(int id) {
    for (ChallengesWeeksItem challengesWeeksItem : challengeList) {
      for (ChallengeItem challengeItem : challengesWeeksItem.items) {
        if (challengeItem.id == id) {
          return challengeItem;
        }
      }
    }
    return null;
  }

  private ChallengesWeeksItem loadChallengesWeeksItem(int id) {
    for (ChallengesWeeksItem challengesWeeksItem : challengeList) {
      if (challengesWeeksItem.id == id) {
        return challengesWeeksItem;
      }
    }
    return null;
  }

  private void insertWeeksItem(ChallengesWeeksItem challengesWeeksItem) {
    challengeList.add(challengesWeeksItem);
  }

  private List<ChallengesWeeksItem> loadWeeksList() {
    return challengeList;
  }
}
