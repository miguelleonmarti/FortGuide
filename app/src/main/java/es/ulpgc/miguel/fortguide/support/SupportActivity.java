package es.ulpgc.miguel.fortguide.support;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.SupportItem;

public class SupportActivity
        extends AppCompatActivity implements SupportContract.View {

    public static String TAG = SupportActivity.class.getSimpleName();

    private SupportContract.Presenter presenter;

    private Button bananaButton;

    private SupportAdapter supportAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

    bananaButton = findViewById(R.id.bananaButton);

    bananaButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            presenter.startMenuScreen();
          }
        });
    supportAdapter = new SupportAdapter(this, new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SupportItem item = (SupportItem) view.getTag();
            presenter.selectCategoryListData(item);
        }
    });

    GridView gridView = findViewById(R.id.gridView);
    gridView.setAdapter(supportAdapter);

        // do the setup
    SupportScreen.configure(this);
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
        supportAdapter.setItems(viewModel.profiles);
    }
}
