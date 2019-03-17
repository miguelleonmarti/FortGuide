package es.ulpgc.miguel.fortguide.newTheory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class NewTheoryActivity
        extends AppCompatActivity implements NewTheoryContract.View {

    public static String TAG = NewTheoryActivity.class.getSimpleName();

    private NewTheoryContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_theory);

        // do the setup
        NewTheoryScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(NewTheoryContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(NewTheoryViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
