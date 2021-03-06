package es.ulpgc.miguel.fortguide.advice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.AdviceItem;

public class AdviceActivity
    extends AppCompatActivity implements AdviceContract.View {

  public static String TAG = AdviceActivity.class.getSimpleName();

  private AdviceContract.Presenter presenter;
  private AdviceAdapter listAdapter;

  // declaring the buttons, texts and images
  private Button bananaButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_advice);

    // finding buttons, texts and images id
    bananaButton = findViewById(R.id.bananaButton);

    // listeners
    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });

    listAdapter = new AdviceAdapter(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        AdviceItem item = (AdviceItem) view.getTag();
        presenter.selectAdviceListData(item);
      }
    });
    RecyclerView recyclerView = findViewById(R.id.adviceList);
    recyclerView.setAdapter(listAdapter);

    // do the setup
    AdviceScreen.configure(this);
    // calling the presenter in order to fetch data
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(AdviceContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(final AdviceViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        listAdapter.setItems(viewModel.adviceItemList); //Puts adviceItemList in the cells
        // of the Recycler  }
      }
    });
  }
}
