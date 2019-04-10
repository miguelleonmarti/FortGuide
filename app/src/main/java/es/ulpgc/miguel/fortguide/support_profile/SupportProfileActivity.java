package es.ulpgc.miguel.fortguide.support_profile;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import es.ulpgc.miguel.fortguide.data.SupportItem;

public class SupportProfileActivity
    extends AppCompatActivity implements SupportProfileContract.View {

  public static String TAG = SupportProfileActivity.class.getSimpleName();

  private SupportProfileContract.Presenter presenter;

  // declaring the buttons, texts and images
  Button bananaButton;
  ImageView instagramButton, twitterButton, twitchButton, youtubeButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_support_profile);

    // finding buttons, texts and images id
    bananaButton = findViewById(R.id.bananaButton);
    instagramButton = findViewById(R.id.instagramButton);
    twitterButton = findViewById(R.id.twitterButton);
    twitchButton = findViewById(R.id.twitchButton);
    youtubeButton = findViewById(R.id.youtubeButton);

    // listeners
    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.startMenuScreen();
      }
    });
    instagramButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //String socialNetwork = (String) view.getTag(); //TODO: de que forma hago esto??
        presenter.startSocialNetworkScreen("instagram");
      }
    });
    twitterButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //String socialNetwork = (String) view.getTag();
        presenter.startSocialNetworkScreen("twitter");
      }
    });
    twitchButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //String socialNetwork = (String) view.getTag();
        presenter.startSocialNetworkScreen("twitch");
      }
    });
    youtubeButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //String socialNetwork = (String) view.getTag();
        presenter.startSocialNetworkScreen("youtube");
      }
    });
    
    // do the setup
    SupportProfileScreen.configure(this);

    // calling the presenter in order to fetch data
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(SupportProfileContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(final SupportProfileViewModel viewModel) {
    Log.e(TAG, "displayData()");
    // deal with the data
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        ((TextView) findViewById(R.id.creatorCodeText)).setText(viewModel.profile.getCode());
        loadImageFromURL((ImageView) findViewById(R.id.imageView), viewModel.profile.getImage());
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
