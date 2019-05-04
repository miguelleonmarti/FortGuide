package es.ulpgc.miguel.fortguide.menu;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import es.ulpgc.miguel.fortguide.R;

public class MenuActivity
    extends AppCompatActivity implements MenuContract.View {

  public static String TAG = MenuActivity.class.getSimpleName();

  private MenuContract.Presenter presenter;

  // declaring the buttons, texts and images
  private TextView statusText,shopText,adviceText,challengeText,placeText,supportText,theoryText,weaponText;
  private LinearLayout shop,advice,challenge,place,support,theory,weapon,contact;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);

    // finding buttons, texts and images id
    advice = findViewById(R.id.advicesLayout);
    challenge = findViewById(R.id.challengesLayout);
    place = findViewById(R.id.placeLayout);
    support = findViewById(R.id.supportLayout);
    theory = findViewById(R.id.theoryLayout);
    weapon = findViewById(R.id.weaponLayout);
    shop = findViewById(R.id.shopLayout);
    contact = findViewById(R.id.contactLayout);
    adviceText = findViewById(R.id.adviceTextView);
    challengeText = findViewById(R.id.challengeTextView);
    placeText = findViewById(R.id.placeTextView);
    supportText = findViewById(R.id.supportextView);
    theoryText = findViewById(R.id.theoryTextView);
    weaponText = findViewById(R.id.weaponTextView);
    shopText = findViewById(R.id.shopTextView);


    // listeners
    shop.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v) {
        presenter.startShopScreen();
      }
    });
    advice.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startAdviceScreen();
      }
    });
    challenge.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startChallengeScreen();
      }
    });
    place.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startPlaceScreen();
      }
    });
    support.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startSupportScreen();
      }
    });
    theory.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startTheoryScreen();
      }
    });
    weapon.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startWeaponScreen();
      }
    });
    contact.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startContactScreen();
      }
    });

    // do the setup
    MenuScreen.configure(this);

    // do some work
    presenter.fetchData();
  }

  @Override
  public void onBackPressed() {
    moveTaskToBack(true);

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
