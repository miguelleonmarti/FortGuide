package es.ulpgc.miguel.fortguide.newTheory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class NewTheoryActivity
        extends AppCompatActivity implements NewTheoryContract.View {

    public static String TAG = NewTheoryActivity.class.getSimpleName();

    private NewTheoryContract.Presenter presenter;

    Button bananaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_theory);

    bananaButton.findViewById(R.id.bananaButton);

    bananaButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.startMenuScreen();
        }
    });
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
        ((TextView) findViewById(R.id.newTheoryTextView)).setText(viewModel.data);
    }
}
