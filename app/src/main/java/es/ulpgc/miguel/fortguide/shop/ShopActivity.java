package es.ulpgc.miguel.fortguide.shop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.ShopItem;

public class ShopActivity
    extends AppCompatActivity implements ShopContract.View {

  public static String TAG = ShopActivity.class.getSimpleName();

  private ShopContract.Presenter presenter;

  // declaring the buttons, texts and images
  private Button bananaButton;

  // declaring the adapter for the RecyclerView
  private ShopAdapter shopAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shop);

    // finding buttons, texts and images id
    bananaButton = findViewById(R.id.bananaButton);

    // listeners
    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });

    // initializing the adapter
    shopAdapter = new ShopAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.startMenuScreen();
      }
    });

    // declaring the recyclerView, finding its id and changing its adapter
    RecyclerView recyclerView = findViewById(R.id.shopList);
    recyclerView.setAdapter(shopAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    // do the setup
    ShopScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // calling the presenter in order to fetch data
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(ShopContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(final ShopViewModel viewModel) {
    Log.e(TAG, "displayData()");

    // we need to get into the main thread to display the fetched data
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        ((TextView) findViewById(R.id.shopBar)).setText(R.string.shop_bar_label);
        shopAdapter.setItems(viewModel.shopItemList);
      }
    });
  }
}
