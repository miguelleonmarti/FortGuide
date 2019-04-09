package es.ulpgc.miguel.fortguide.weapon_detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class WeaponDetailActivity
    extends AppCompatActivity implements WeaponDetailContract.View {

  public static String TAG = WeaponDetailActivity.class.getSimpleName();

  private WeaponDetailContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weapon_detail);

    // do the setup
    WeaponDetailScreen.configure(this);

    // do some work
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
    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
  }
}
