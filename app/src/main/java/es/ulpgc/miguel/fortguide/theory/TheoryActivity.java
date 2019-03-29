package es.ulpgc.miguel.fortguide.theory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class TheoryActivity
    extends AppCompatActivity implements TheoryContract.View {

  public static String TAG = TheoryActivity.class.getSimpleName();

  private TheoryContract.Presenter presenter;

  Button addTheoryButton, bananaButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_theory);

    addTheoryButton = findViewById(R.id.addButton);
    bananaButton = findViewById(R.id.bananaButton);

    addTheoryButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startNewTheoryScreen();
      }
    });
    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });
    // creando el set up
    TheoryScreen.configure(this);
  }


  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(TheoryContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(TheoryViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.theoryTextView)).setText(viewModel.data);
  }
}
