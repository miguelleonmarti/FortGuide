package es.ulpgc.miguel.fortguide.app;

import android.arch.persistence.room.Room;
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
import java.net.HttpURLConnection;
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
import es.ulpgc.miguel.fortguide.database.AdviceDao;
import es.ulpgc.miguel.fortguide.database.AppDatabase;
import es.ulpgc.miguel.fortguide.database.ChallengeDao;
import es.ulpgc.miguel.fortguide.database.ChallengesWeeksDao;
import es.ulpgc.miguel.fortguide.database.PlaceDao;
import es.ulpgc.miguel.fortguide.database.ShopDao;
import es.ulpgc.miguel.fortguide.database.SupportDao;
import es.ulpgc.miguel.fortguide.database.TheoryDao;
import es.ulpgc.miguel.fortguide.database.WeaponDao;

public class AppRepository implements RepositoryContract {

  public static String TAG = AppRepository.class.getSimpleName();

  private static final String DB_FILE = "app.db";

  private static final String JSON_FILE = "data.json";

  private static final String JSON_ROOT_SUPPORT = "support";
  private static final String JSON_ROOT_PLACE = "place";
  private static final String JSON_ROOT_WEEK = "weeks";
  private static final String JSON_ROOT_CHALLENGE = "challenge";
  private static final String JSON_ROOT_ADVICE = "advice";
  private static final String JSON_ROOT_WEAPON2 = "weapon";
  private static final String JSON_ROOT_SHOP = "https://fortnite-api.theapinetwork.com/store/get";
  private static final String JSON_ROOT_WEAPON = "https://fortnite-public-api.theapinetwork.com/prod09/weapons/get";
  private static final String JSON_ROOT_STATUS = "https://fortnite-public-api.theapinetwork.com/prod09/status/fortnite_server_status";
  private static final String JSON_ROOT_ENGLISH_CHALLENGE = "https://fortnite-public-api.theapinetwork.com/prod09/challenges/get?season=current";
  private static final String JSON_ROOT_THEORY = "theory";

  private static final String PASSWORD = "d0dff89c7aee96727216cb8109fa1d74"; //API KEY

  public static AppRepository INSTANCE;

  private AppDatabase database;
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

