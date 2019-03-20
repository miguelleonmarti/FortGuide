package es.ulpgc.miguel.fortguide.challenges;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class ChallengeListActivity
        extends AppCompatActivity implements ChallengeListContract.View {

    public static String TAG = ChallengeListActivity.class.getSimpleName();

    private ChallengeListContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_list);


        Button bananaButton = findViewById(R.id.bananaButton);
        TextView challengeBar = findViewById(R.id.challengeBar);
        ListView listView = findViewById(R.id.challenge_list);

        // do the setup
        ChallengeListScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(ChallengeListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(ChallengeListViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
