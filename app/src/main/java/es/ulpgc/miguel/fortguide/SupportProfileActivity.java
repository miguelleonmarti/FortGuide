package es.ulpgc.miguel.fortguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SupportProfileActivity
        extends AppCompatActivity implements SupportProfileContract.View {

    public static String TAG = SupportProfileActivity.class.getSimpleName();

    private SupportProfileContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_profile);

        // do the setup
        SupportProfileScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(SupportProfileContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(SupportProfileViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
