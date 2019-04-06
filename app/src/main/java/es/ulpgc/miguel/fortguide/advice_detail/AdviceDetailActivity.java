package es.ulpgc.miguel.fortguide.advice_detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class AdviceDetailActivity
    extends AppCompatActivity implements AdviceDetailContract.View {

  public static String TAG = AdviceDetailActivity.class.getSimpleName();

  private AdviceDetailContract.Presenter presenter;

  Button bananaButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_advice_detail);

    bananaButton = findViewById(R.id.bananaButton);

    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });

    // do the setup
    AdviceDetailScreen.configure(this);
    presenter.fetchData();
  }


  @Override
  public void injectPresenter(AdviceDetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(AdviceDetailViewModel viewModel) {
    Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView)findViewById(R.id.tituloTextView)).setText(viewModel.item.getContent());
    ((TextView)findViewById(R.id.descripcionTextView)).setText(viewModel.item.getDetails());

  }
}
