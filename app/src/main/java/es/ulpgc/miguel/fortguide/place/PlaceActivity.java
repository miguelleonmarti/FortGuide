package es.ulpgc.miguel.fortguide.place;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.PlaceItem;

public class PlaceActivity
    extends AppCompatActivity implements PlaceContract.View {

  public static String TAG = PlaceActivity.class.getSimpleName();

  private PlaceContract.Presenter presenter;

  private Button bananaButton;

  private PlaceAdapter placeAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_place);

    bananaButton = findViewById(R.id.bananaButton);

    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.startMenuScreen();
      }
    });

    placeAdapter = new PlaceAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        PlaceItem placeItem = (PlaceItem) view.getTag();
        presenter.selectPlaceListData(placeItem);
      }
    });

    RecyclerView recyclerView = findViewById(R.id.placeList);
    recyclerView.setAdapter(placeAdapter);
    recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); //TODO: CAMBIAR EL NUMERO DE COLUMNAS O NO?


    // do the setup
    PlaceScreen.configure(this);

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(PlaceContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(final PlaceViewModel viewModel) {
    Log.e(TAG, "displayData()");
    // deal with the data
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        ((TextView) findViewById(R.id.placeBar)).setText("LUGARES"); //TODO: CAMBIAR POR EL STRINGS.XML
        placeAdapter.setItems(viewModel.places);
      }
    });
  }
}
