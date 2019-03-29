package es.ulpgc.miguel.fortguide.advice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class AdviceActivity
    extends AppCompatActivity implements AdviceContract.View {

  public static String TAG = AdviceActivity.class.getSimpleName();

  private AdviceContract.Presenter presenter;

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
    // do the setup
    AdviceScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(AdviceContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(AdviceViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.consejoTextView)).setText(R.string.advice_bar_label);
  }
}
