package es.ulpgc.miguel.fortguide.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import es.ulpgc.miguel.fortguide.R;

public class MenuActivity
    extends AppCompatActivity implements MenuContract.View {

  public static String TAG = MenuActivity.class.getSimpleName();

  private MenuContract.Presenter presenter;

  // declaring the buttons, texts and images
  private Button adviceButton, challengeButton, placeButton, shopButton, supportButton, theoryButton, weaponButton;
  private TextView statusText;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);

    // finding buttons, texts and images id
    adviceButton = findViewById(R.id.buttonAdvice);
    challengeButton = findViewById(R.id.buttonChallenge);
    placeButton = findViewById(R.id.buttonPlace);
    shopButton = findViewById(R.id.buttonShop);
    supportButton = findViewById(R.id.buttonSupport);
    theoryButton = findViewById(R.id.buttonTheory);
    weaponButton = findViewById(R.id.buttonWeapon);

    // listeners
    adviceButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startAdviceScreen();
      }
    });
    challengeButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startChallengeScreen();
      }
    });
    placeButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startPlaceScreen();
      }
    });
    shopButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startShopScreen();
      }
    });
    supportButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startSupportScreen();
      }
    });
    theoryButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startTheoryScreen();
      }
    });
    weaponButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startWeaponScreen();
      }
    });

    // do the setup
    MenuScreen.configure(this);

    // do some work
    presenter.fetchData();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();

  }

  @Override
  public void injectPresenter(MenuContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(final MenuViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        if (viewModel.status) {
          Toast toast = Toast.makeText(getApplicationContext(), R.string.status_label_up, Toast.LENGTH_LONG);
          toast.getView().setBackgroundColor(getResources().getColor(R.color.colorThumbUp));
          toast.show();
        } else {
          Toast toast = Toast.makeText(getApplicationContext(), R.string.status_label_down, Toast.LENGTH_LONG);
          toast.getView().setBackgroundColor(getResources().getColor(R.color.colorThumbDown));
          toast.show();
        }
      }
    });

  }


}
