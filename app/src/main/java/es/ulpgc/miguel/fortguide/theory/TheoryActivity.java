package es.ulpgc.miguel.fortguide.theory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class TheoryActivity
        extends AppCompatActivity implements TheoryContract.View {

    public static String TAG = TheoryActivity.class.getSimpleName();

    private TheoryContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);

        // do the setup
        TheoryScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(TheoryContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(TheoryViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.theoryTextView)).setText(viewModel.data);
    }
}
