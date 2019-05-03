package es.ulpgc.miguel.fortguide.weapon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
  private Button bananaButton;
  private TextView weaponBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weapon);

    // finding buttons, texts and images id
    bananaButton = findViewById(R.id.bananaButton);
    weaponBar = findViewById(R.id.weaponBar);

    // listeners
    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });

    // do the setup
    WeaponScreen.configure(this);

    // calling the presenter in order to fetch data
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(WeaponContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(WeaponViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.weaponBar)).setText(R.string.weapon_bar_label);
  }
}
