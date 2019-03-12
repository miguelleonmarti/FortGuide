package es.ulpgc.miguel.fortguide.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class MenuActivity
        extends AppCompatActivity implements MenuContract.View {

    public static String TAG = MenuActivity.class.getSimpleName();

    private MenuContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // do the setup
        MenuScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(MenuContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(MenuViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
