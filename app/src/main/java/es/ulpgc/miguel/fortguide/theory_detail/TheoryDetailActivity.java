package es.ulpgc.miguel.fortguide.theory_detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class TheoryDetailActivity
    extends AppCompatActivity implements TheoryDetailContract.View {

  public static String TAG = TheoryDetailActivity.class.getSimpleName();

  private TheoryDetailContract.Presenter presenter;

  // declaring the buttons, texts and images
  private Button bananaButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_theory_detail);

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
    TheoryDetailScreen.configure(this);

    // calling the presenter in order to fetch data
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(TheoryDetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(TheoryDetailViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView)findViewById(R.id.contentTextView)).setText(viewModel.theoryItem.getContent());
    ((TextView)findViewById(R.id.detailTextView)).setText(viewModel.theoryItem.getDetails());
    ((TextView)findViewById(R.id.userTextView)).setText(viewModel.theoryItem.getUser());
    ((TextView)findViewById(R.id.likesTextView)).setText(viewModel.theoryItem.getLikes());
    ((TextView)findViewById(R.id.dislikesTextView)).setText(viewModel.theoryItem.getDislikes());
  }
}