    database = Room.databaseBuilder(context, AppDatabase.class, DB_FILE).fallbackToDestructiveMigration().build();
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
    URL apiURL = new URL(url);
    HttpURLConnection con = (HttpURLConnection) apiURL.openConnection();
    con.setRequestMethod("GET");
    con.setRequestProperty("Authorization", PASSWORD); //An authorization key is needed
    BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream(), Charset.forName("UTF-8")));
    String jsonText = readAll(rd);
    return new JSONObject(jsonText);
  }

  /*---------------------------------------------------------
  ----------------------- JSON METHODS -------------------
  ---------------------------------------------------------*/

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
          getSupportDao().insertSupport(supportItem);
        }

        return true;
      }

    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }

    return false;
  }

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
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT_WEEK);
      challengeList = new ArrayList<>();
      if (jsonArray.length() > 0) {
        final ChallengesWeeksItem[] weeksList = gson.fromJson(jsonArray.toString(), ChallengesWeeksItem[].class);
        for (ChallengesWeeksItem challengesWeeksItem : weeksList) {
          getWeeksDao().insertWeek(challengesWeeksItem);
        }
        return true;
      }

    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }

    return false;
  }

  /**
   * This method load the data needed in the Challenge Screens
   *
   * @param json The archive JSON converted to String
   * @return boolean that indicate if the load was successful
   */
  private boolean loadChallengesFromJSON(String json) {
    Log.e(TAG, "loadChallengesFromJSON()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT_CHALLENGE);
      challengeList = new ArrayList<>();
      if (jsonArray.length() > 0) {
        final ChallengeItem[] challengeList = gson.fromJson(jsonArray.toString(), ChallengeItem[].class);
        for (ChallengeItem challengeItem : challengeList) {
          getChallengesDao().insertChallenge(challengeItem);
        }
        return true;
      }

    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }

    return false;
  }

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
          getPlaceDao().insertPlace(placeItem);
        }

        return true;
      }

    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }

    return false;
  }

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

      adviceList = new ArrayList<>();

      if (jsonArray.length() > 0) {

        final AdviceItem[] adviceList = gson.fromJson(jsonArray.toString(), AdviceItem[].class);


        for (AdviceItem adviceItem : adviceList) {
          getAdviceDao().insertAdvice(adviceItem);
        }

        return true;
      }

    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }

    return false;
  }

  /**
   * @return true if the json has been loaded correctly
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

  //while the api is not operative, this method replaces the original method
  private boolean loadWeaponFromJSON2(String json) {
    Log.e(TAG, "loadWeaponFromAPI()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT_WEAPON2);

      weaponList = new ArrayList<>();

      if (jsonArray.length() > 0) {

        final WeaponItem[] weaponList = gson.fromJson(jsonArray.toString(), WeaponItem[].class);


        for (WeaponItem weaponItem : weaponList) {
          //insertAdviceItem(theoryItem);
          Log.e(TAG, weaponItem.getId());
          getWeaponDao().insertWeapon(weaponItem);
        }

        return true;
      }

    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }

    return false;
  }

  /**
   * This method load the data needed in the Weapon Screen
   *
   * @return boolean that indicate if the load was successful
   */
  private boolean loadWeaponFromAPI() {
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

        getWeaponDao().insertWeapon(new WeaponItem(id, name, rarity, image, damageBody, damageHead, dps, fireRate, reload, size, ammo));
      }
      return true;
    } catch (JSONException | IOException error) {
      Log.e(TAG, "error: " + error);
    }
    return false;
  } // it will work when the API works too

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

      theoryList = new ArrayList<>();

      if (jsonArray.length() > 0) {

        final TheoryItem[] theoryList = gson.fromJson(jsonArray.toString(), TheoryItem[].class);


        for (TheoryItem theoryItem : theoryList) {
          //insertAdviceItem(theoryItem);
          Log.e(TAG, Integer.toString(theoryItem.getId()));
          getTheoryDao().insertTheory(theoryItem);
        }

        return true;
      }

    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }

    return false;
  }

  /**
   * This method load the data needed in the Shop screens
   *
   * @return boolean that indicate if the load was successful
   */
  private boolean loadShopFromJSON() {
    try {
      JSONObject jsonObject = readJsonFromUrl(JSON_ROOT_SHOP);
      JSONArray jsonArray = jsonObject.getJSONArray("data");

      shopList = new ArrayList<>();

      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonIterator = jsonArray.getJSONObject(i);
        String content = jsonIterator.getJSONObject("item").getString("name");
        String details = jsonIterator.getJSONObject("store").getString("cost");

        JSONObject jsonObject2 = jsonIterator.getJSONObject("item").getJSONObject("images");
        String image = jsonObject2.getString("background");
        getShopDao().insertShop(new ShopItem(i, image, content, details));
      }
      return true;
    } catch (JSONException | IOException error) {
      Log.e(TAG, "error: " + error);
    }
    return false;
  }

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

  /*---------------------------------------------------------
  ----------------------- SUPPORT METHODS -------------------
  ---------------------------------------------------------*/

  private SupportDao getSupportDao() {
    return database.supportDao();
  }

  @Override
  public void loadSupport(final boolean clearFirst, final FetchSupportDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (!clearFirst) {
          database.clearAllTables();
        }
        boolean error = false;
        if (getSupportDao().loadSupport().size() == 0) {
          error = !loadSupportFromJSON(loadJSONFromAsset());
        }
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
          callback.setSupportList(getSupportDao().loadSupport());
        }
      }
    });
  }

  /*---------------------------------------------------------
  ----------------------- PLACE METHODS ---------------------
  ---------------------------------------------------------*/

  private PlaceDao getPlaceDao() {
    return database.placeDao();
  }

  @Override
  public void loadPlace(final boolean clearFirst, final FetchPlaceDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (!clearFirst) {
          database.clearAllTables();
        }
        boolean error = false;
        if (getPlaceDao().loadPlace().size() == 0) {
          error = !loadPlaceFromJSON(loadJSONFromAsset());
        }
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
          callback.setPlaceList(getPlaceDao().loadPlace());
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
          callback.setPlaceItem(placeList.get(id));
        }
      }
    });
  }

  /*---------------------------------------------------------
  ----------------------- CHALLENGE METHODS -----------------
  ---------------------------------------------------------*/

  private ChallengesWeeksDao getWeeksDao() {
    return database.weekDao();
  }

  private ChallengeDao getChallengesDao() {
    return database.challengeDao();
  }

  @Override
  public void loadWeeks(final boolean clearFirst, final FetchWeeksDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (!clearFirst) {
          database.clearAllTables();
        }
        boolean error = false;
        if (getWeeksDao().loadWeeks().size() == 0) {
          error = !loadWeeksFromJSON(loadJSONFromAsset());
        }
        if (callback != null) {
          callback.onWeeksDataFetched(error);
        }
      }
    });
  }

  @Override
  public void loadChallenges(final boolean clearFirst, final int weeksId, final FetchChallengesDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (!clearFirst) {
          database.clearAllTables();
        }
        boolean error = false;
        if (getChallengesDao().loadChallenges(weeksId).size() == 0) {
          error = !loadChallengesFromJSON(loadJSONFromAsset());
        }
        if (callback != null) {
          callback.onChallengesDataFetched(error);
        }
      }
    });
  }

  @Override
  public void getChallengeDetailList(final ChallengesWeeksItem challengesWeeksItem, final GetChallengeDetailListCallback callback) {
    getChallengeDetailList(challengesWeeksItem.getId(), callback);
  }

  @Override
  public void getChallengeDetailList(final int weeksId, final GetChallengeDetailListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setChallengeDetailList(getChallengesDao().loadChallenges(weeksId));
        }
      }
    });
  }

  // NOT IMPLEMENTED YET
  @Override
  public void getChallengeDetails(final int id, final GetChallengeDetailCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          //callback.setChallengeDetail(loadChallenge(id));
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
          callback.setWeeksItemList(getWeeksDao().loadWeeks());
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
          callback.setWeeksItem(loadChallengesWeeksItem(id));
        }
      }
    });
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

  /*---------------------------------------------------------
  ----------------------- ADVICE METHODS --------------------
  ---------------------------------------------------------*/

  private AdviceDao getAdviceDao() {
    return database.adviceDao();
  }

  @Override
  public void loadAdvice(final boolean clearFirst, final FetchAdviceDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (!clearFirst) {
          database.clearAllTables();
        }
        boolean error = false;
        if (getAdviceDao().loadAdvice().size() == 0) {
          error = !loadAdviceFromJSON(loadJSONFromAsset());
        }
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
          callback.setAdviceList(getAdviceDao().loadAdvice());
        }
      }
    });
  }

  /*---------------------------------------------------------
  ----------------------- THEORY METHODS --------------------
  ---------------------------------------------------------*/

  private TheoryDao getTheoryDao() {
    return database.theoryDao();
  }

  @Override
  public void loadTheory(final boolean clearFirst, final FetchTheoryDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (!clearFirst) {
          database.clearAllTables();
        }
        boolean error = false;
        if (getTheoryDao().loadTheory().size() == 0) {
          error = !loadTheoryFromJSON(loadJSONFromAsset());
        }
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
          callback.setTheoryList(getTheoryDao().loadTheory());
        }
      }
    });
  }

  @Override
  public void getTheoryItem(int id, GetTheoryItemCallback callback) {

  } // NOT IMPLEMENTED YET

  @Override
  public void insertTheory(final String user, final String nameTheory, final String description, final InsertTheoryCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        int id = getTheoryDao().loadTheory().size()+1;
        getTheoryDao().insertTheory(new TheoryItem(id, nameTheory, description, user, "0", "0"));
        callback.theoryInserted();
      }
    });
  }

  /*---------------------------------------------------------
  ----------------------- SHOP METHODS ----------------------
  ---------------------------------------------------------*/

  private ShopDao getShopDao() {
    return database.shopDao();
  }

  @Override
  public void loadShop(final boolean clearFirst, final FetchShopDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (clearFirst) {
          getShopDao().deleteAllShop(); // updating the table all the time (it's important)
        }
        boolean error = false;
        if (getShopDao().loadShop().size() == 0) {
          error = !loadShopFromJSON();
        }
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
          callback.setShopList(getShopDao().loadShop());
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

  /**
   * @return the shop list after fetching the data
   */
  private List<ShopItem> loadShopList() {
    return this.shopList;
  }

  /*---------------------------------------------------------
  ----------------------- WEAPON METHODS --------------------
  ---------------------------------------------------------*/

  private WeaponDao getWeaponDao() {
    return database.weaponDao();
  }

  @Override
  public void loadWeapon(final boolean clearFirst, final FetchWeaponDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (!clearFirst) {
          database.clearAllTables();
        }
        boolean error = false;
        if (getWeaponDao().loadWeapon().size() == 0) {
          //error = !loadWeaponFromAPI(); todo: cuando este disponible la API usamos este
          error = !loadWeaponFromJSON2(loadJSONFromAsset());
        }
        if (callback != null) {
          callback.onWeaponDataFetched(error);
        }
      }
    });
  }

  @Override
  public void getWeaponList(final String rarity, final AppRepository.GetWeaponListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setWeaponList(getWeaponDao().loadWeaponRarity(rarity));
        }
      }
    });
  }

  /*---------------------------------------------------------
  ----------------------- STATUS METHODS --------------------
  ---------------------------------------------------------*/

  /**
   * @param callback needed because of async method
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
   * @param callback needed because of async method
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
   * @return the server status
   */
  private boolean isServerStatus() {
    return serverStatus;
  }

  /**
   * @param serverStatus the current server status
   */
  private void setServerStatus(boolean serverStatus) {
    this.serverStatus = serverStatus;
  }
}

