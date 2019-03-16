package es.ulpgc.miguel.fortguide.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class MenuActivity
        extends AppCompatActivity implements MenuContract.View {

    public static String TAG = MenuActivity.class.getSimpleName();

    private MenuContract.Presenter presenter;

    Button adviceButton, challengeButton, placeButton, shopButton, supportButton, theoryButton, weaponButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //getSupportActionBar().setTitle("Menu Screen");
        //getSupportActionBar().hide();

        adviceButton = findViewById(R.id.buttonAdvice);
        challengeButton = findViewById(R.id.buttonChallenge);
        placeButton = findViewById(R.id.buttonPlace);
        shopButton = findViewById(R.id.buttonShop);
        supportButton = findViewById(R.id.buttonSupport);
        theoryButton = findViewById(R.id.buttonTheory);
        weaponButton = findViewById(R.id.buttonWeapon);
        textView = findViewById(R.id.data); // TODO: QUITAR ESTE TEXTVIEW (NO SE QUITA PARA QUE NO DE ERRORES)

        adviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.startAdviceScreen();
            }
        });
        challengeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {presenter.startChallengeScreen();
            }
        });
        placeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.startPlaceScreen();
            }
        });
        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.startShopScreen();
            }
        });
        supportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {presenter.startSupportScreen();
            }
        });
        theoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.startTheoryScreen();
            }
        });
        weaponButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.startWeaponScreen();
            }
        });


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
