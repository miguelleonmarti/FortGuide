package es.ulpgc.miguel.fortguide.weapon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class WeaponActivity
        extends AppCompatActivity implements WeaponContract.View {

    public static String TAG = WeaponActivity.class.getSimpleName();

    private WeaponContract.Presenter presenter;

    Button bananaButton;
    TextView weaponBar;
    Spinner weaponSpinner;
    Button weaponSearchButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon);

        weaponSpinner = findViewById(R.id.weaponSpinner);
        weaponSearchButton = findViewById(R.id.searchButton);
        bananaButton = findViewById(R.id.bananaButton);
        weaponBar = findViewById(R.id.weaponBar);
        // do the setup
        WeaponScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(WeaponContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(WeaponViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.weaponBar)).setText(R.string.weapon_bar_label);
    }
}
