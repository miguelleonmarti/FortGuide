package es.ulpgc.miguel.fortguide.challenges_detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;


public class ChallengesDetailActivity
    extends AppCompatActivity implements ChallengesDetailContract.View {

  public static String TAG = ChallengesDetailActivity.class.getSimpleName();

  private ChallengesDetailContract.Presenter presenter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_challenges_detail);

    // do the setup
    ChallengesDetailScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(ChallengesDetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(ChallengesDetailViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
  }
}
