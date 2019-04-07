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

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.PlaceItem;
import es.ulpgc.miguel.fortguide.place.PlaceActivity;

public class PlaceDetailActivity
    extends AppCompatActivity implements PlaceDetailContract.View {

  public static String TAG = PlaceDetailActivity.class.getSimpleName();

  private PlaceDetailContract.Presenter presenter;

  // declaring the buttons, texts and images
  private Button bananaButton;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_place_detail);

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
    PlaceItem placeItem = viewModel.placeItem;

    // deal with the data
    ((TextView) findViewById(R.id.placeBar)).setText("LUGARES-" + viewModel.placeItem.content.toUpperCase()); //Cambiarlo a un String
    ((TextView) findViewById(R.id.contentPlaceTextView)).setText(viewModel.placeItem.content);
    ((TextView) findViewById(R.id.detailPlaceTextView)).setText(viewModel.placeItem.details);
    ((TextView) findViewById(R.id.chestNumberTextView)).setText(viewModel.placeItem.chest);
    ((TextView) findViewById(R.id.peoplePercentTextView)).setText(viewModel.placeItem.people);
    loadImageFromURL((ImageView) findViewById(R.id.placeImageView), placeItem.image);
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

  /**
   * Carga desde una URL la imagen
   *
   * @param imageView imagen en la que se guarda
   * @param imageUrl  url o ruta de la imagen
   */
  private void loadImageFromURL(ImageView imageView, String imageUrl) {
    RequestManager reqManager = Glide.with(imageView.getContext());
    RequestBuilder reqBuilder = reqManager.load(imageUrl);
    RequestOptions reqOptions = new RequestOptions();
    reqOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
    reqBuilder.apply(reqOptions);
    reqBuilder.into(imageView);
  }
}
