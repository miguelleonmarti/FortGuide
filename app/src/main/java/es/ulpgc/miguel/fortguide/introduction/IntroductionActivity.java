package es.ulpgc.miguel.fortguide.introduction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import es.ulpgc.miguel.fortguide.R;

public class IntroductionActivity
    extends AppCompatActivity implements IntroductionContract.View {

  public static String TAG = IntroductionActivity.class.getSimpleName();

  private IntroductionContract.Presenter presenter;

  Button continueButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_introduction);

    //getSupportActionBar().setTitle("Introduction Screen");
    //getSupportActionBar().hide();

    continueButton = findViewById(R.id.buttonContinue);

    continueButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });

    // do the setup
    IntroductionScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(IntroductionContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(IntroductionViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
  }
}
