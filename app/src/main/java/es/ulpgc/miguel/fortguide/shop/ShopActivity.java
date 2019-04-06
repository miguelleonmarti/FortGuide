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

  // defining the button
  private Button bananaButton;

  // defining the adapter
  private ShopAdapter shopAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shop);

    bananaButton = findViewById(R.id.bananaButton);
    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });

    shopAdapter = new ShopAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        ShopItem shopItem = (ShopItem) view.getTag(); //TODO: PENSAR QUE PODEMOS HACER CUANDO PULSEMOS EN UN ITEM
        presenter.startMenuScreen();
      }
    });

    RecyclerView recyclerView = findViewById(R.id.shopList);
    recyclerView.setAdapter(shopAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    // do the setup
    ShopScreen.configure(this);

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

    // deal with the data
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        ((TextView) findViewById(R.id.shopBar)).setText("TIENDA"); //TODO: CAMBIAR A STRINGS.XML
        shopAdapter.setItems(viewModel.items);
      }
    });
  }
}
