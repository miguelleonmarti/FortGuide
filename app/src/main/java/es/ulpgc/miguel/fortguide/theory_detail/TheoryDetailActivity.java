package es.ulpgc.miguel.fortguide.theory_detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class TheoryDetailActivity
        extends AppCompatActivity implements TheoryDetailContract.View {

    public static String TAG = TheoryDetailActivity.class.getSimpleName();

    private TheoryDetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_detail);

        // do the setup
        TheoryDetailScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(TheoryDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(TheoryDetailViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}