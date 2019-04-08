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

  // declaring the buttons, texts and images
  private Button bananaButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_advice_detail);

    // finding buttons, texts and images id
    bananaButton = findViewById(R.id.bananaButton);

    // listeners
    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });

    // do the setup
    AdviceDetailScreen.configure(this);

    // calling the presenter in order to fetch data
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
    ((TextView)findViewById(R.id.contentTextView)).setText(viewModel.adviceItem.getContent());
    ((TextView)findViewById(R.id.detailTextView)).setText(viewModel.adviceItem.getDetails());

  }
}
