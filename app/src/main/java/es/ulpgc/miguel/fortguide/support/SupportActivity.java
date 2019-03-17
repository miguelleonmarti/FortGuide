package es.ulpgc.miguel.fortguide.support;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class SupportActivity
        extends AppCompatActivity implements SupportContract.View {

    public static String TAG = SupportActivity.class.getSimpleName();

    private SupportContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        // do the setup
        SupportScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(SupportContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(SupportViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.supportBar)).setText(R.string.support_bar_label);
    }
}
