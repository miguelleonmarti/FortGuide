package es.ulpgc.miguel.fortguide.advice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class AdviceActivity
        extends AppCompatActivity implements AdviceContract.View {

  public static String TAG = AdviceActivity.class.getSimpleName();

  private AdviceContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_advice);

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
    ((TextView) findViewById(R.id.consejoTextView)).setText(R.string.consejo_label);
  }
}
