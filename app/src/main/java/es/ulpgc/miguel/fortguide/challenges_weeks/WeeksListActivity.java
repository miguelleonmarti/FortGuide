package es.ulpgc.miguel.fortguide.challenges_weeks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.WeeksItem;


public class WeeksListActivity
    extends AppCompatActivity implements WeeksListContract.View {

  public static String TAG = WeeksListActivity.class.getSimpleName();

  private WeeksListContract.Presenter presenter;

  private Button bananaButton;

  private WeeksListAdapter ChallengesWeeksAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weeks_list);


    bananaButton = findViewById(R.id.bananaButton);

    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });


    ChallengesWeeksAdapter = new WeeksListAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        WeeksItem item = (WeeksItem) view.getTag();
        presenter.selectChallengeListData(item);
      }
    });

    RecyclerView recyclerView = findViewById(R.id.challenges_weeks_list);
    recyclerView.setAdapter(ChallengesWeeksAdapter);
    recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

    // do the setup
    WeeksListScreen.configure(this);

    //do some work
    presenter.fetchChallengeListData();
  }

  @Override
  public void injectPresenter(WeeksListContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayChallengeListData(final WeeksListViewModel viewModel) {
    Log.e(TAG, "displayChallengeListData()");

    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        ((TextView) findViewById(R.id.challengeBar)).setText(R.string.challenge_text_label);
        ChallengesWeeksAdapter.setItems(viewModel.challenges);
      }
    });
  }
}
