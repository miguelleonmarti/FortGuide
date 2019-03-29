package es.ulpgc.miguel.fortguide.challenges;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import java.util.List;



public class ChallengeListActivity
    extends AppCompatActivity implements ChallengeListContract.View {

  public static String TAG = ChallengeListActivity.class.getSimpleName();

  private ChallengeListContract.Presenter presenter;

  private TextView challengeBar;
  private ListView listView;
  private Button bananaButton;

  private ChallengeListAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_challenge_list);


    bananaButton = findViewById(R.id.bananaButton);
    challengeBar = findViewById(R.id.challengeBar);


    listAdapter = new ChallengeListAdapter(this, new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        ChallengeItem item = (ChallengeItem) listView.getTag();
        presenter.startMenuScreen();
      }
    });

    listView = findViewById(R.id.challenge_list);
    listView.setAdapter(listAdapter);

    // do the setup
    ChallengeListScreen.configure(this);
    presenter.fetchChallengeListData();
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchChallengeListData();
  }

  @Override
  public void injectPresenter(ChallengeListContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayChallengeListData(ChallengeListViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    listAdapter.setItems(viewModel.challenges);
  }
}
