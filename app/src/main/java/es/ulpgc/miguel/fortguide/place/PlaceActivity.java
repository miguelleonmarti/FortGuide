package es.ulpgc.miguel.fortguide.place;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.PlaceItem;

public class PlaceActivity
    extends AppCompatActivity implements PlaceContract.View {

  public static String TAG = PlaceActivity.class.getSimpleName();

  private PlaceContract.Presenter presenter;

  // declaring the buttons, texts and images
  private Button bananaButton;

  // declaring the adapter for the RecyclerView
  private PlaceAdapter placeAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_place);

    // finding buttons, texts and images id
    bananaButton = findViewById(R.id.bananaButton);

    // listeners
    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.startMenuScreen();
      }
    });

    // initializing the adapter
    placeAdapter = new PlaceAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        PlaceItem placeItem = (PlaceItem) view.getTag();
        presenter.selectPlaceListData(placeItem);
      }
    });

    // declaring the recyclerView, finding its id and changing its adapter
    RecyclerView recyclerView = findViewById(R.id.placeList);
    recyclerView.setAdapter(placeAdapter);
    recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); //TODO: CAMBIAR EL NUMERO DE COLUMNAS O NO?

    // do the setup
    PlaceScreen.configure(this);

    // calling the presenter in order to fetch data
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(PlaceContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(final PlaceViewModel viewModel) {
    Log.e(TAG, "displayData()");

    // we need to get into the main thread to display the fetched data
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        ((TextView) findViewById(R.id.placeBar)).setText(R.string.place_text_label);
        placeAdapter.setItems(viewModel.places);
      }
    });
  }
}
