package es.ulpgc.miguel.fortguide.weapon;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class WeaponActivity
    extends AppCompatActivity implements WeaponContract.View {

  public static String TAG = WeaponActivity.class.getSimpleName();

  private WeaponContract.Presenter presenter;

  // declaring the buttons, texts, images and spinners
  private Button bananaButton, commonRarityButton, uncommonRarityButton, rareRarityButton, epicRarityButton, legendaryRarityButton;
  private TextView weaponBar;
  private WeaponAdapter weaponAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weapon);

    // finding buttons, texts and images id
    bananaButton = findViewById(R.id.bananaButton);
    weaponBar = findViewById(R.id.weaponBar);
    commonRarityButton = findViewById(R.id.commonRarityButton);
    uncommonRarityButton = findViewById(R.id.uncommonRarityButton);
    rareRarityButton = findViewById(R.id.rareRarityButton);
    epicRarityButton = findViewById(R.id.epicRarityButton);
    legendaryRarityButton = findViewById(R.id.legendaryRarityButton);

    // listeners
    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.startMenuScreen();
      }
    });
    commonRarityButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.fetchData("common");
      }
    });
    uncommonRarityButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.fetchData("uncommon");
      }
    });
    rareRarityButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.fetchData("rare");
      }
    });
    epicRarityButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.fetchData("uncommon");
      }
    });
    legendaryRarityButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.fetchData("legendary");
      }
    });

    // initializing the adapter
    weaponAdapter = new WeaponAdapter();

    // declaring the recyclerView, finding its id and changing its adapter
    RecyclerView recyclerView = findViewById(R.id.weaponList);
    recyclerView.setAdapter(weaponAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    // do the setup
    WeaponScreen.configure(this);

    // calling the presenter in order to fetch data
    //presenter.fetchData(); todo: recuperar estado al girar la pantalla
  }

  @Override
  public void injectPresenter(WeaponContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(final WeaponViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data

    // we need to get into the main thread to display the fetched data
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        ((TextView) findViewById(R.id.weaponBar)).setText(R.string.weapon_bar_label);
        weaponAdapter.setItems(viewModel.weaponItemList);
      }
    });
  }
}
