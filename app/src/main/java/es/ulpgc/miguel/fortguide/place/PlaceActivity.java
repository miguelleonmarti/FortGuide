package es.ulpgc.miguel.fortguide.place;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class PlaceActivity
        extends AppCompatActivity implements PlaceContract.View {

    public static String TAG = PlaceActivity.class.getSimpleName();

    private PlaceContract.Presenter presenter;

    Button bananaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        bananaButton = findViewById(R.id.bananaButton);

        bananaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.startMenuScreen();
            }
        });

        // do the setup
        PlaceScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(PlaceContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(PlaceViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
