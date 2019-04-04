package es.ulpgc.miguel.fortguide.place_detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.place.PlaceActivity;

public class PlaceDetailActivity
    extends AppCompatActivity implements PlaceDetailContract.View {

  public static String TAG = PlaceDetailActivity.class.getSimpleName();

  private PlaceDetailContract.Presenter presenter;

  private Button bananaButton;
  private ImageView placeImageView;
  TextView chestNumberText;
  TextView peoplePercentTextView;
  TextView contentTextView;
  TextView detailTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_place_detail);

    bananaButton = findViewById(R.id.bananaButton);

    placeImageView = findViewById(R.id.placeImageView);
    chestNumberText = findViewById(R.id.chestNumberTextView);
    peoplePercentTextView = findViewById(R.id.peoplePercentTextView);
    contentTextView = findViewById(R.id.contentTextView);
    detailTextView = findViewById(R.id.detailTextView);

    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });

    // do the setup
    PlaceDetailScreen.configure(this);

    // do some work
    presenter.fetchPlaceDetailData();
  }


  @Override
  public void injectPresenter(PlaceDetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayPlaceDetailData(PlaceDetailViewModel viewModel) {
    Log.e(TAG, "displayPlaceDetailData()");

    // deal with the data
    ((TextView) findViewById(R.id.placeBar)).setText(R.string.place_bar_label);

  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == android.R.id.home) {
      navigateUpTo(new Intent(this, PlaceActivity.class));
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
  }
