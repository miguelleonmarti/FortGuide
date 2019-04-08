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
  public void displayPlaceDetailData(final PlaceDetailViewModel viewModel) {
    Log.e(TAG, "displayPlaceDetailData()");

    // we need to get into the main thread to display the fetched data
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        ((TextView) findViewById(R.id.placeBar)).setText(viewModel.placeItem.getContent().toUpperCase());
        ((TextView) findViewById(R.id.contentPlaceTextView)).setText(viewModel.placeItem.getContent());
        ((TextView) findViewById(R.id.detailPlaceTextView)).setText(viewModel.placeItem.getDetails());
        ((TextView) findViewById(R.id.chestNumberTextView)).setText(viewModel.placeItem.getChest());
        ((TextView) findViewById(R.id.peoplePercentTextView)).setText(viewModel.placeItem.getPeople());
        loadImageFromURL((ImageView) findViewById(R.id.placeImageView), viewModel.placeItem.getImage());
      }
    });
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
