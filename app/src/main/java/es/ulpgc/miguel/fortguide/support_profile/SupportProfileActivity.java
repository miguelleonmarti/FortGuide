package es.ulpgc.miguel.fortguide.support_profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class SupportProfileActivity
        extends AppCompatActivity implements SupportProfileContract.View {

    public static String TAG = SupportProfileActivity.class.getSimpleName();

    private SupportProfileContract.Presenter presenter;

    Button bananaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_profile);

        bananaButton = findViewById(R.id.bananaButton);
        bananaButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                presenter.startMenuScreen();
            }
        });
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
