package es.ulpgc.miguel.fortguide.challenges_detail;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.challenges_weeks.WeeksListActivity;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;


public class ChallengesDetailActivity
    extends AppCompatActivity implements ChallengesDetailContract.View {

  public static String TAG = ChallengesDetailActivity.class.getSimpleName();

  private ChallengesDetailContract.Presenter presenter;

  private ChallengesDetailAdapter listAdapter;


  Button bananaButton;
 ImageView starImage;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_challenges_detail);

    bananaButton = findViewById(R.id.bananaButton);

    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });

    starImage = findViewById(R.id.starImage);



    listAdapter = new ChallengesDetailAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        ChallengeItem item = (ChallengeItem) v.getTag();
        presenter.selectChallengeDetailListData(item);
      }
    });

    RecyclerView recyclerView = findViewById(R.id.challenges_detail_list);
    recyclerView.setAdapter(listAdapter);

    // do the setup
    ChallengesDetailScreen.configure(this);

    //do some work
    presenter.fetchChallengeDetailListData();
  }


  @Override
  public void injectPresenter(ChallengesDetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayChallengeDetailListData(final ChallengesDetailViewModel viewModel) {
    //Log.e(TAG, "displayChallengeDetailListData()");
    runOnUiThread(new Runnable() {
      @Override
      public void run() {

        // deal with the data
        listAdapter.setItems(viewModel.challenges);
      }
    });


  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == android.R.id.home) {
      NavUtils.navigateUpFromSameTask(this);
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
