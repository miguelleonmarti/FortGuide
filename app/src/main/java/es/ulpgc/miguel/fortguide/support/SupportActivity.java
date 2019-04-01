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

  private Button bananaButton;

  private SupportAdapter supportAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_support);

    bananaButton = findViewById(R.id.bananaButton);

    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });

    supportAdapter = new SupportAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        SupportItem item = (SupportItem) view.getTag();
        presenter.selectSupportListData(item);
      }
    });

    RecyclerView recyclerView = findViewById(R.id.supportList);
    recyclerView.setAdapter(supportAdapter);
    recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // numero de columnas

    // do the setup
    SupportScreen.configure(this);

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(SupportContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(final SupportViewModel viewModel) {
    Log.e(TAG, "displayData()");

    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        ((TextView) findViewById(R.id.supportBar)).setText(R.string.support_bar_label);
        supportAdapter.setItems(viewModel.profiles);
      }
    });
  }
}
