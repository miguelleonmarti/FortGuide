package es.ulpgc.miguel.fortguide.shop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;

public class ShopActivity
    extends AppCompatActivity implements ShopContract.View {

    public static String TAG = ShopActivity.class.getSimpleName();

    private ShopContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        // do the setup
        ShopScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(ShopContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(ShopViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
