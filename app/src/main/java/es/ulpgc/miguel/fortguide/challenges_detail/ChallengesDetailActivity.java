package es.ulpgc.miguel.fortguide.challenges_detail;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;


public class ChallengesDetailActivity
    extends AppCompatActivity implements ChallengesDetailContract.View {

  public static String TAG = ChallengesDetailActivity.class.getSimpleName();

  private ChallengesDetailContract.Presenter presenter;

  // declaring the buttons, texts and images
  private Button bananaButton;
  private ImageView starImage;

  // declaring the adapter for the RecyclerView
  private ChallengesDetailAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_challenges_detail);

    // finding buttons, texts and images id
    bananaButton = findViewById(R.id.bananaButton);
    starImage = findViewById(R.id.starImage);

    // listeners
    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });

    // initializing the adapter
    listAdapter = new ChallengesDetailAdapter();

    // declaring the recyclerView, finding its id and changing its adapter
    RecyclerView recyclerView = findViewById(R.id.challenges_detail_list);
    recyclerView.setAdapter(listAdapter);

    // do the setup
    ChallengesDetailScreen.configure(this);

    // calling the presenter in order to fetch data
    presenter.fetchChallengeDetailListData();
  }


  @Override
  public void injectPresenter(ChallengesDetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayChallengeDetailListData(final ChallengesDetailViewModel viewModel) {
    Log.e(TAG, "displayChallengeDetailListData()");

    // we need to get into the main thread to display the fetched data
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        // deal with the data
        ((TextView) findViewById(R.id.challengeDetailBarTextView)).setText(viewModel.challengesWeeksItem.getContent());
        listAdapter.setItems(viewModel.challengeItemList);
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
