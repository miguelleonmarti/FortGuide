package es.ulpgc.miguel.fortguide.introduction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class IntroductionActivity
        extends AppCompatActivity implements IntroductionContract.View {

    public static String TAG = IntroductionActivity.class.getSimpleName();

    private IntroductionContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        // do the setup
        IntroductionScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(IntroductionContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(IntroductionViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
