package es.ulpgc.miguel.fortguide.weapon_detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class WeaponDetailActivity
    extends AppCompatActivity implements WeaponDetailContract.View {

  public static String TAG = WeaponDetailActivity.class.getSimpleName();

  private WeaponDetailContract.Presenter presenter;

  // declaring the buttons, texts, images and spinners
  private Button bananaButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weapon_detail);

    // finding buttons, texts and images id
    bananaButton = findViewById(R.id.bananaButton);


    // listeners
    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });

    // do the setup
    WeaponDetailScreen.configure(this);

    // calling the presenter in order to fetch data
    presenter.fetchData();
  }



  @Override
  public void injectPresenter(WeaponDetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(WeaponDetailViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.weaponDetailBar)).setText(viewModel.data);
  }
}
