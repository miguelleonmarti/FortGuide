package es.ulpgc.miguel.fortguide.challenges_weeks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;


public class ChallengesWeeksListActivity
    extends AppCompatActivity implements ChallengesWeeksListContract.View {

  public static String TAG = ChallengesWeeksListActivity.class.getSimpleName();

  private ChallengesWeeksListContract.Presenter presenter;

  private TextView challengeBar;
  private ListView listView;
  private Button bananaButton;

  private ChallengesWeeksListAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_challenges_weeks_list);


    bananaButton = findViewById(R.id.bananaButton);
    challengeBar = findViewById(R.id.challengeBar);


    listAdapter = new ChallengesWeeksListAdapter(this, new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        ChallengesWeeksItem item = (ChallengesWeeksItem) listView.getTag();
        presenter.startMenuScreen();
      }
    });

    listView = findViewById(R.id.challenges_weeks_list);
    listView.setAdapter(listAdapter);

    // do the setup
    ChallengesWeeksListScreen.configure(this);
    presenter.fetchChallengeListData();
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchChallengeListData();
  }

  @Override
  public void injectPresenter(ChallengesWeeksListContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayChallengeListData(ChallengesWeeksListViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    listAdapter.setItems(viewModel.challenges);
  }
}
