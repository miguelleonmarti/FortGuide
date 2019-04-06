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

  // defining buttons, images and texts
  private Button bananaButton;
  private ImageView placeImage;
  private TextView chestText, peopleText, contentText, detailsText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_place_detail);

    bananaButton = findViewById(R.id.bananaButton);
    placeImage = findViewById(R.id.placeImageView);
    chestText = findViewById(R.id.chestNumberTextView);
    peopleText = findViewById(R.id.peoplePercentTextView);
    contentText = findViewById(R.id.contentPlaceTextView);
    detailsText = findViewById(R.id.detailPlaceTextView);

    // bananaButton is the only button that can be clicked on

    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });

    // do the setup
    PlaceDetailScreen.configure(this);

    // calling the presenter in order to fetch data
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
    ((TextView) findViewById(R.id.placeBar)).setText(R.string.place_bar_label + viewModel.placeItem.content);
    ((TextView) findViewById(R.id.contentPlaceTextView)).setText(viewModel.placeItem.content);
    ((TextView) findViewById(R.id.detailPlaceTextView)).setText(viewModel.placeItem.details);
    ((TextView) findViewById(R.id.chestNumberTextView)).setText(viewModel.placeItem.chest);
    ((TextView) findViewById(R.id.peoplePercentTextView)).setText(viewModel.placeItem.people);

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
