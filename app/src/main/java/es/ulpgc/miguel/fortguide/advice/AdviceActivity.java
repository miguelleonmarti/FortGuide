package es.ulpgc.miguel.fortguide.advice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.AdviceItem;

public class AdviceActivity
    extends AppCompatActivity implements AdviceContract.View {

  public static String TAG = AdviceActivity.class.getSimpleName();

  private AdviceContract.Presenter presenter;
  private AdviceAdapter listAdapter;
  Button bananaButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_advice);

    bananaButton = findViewById(R.id.bananaButton);

    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });

    listAdapter = new AdviceAdapter(new View.OnClickListener() { // TODO: Hacer el clicklistener

      @Override
      public void onClick(View view) {
        AdviceItem item = (AdviceItem) view.getTag();
        presenter.selectAdviceListData(item);
      }
    });
    RecyclerView recyclerView = findViewById(R.id.adviceList);
    recyclerView.setAdapter(listAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
    // do the setup
    AdviceScreen.configure(this);
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
        listAdapter.setItems(viewModel.items); //Pone los items en las celdas del Recycler  }
      }
    });
    }
}
