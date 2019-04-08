package es.ulpgc.miguel.fortguide.challenge;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.AdviceItem;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.PlaceItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.ShopItem;
import es.ulpgc.miguel.fortguide.data.SupportItem;
import es.ulpgc.miguel.fortguide.data.TheoryItem;
import es.ulpgc.miguel.fortguide.data.WeaponItem;

public class AppRepository implements RepositoryContract {

  public static String TAG = AppRepository.class.getSimpleName();

  private static final String JSON_FILE = "data.json";
  private static final String JSON_ROOT_SUPPORT = "support";
  private static final String JSON_ROOT_PLACE = "place";
  private static final String JSON_ROOT_CHALLENGE = "challenge";
  private static final String JSON_ROOT_ADVICE = "advice";
  private static final String JSON_ROOT_SHOP = "https://fortnite-public-api.theapinetwork.com/prod09/store/get?language=en";
  private static final String JSON_ROOT_WEAPON = "https://fortnite-public-api.theapinetwork.com/prod09/weapons/get";
  private static final String JSON_ROOT_STATUS = "https://fortnite-public-api.theapinetwork.com/prod09/status/fortnite_server_status";
  private static final String JSON_ROOT_ENGLISH_CHALLENGE = "https://fortnite-public-api.theapinetwork.com/prod09/challenges/get?season=current";
  private static final String JSON_ROOT_THEORY = "theory";

  public static AppRepository INSTANCE;

