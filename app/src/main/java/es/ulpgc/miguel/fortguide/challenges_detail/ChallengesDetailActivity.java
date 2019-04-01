package es.ulpgc.miguel.fortguide.challenges_detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.challenges_weeks.WeeksListActivity;


public class ChallengesDetailActivity
    extends AppCompatActivity implements ChallengesDetailContract.View {

  public static String TAG = ChallengesDetailActivity.class.getSimpleName();

  private ChallengesDetailContract.Presenter presenter;
  private ChallengeDetailAdapter listAdapter;


  private Button banana;
  private TextView title;
  private TextView detail;
  private ImageView starImage;
  private CheckBox checkbox;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_challenges_detail);

    banana = findViewById(R.id.bananaButton);
    title = findViewById(R.id.titleChallengeTextView);
    detail = findViewById(R.id.contentChallengeTextView);
    starImage = findViewById(R.id.starImage);
    checkbox = findViewById(R.id.challengeCheckbox);

    ListView listView = findViewById(R.id.challenges_detail_list);
    listView.setAdapter(listAdapter);

    // do the setup
    ChallengesDetailScreen.configure(this);

    presenter.fetchChallengeDetailData();


  }


  @Override
  public void injectPresenter(ChallengesDetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayChallengeDetailData(ChallengesDetailViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
   listAdapter.setItems(viewModel.challenge);





  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == android.R.id.home) {
      navigateUpTo(new Intent(this, WeeksListActivity.class));
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
