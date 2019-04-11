package es.ulpgc.miguel.fortguide.app;

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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
  private List<WeaponItem> weaponList;
  private List<TheoryItem> theoryList;
  private boolean serverStatus;

  public static RepositoryContract getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new AppRepository(context);
    }
    return INSTANCE;
  }

  private AppRepository(Context context) {
    this.context = context;
  }

  // the next three methods are essential for the correct functionality of the repository

  /**
   * This method load the archive JSON from the folder assets
   *
   * @return String json: The JSON archive converted to String
   */
  private String loadJSONFromAsset() {
    Log.e(TAG, "loadJSONFromAsset()");

    String json = null;

    try {

      InputStream is = context.getAssets().open(JSON_FILE);
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();
      json = new String(buffer, StandardCharsets.UTF_8);

    } catch (IOException error) {
      Log.e(TAG, "error: " + error);
    }

    return json;
  }

  // These two methods are common to shop and weapon activities

  /**
   * -
   *
   * @param rd BufferedReader
   * @return jsonText
   * @throws IOException because of 'rd.read'
   */
  private String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  /**
   * -
   *
   * @param url api
   * @return jsonObject
   * @throws IOException   because of 'readAll(rd)' and 'URL'
   * @throws JSONException because of 'JSONObject'
   */
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

  // the next 6 methods correspond to Support screens

  /**
   * This method load the data needed in the Support screens
   *
   * @param json The archive JSON converted to String
   * @return boolean that indicate if the load was successful
   */
  private boolean loadSupportFromJSON(String json) {
    Log.e(TAG, "loadSupportFromJSON()");
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT_SUPPORT);
      supportList = new ArrayList<>();
      if (jsonArray.length() > 0) {
        final SupportItem[] supportList = gson.fromJson(jsonArray.toString(), SupportItem[].class);
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

  /**
   * @param callback needed because of async method
   */
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

  /**
   * @param callback needed because of async method
   */
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

  /**
   * @param id of the SupportItem
   * @param callback needed because of async method
   */
  @Override
  public void getSupportItem(int id, AppRepository.GetSupportItemCallback callback) {

  } //TODO: NO ESTA IMPLEMENTADO AUNQUE NO HACE FALTA

  /**
   * @param supportItem a new item
   */
  private void insertSupportItem(SupportItem supportItem) {
    supportList.add(supportItem);
  }

  /**
   * @return the supportList
   */
  private List<SupportItem> loadSupportList() {
    return this.supportList;
  }

  // The next 12 methods correspond to Challenge screens

  /**
   * This method load the data needed in the Challenge Screens
   *
   * @param json The archive JSON converted to String
   * @return boolean that indicate if the load was successful
   */
  private boolean loadWeeksFromJSON(String json) {
    Log.e(TAG, "loadWeeksFromJSON()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT_CHALLENGE);
      challengeList = new ArrayList<>();
      if (jsonArray.length() > 0) {
        final ChallengesWeeksItem[] weeksList = gson.fromJson(jsonArray.toString(), ChallengesWeeksItem[].class);
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
  }

  /**
   * @param callback needed because of async method
   */
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

  /**
   * @param challengesWeeksItem challenges of a week
   * @param callback needed because of async method
   */
  @Override
  public void getChallengeDetailList(ChallengesWeeksItem challengesWeeksItem, GetChallengeDetailListCallback callback) {
    getChallengeDetailList(challengesWeeksItem.getId(), callback);
  }

  /**
   * @param weeksId in order to do more efficient searches
   * @param callback needed because of async method
   */
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

  /**
   * @param id in order to do more efficient searches
   * @param callback needed because of async method
   */
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

  /**
   * @param callback needed because of async method
   */
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

  /**
   * @param id in order to do more efficient searches
   * @param callback needed because of async method
   */
  @Override
  public void getWeeksItem(final int id, final GetWeeksItemCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setWeeksItem(loadChallengesWeeksItem(id));
        }
      }
    });
  }

  /**
   * @param weeksId in order to do more efficient searches
   * @return the list of challenges
   */
  private List<ChallengeItem> loadChallenges(int weeksId) {
    List<ChallengeItem> challenges = new ArrayList();

    for (ChallengesWeeksItem challengesWeeksItem : challengeList) {
      if (challengesWeeksItem.getId() == weeksId) {
        challenges = challengesWeeksItem.getItems();
      }
    }
    return challenges;
  }

  /**
   * @param id bacause is the primary key of a challengeItem
   * @return the challengeItem
   */
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

  /**
   * @param id because is the primary key of a challengesWeeksItem
   * @return the challengesWeeksItem or null if it does not exist
   */
  private ChallengesWeeksItem loadChallengesWeeksItem(int id) {
    for (ChallengesWeeksItem challengesWeeksItem : challengeList) {
      if (challengesWeeksItem.getId() == id) {
        return challengesWeeksItem;
      }
    }
    return null;
  }

  /**
   * @param challengesWeeksItem a new challengesWeeksItem
   */
  private void insertWeeksItem(ChallengesWeeksItem challengesWeeksItem) {
    challengeList.add(challengesWeeksItem);
  }

  /**
   * @return the list of challengesWeeksItem
   */
  private List<ChallengesWeeksItem> loadWeeksList() {
    return challengeList;
  }

  // the next 6 methods correspond to Place screens

  /**
   * This method load the data needed in the Place screens
   *
   * @param json The archive JSON converted to String
   * @return boolean that indicate if the load was successful
   */
  private boolean loadPlaceFromJSON(String json) {
    Log.e(TAG, "loadPlaceFromJSON()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT_PLACE);
      placeList = new ArrayList<>();
      if (jsonArray.length() > 0) {
        final PlaceItem[] placeList = gson.fromJson(jsonArray.toString(), PlaceItem[].class);
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

  /**
   * @param callback needed because of async method
   */
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

  /**
   * @param callback needed because of async method
   */
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

  /**
   * @param id because is the primary key of a challengesWeeksItem
   * @param callback needed because of async method
   */
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

  /**
   * @param placeItem a new placeItem
   */
  private void insertPlaceItem(PlaceItem placeItem) {
    placeList.add(placeItem);
  }

  /**
   * @return
   */
  private List<PlaceItem> loadPlaceList() {
    return this.placeList;
  }

  //The next 6 methods correspond to Advice screens

  /**
   * This method load the data needed in the Advice screens
   *
   * @param json The archive JSON converted to String
   * @return boolean that indicate if the load was successful
   */
  private boolean loadAdviceFromJSON(String json) {
    Log.e(TAG, "loadPlaceFromJSON()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT_ADVICE);

      adviceList = new ArrayList();

      if (jsonArray.length() > 0) {

        final AdviceItem[] adviceList = gson.fromJson(jsonArray.toString(), AdviceItem[].class);


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

  /**
   *
   * @param callback
   */
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

  /**
   *
   * @param callback
   */
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

  /**
   *
   * @param id
   * @param callback
   */
  @Override
  public void getAdviceItem(int id, AppRepository.GetAdviceItemCallback callback) {

  } //TODO: NO ESTA IMPLEMENTADO AUNQUE NO HACE FALTA

  /**
   *
   * @param adviceItem
   */
  private void insertAdviceItem(AdviceItem adviceItem) {
    adviceList.add(adviceItem);
  }

  /**
   *
   * @return
   */
  private List<AdviceItem> loadAdviceList() {
    return this.adviceList;
  }

  //The next 6 methods correspoond to Theory screens

  /**
   * This method load the data needed in the Theory screens
   *
   * @param json The archive JSON converted to String
   * @return boolean that indicate if the load was successful
   */
  private boolean loadTheoryFromJSON(String json) {
    Log.e(TAG, "loadTheoryFromJSON()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT_THEORY);

      theoryList = new ArrayList();

      if (jsonArray.length() > 0) {

        final TheoryItem[] theoryList = gson.fromJson(jsonArray.toString(), TheoryItem[].class);


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

  /**
   *
   * @param callback
   */
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

  /**
   *
   * @param callback
   */
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

  /**
   *
   * @param id
   * @param callback
   */
  @Override
  public void getTheoryItem(int id, AppRepository.GetTheoryItemCallback callback) {

  } //TODO: NO ESTA IMPLEMENTADO AUNQUE NO HACE FALTA

  /**
   *
   * @param theoryItem
   */
  private void insertAdviceItem(TheoryItem theoryItem) {
    theoryList.add(theoryItem);
  }

  /**
   *
   * @return
   */
  private List<TheoryItem> loadTheoryList() {
    return this.theoryList;
  }

  // The next 6 methods correspond to Shop screens

  /**
   * This method load the data needed in the Shop screens
   *
   * @return boolean that indicate if the load was successful
   */
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

  /**
   *
   * @param callback
   */
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

  /**
   *
   * @param callback
   */
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

  /**
   *
   * @param id
   * @param callback
   */
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

  /**
   *
   * @return
   */
  private List<ShopItem> loadShopList() {
    return this.shopList;
  }

  /**
   *
   * @param shopItem
   */
  private void insertShopItem(ShopItem shopItem) {
    shopList.add(shopItem);
  }

  //The next 2 methods correspond to Weapon screens which are ready but not used yet

  /**
   * This method load the data needed in the Weapon Screen
   *
   * @return boolean that indicate if the load was successful
   */
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

  /**
   *
   * @param weaponItem
   */
  private void insertWeaponItem(WeaponItem weaponItem) {
    weaponList.add(weaponItem);
  }

  //The next 5 methods correspond to Status screens which are ready but not used

  /**
   *
   * @return
   */
  private boolean loadStatusFromJSON() {
    try {
      JSONObject jsonObject = readJsonFromUrl(JSON_ROOT_STATUS);
      String status = jsonObject.getString("status");
      if (status.equals("UP")) {
        setServerStatus(true);
      } else {
        setServerStatus(false);
      }
      return true;
    } catch (JSONException | IOException error) {
      Log.e(TAG, "error: " + error);
    }
    return false;
  }

  /**
   *
   * @param callback
   */
  @Override
  public void loadServerStatus(final FetchServerStatusCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        boolean error = !loadStatusFromJSON();
        callback.onServerStatusFetch(error);
      }
    });
  }

  /**
   *
   * @param callback
   */
  @Override
  public void getServerStatus(final GetServerStatusCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        callback.setStatus(isServerStatus());
      }
    });
  }

  /**
   *
   * @return
   */
  public boolean isServerStatus() {
    return serverStatus;
  }

  /**
   *
   * @param serverStatus
   */
  public void setServerStatus(boolean serverStatus) {
    this.serverStatus = serverStatus;
  }


  //The next method correspond to the english challenges which is ready but not used)

  /**
   * This method load the data needed in the Challenge Screen in English
   *
   * @return boolean that indicate if the load was successful
   */
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

}