  private Context context;
  private List<SupportItem> supportList;
  private List<PlaceItem> placeList;
  private List<ChallengesWeeksItem> challengeList;
  private List<AdviceItem> adviceList;
  private List<ShopItem> shopList;
  private List<WeaponItem> weaponList; //TODO: FALTA USARLO PARA RECOPILAR LOS DATOS
  private List<TheoryItem> theoryList;

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
    getChallengeDetailList(challengesWeeksItem.getId(), callback);
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
      if (challengesWeeksItem.getId() == weeksId) {
        challenges = challengesWeeksItem.getItems();
      }
    }
    return challenges;
  }

  private ChallengeItem loadChallenge(int id) {
    for (ChallengesWeeksItem challengesWeeksItem : challengeList) {
      for (ChallengeItem challengeItem : challengesWeeksItem.getItems()) {
        if (challengeItem.getId() == id) {
          return challengeItem;
        }
      }
    }
    return null;
  }

  private ChallengesWeeksItem loadChallengesWeeksItem(int id) {
    for (ChallengesWeeksItem challengesWeeksItem : challengeList) {
      if (challengesWeeksItem.getId() == id) {
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
        if (callback != null) {
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
        if (callback != null) {
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
          insertWeeksItem(challengesWeeksItem);
        }
        for (ChallengesWeeksItem challengesWeeksItem : weeksList) {
          for (ChallengeItem challengeItem : challengesWeeksItem.getItems()) {
            challengeItem.setWeeksId(challengesWeeksItem.getId());
          }
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

  private boolean loadTheoryFromJSON(String json) {
    Log.e(TAG, "loadPlaceFromJSON()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT_THEORY);

      theoryList = new ArrayList();

      if (jsonArray.length() > 0) {

        final List<TheoryItem> adviceList = Arrays.asList(
            gson.fromJson(jsonArray.toString(), TheoryItem[].class)
        );


        for (TheoryItem theoryItem : theoryList) {
          insertAdviceItem(theoryItem);
        }

        return true;
      }

    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }

    return false;
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

  // shop

  @Override
  public void loadShop(final FetchShopDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        boolean error = !loadShopFromJSON();
        if (callback != null) {
          callback.onShopDataFetched(error);
        }
      }
    });
  }

  @Override
  public void getShopList(final AppRepository.GetShopListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setShopList(loadShopList());
        }
      }
    });
  }

  @Override
  public void getShopItem(final int id, final AppRepository.GetShopItemCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setShopItem(loadShopList().get(id));
        }
      }
    });
  }

  private List<ShopItem> loadShopList() {
    return this.shopList;
  }

  private boolean loadShopFromJSON() {
    try {
      JSONObject jsonObject = readJsonFromUrl(JSON_ROOT_SHOP);
      JSONArray jsonArray = jsonObject.getJSONArray("items");

      shopList = new ArrayList<>();

      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonIterator = jsonArray.getJSONObject(i);
        String id = jsonIterator.getString("itemid");
        String content = jsonIterator.getString("name");
        String details = jsonIterator.getString("cost");

        JSONObject jsonObject2 = jsonIterator.getJSONObject("item").getJSONObject("images");
        String image = jsonObject2.getString("background");
        insertShopItem(new ShopItem(id, image, content, details));
      }
      return true;
    } catch (JSONException | IOException error) {
      Log.e(TAG, "error: " + error);
    }
    return false;
  }

  private void insertShopItem(ShopItem shopItem) {
    shopList.add(shopItem);
  }

  // weapon (ready but not used)

  private boolean loadWeaponFromJSON() {
    try {
      JSONObject jsonObject = readJsonFromUrl(JSON_ROOT_WEAPON);
      JSONArray jsonArray = jsonObject.getJSONArray("weapons");

      weaponList = new ArrayList<>();

      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject weapon = jsonArray.getJSONObject(i);
        JSONObject images = weapon.getJSONObject("images");
        JSONObject stats = weapon.getJSONObject("stats");
        JSONObject damage = stats.getJSONObject("damage");
        JSONObject magazine = stats.getJSONObject("magazine");

        String id = weapon.getString("hash");
        String name = weapon.getString("name");
        String rarity = weapon.getString("rarity");
        String image = images.getString("image");
        String damageBody = damage.getString("body");
        String damageHead = damage.getString("head");
        String dps = stats.getString("dps");
        String fireRate = stats.getString("firerate");
        String reload = magazine.getString("reload");
        String size = magazine.getString("size");
        String ammo = stats.getString("ammocost");

        insertWeaponItem(new WeaponItem(id, name, rarity, image, damageBody, damageHead, dps, fireRate, reload, size, ammo));
      }
      return true;
    } catch (JSONException | IOException error) {
      Log.e(TAG, "error: " + error);
    }
    return false;
  }

  private void insertWeaponItem(WeaponItem weaponItem){
    weaponList.add(weaponItem);
  }

  // status (prepared but not used)

  private boolean loadStatusFromJSON() {
    try {
      JSONObject jsonObject = readJsonFromUrl(JSON_ROOT_STATUS);
      String status = jsonObject.getString("status");
      //TODO: UTILIZAR EL STRING STATUS
      return true;
    } catch (JSONException | IOException error) {
      Log.e(TAG, "error: " + error);
    }
    return false;
  }

  // english challenges (ready but not used)

  private boolean loadEnglishChallengesFromJSON() {
    try {
      JSONObject JSON = readJsonFromUrl(JSON_ROOT_ENGLISH_CHALLENGE);
      String season = JSON.getString("season");
      String currentWeek = JSON.getString("currentweek");
      JSONObject challenges = JSON.getJSONObject("challenges");
      for (int i = 0; i < challenges.length(); i++) {
        JSONArray WEEK = challenges.getJSONArray("week" + (i + 1));
        if (WEEK.length() != 0) {
          for (int j = 0; j < WEEK.length(); j++) {
            JSONObject CHALLENGE = WEEK.getJSONObject(j);
            String identifier = CHALLENGE.getString("identifier");
            String challenge = CHALLENGE.getString("challenge");
            String total = CHALLENGE.getString("total");
            String stars = CHALLENGE.getString("stars");
            String difficulty = CHALLENGE.getString("difficulty");

            // change this line to include an object in a list with these attributes
            // season, currentWeek, identifier, challenge, total, stars and difficulty

          }
        }
      }

      return true;
    } catch (JSONException | IOException error) {
      Log.e(TAG, "error: " + error);
    }
    return false;
  }


  // common (shop and weapon)

  private String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  private JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

  //theory

  @Override
  public void loadTheory(final FetchTheoryDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        boolean error = !loadTheoryFromJSON(loadJSONFromAsset());
        if (callback != null) {
          callback.onTheoryDataFetched(error);
        }
      }
    });
  }

  @Override
  public void getTheoryList(final AppRepository.GetTheoryListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setTheoryList(loadTheoryList());
        }
      }
    });
  }

  @Override
  public void getTheoryItem(int id, AppRepository.GetTheoryItemCallback callback) {

  } //TODO: NO ESTA IMPLEMENTADO AUNQUE NO HACE FALTA

  private void insertAdviceItem(TheoryItem theoryItem) {
    theoryList.add(theoryItem);
  }

  private List<TheoryItem> loadTheoryList() {
    return this.theoryList;
  }
}
