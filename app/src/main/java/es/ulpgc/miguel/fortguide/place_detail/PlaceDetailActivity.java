package es.ulpgc.miguel.fortguide.place_detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class PlaceDetailActivity
    extends AppCompatActivity implements PlaceDetailContract.View {

  public static String TAG = PlaceDetailActivity.class.getSimpleName();

  private PlaceDetailContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_place_detail);

    // do the setup
    PlaceDetailScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(PlaceDetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(PlaceDetailViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
  }
}
