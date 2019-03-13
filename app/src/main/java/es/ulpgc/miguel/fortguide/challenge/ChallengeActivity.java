package es.ulpgc.miguel.fortguide.challenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class ChallengeActivity
        extends AppCompatActivity implements ChallengeContract.View {

    public static String TAG = ChallengeActivity.class.getSimpleName();

    private ChallengeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        // do the setup
        ChallengeScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(ChallengeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(ChallengeViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
