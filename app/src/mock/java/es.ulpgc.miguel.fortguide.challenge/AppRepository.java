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

import es.ulpgc.miguel.fortguide.data.AdviceItem;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.PlaceItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.SupportItem;

public class AppRepository implements RepositoryContract {

  public static String TAG = AppRepository.class.getSimpleName();

  private static final String JSON_FILE = "data.json";
  private static final String JSON_ROOT_SUPPORT = "support";
  private static final String JSON_ROOT_PLACE = "place";
  private static final String JSON_ROOT_CHALLENGE = "challenge";
  private static final String JSON_ROOT_ADVICE = "advice";

  public static AppRepository INSTANCE;

  private Context context;
  private List<SupportItem> supportList;
  private List<PlaceItem> placeList;
  private List<ChallengesWeeksItem> challengeList;
  private List<AdviceItem> adviceList;

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
        boolean error = !loadSupportFromJSON(loadJSONFromAsset());
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

  } //TODO: NO ESTA IMPLEMENTADO AUNQUE NO HACE FALTA

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

  // place

  @Override
  public void loadPlace(final FetchPlaceDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        boolean error = !loadPlaceFromJSON(loadJSONFromAsset());
        if (callback!=null) {
          callback.onPlaceDataFetched(error);
        }
      }
    });
  }

  @Override
  public void getPlaceList(final GetPlaceListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setPlaceList(loadPlaceList());
        }
      }
    });
  }

  @Override
  public void getPlaceItem(final int id, final GetPlaceItemCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback!=null) {
          callback.setPlaceItem(supportList.get(id));
        }
      }
    });
  } //TODO: ESTA IMPLEMENTADO PERO NO HACE FALTA

  private void insertPlaceItem(PlaceItem placeItem) {
    placeList.add(placeItem);
  }

  private List<PlaceItem> loadPlaceList() {
    return this.placeList;
  }

  // loading data from JSON

  private boolean loadSupportFromJSON(String json) {
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
  } //TODO: CAMBIAR NOMBRE

  private boolean loadPlaceFromJSON(String json) {
    Log.e(TAG, "loadPlaceFromJSON()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT_PLACE);

      placeList = new ArrayList();

      if (jsonArray.length() > 0) {

        final List<PlaceItem> placeList = Arrays.asList(
            gson.fromJson(jsonArray.toString(), PlaceItem[].class)
        );


        for (PlaceItem placeItem : placeList) {
          insertPlaceItem(placeItem);
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
  } //TODO: CAMBIAR NOMBRE

  private boolean loadAdviceFromJSON(String json) {
    Log.e(TAG, "loadPlaceFromJSON()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT_ADVICE);

      adviceList = new ArrayList();

      if (jsonArray.length() > 0) {

        final List<AdviceItem> adviceList = Arrays.asList(
            gson.fromJson(jsonArray.toString(), AdviceItem[].class)
        );


        for (AdviceItem adviceItem : adviceList) {
          insertAdviceItem(adviceItem);
        }

        return true;
      }

    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }

    return false;
  }

  private String loadJSONFromAsset() {
    Log.e(TAG, "loadJSONFromAsset()");

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

  //advice


  @Override
  public void loadAdvice(final FetchAdviceDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        boolean error = !loadAdviceFromJSON(loadJSONFromAsset());
        if (callback != null) {
          callback.onAdviceDataFetched(error);
        }
      }
    });
  }

  @Override
  public void getAdviceList(final AppRepository.GetAdviceListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setAdviceList(loadAdviceList());
        }
      }
    });
  }

  @Override
  public void getAdviceItem(int id, AppRepository.GetAdviceItemCallback callback) {

  } //TODO: NO ESTA IMPLEMENTADO AUNQUE NO HACE FALTA

  private void insertAdviceItem(AdviceItem adviceItem) {
    adviceList.add(adviceItem);
  }

  private List<AdviceItem> loadAdviceList() {
    return this.adviceList;
  }

}
