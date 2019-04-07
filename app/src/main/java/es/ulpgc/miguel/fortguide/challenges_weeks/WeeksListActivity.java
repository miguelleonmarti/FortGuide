package es.ulpgc.miguel.fortguide.challenges_weeks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;


public class WeeksListActivity
    extends AppCompatActivity implements WeeksListContract.View {

  public static String TAG = WeeksListActivity.class.getSimpleName();

  private WeeksListContract.Presenter presenter;

  // declaring the buttons, texts and images
  private Button bananaButton;

  // declaring the adapter for the RecyclerView
  private WeeksListAdapter weeksListAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weeks_list);

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
    weeksListAdapter = new WeeksListAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        ChallengesWeeksItem item = (ChallengesWeeksItem) view.getTag(); //TODO: TE LO COMENTO PARA QUE NO DE ERROR
        presenter.selectWeeksListData(item);
      }
    });

    // declaring the recyclerView, finding its id and changing its adapter
    RecyclerView recyclerView = findViewById(R.id.challenges_weeks_list);
    recyclerView.setAdapter(weeksListAdapter);

    // do the setup
    WeeksListScreen.configure(this);

    // calling the presenter in order to fetch data
    presenter.fetchWeeksListData();
  }

  @Override
  public void injectPresenter(WeeksListContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayWeeksListData(final WeeksListViewModel viewModel) {
    Log.e(TAG, "displayWeeksListData()");

    // we need to get into the main thread to display the fetched data
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        ((TextView) findViewById(R.id.challengeBar)).setText(R.string.challenge_text_label);
        weeksListAdapter.setItems(viewModel.challengesWeeksItemList);
      }
    });
  }
}
