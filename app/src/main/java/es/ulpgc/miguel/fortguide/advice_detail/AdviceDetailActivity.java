package es.ulpgc.miguel.fortguide.advice_detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class AdviceDetailActivity
        extends AppCompatActivity implements AdviceDetailContract.View {

    public static String TAG = AdviceDetailActivity.class.getSimpleName();

    private AdviceDetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice_detail);

        // do the setup
        AdviceDetailScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(AdviceDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AdviceDetailViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.adviceDetailTextView)).setText(viewModel.data);
    }
}