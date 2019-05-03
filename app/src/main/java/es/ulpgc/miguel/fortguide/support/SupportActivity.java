package es.ulpgc.miguel.fortguide.support;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.SupportItem;

public class SupportActivity
    extends AppCompatActivity implements SupportContract.View {

  public static String TAG = SupportActivity.class.getSimpleName();

  private SupportContract.Presenter presenter;

  // declaring the buttons, texts and images
  private Button bananaButton;

  // declaring the adapter for the RecyclerView
  private SupportAdapter supportAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_support);

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
    supportAdapter = new SupportAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        SupportItem item = (SupportItem) view.getTag();
        presenter.selectSupportListData(item);
      }
    });

    // declaring the recyclerView, finding its id and changing its adapter
    RecyclerView recyclerView = findViewById(R.id.supportList);
    recyclerView.setAdapter(supportAdapter);
    recyclerView.setLayoutManager(new GridLayoutManager(this, 1)); // number of columns

    // do the setup
    SupportScreen.configure(this);

    // calling the presenter in order to fetch data
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(SupportContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(final SupportViewModel viewModel) {
    Log.e(TAG, "displayData()");

    // we need to get into the main thread to display the fetched data
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        ((TextView) findViewById(R.id.supportBar)).setText(R.string.support_bar_label);
        supportAdapter.setItems(viewModel.profiles);
      }
    });
  }
}
