package es.ulpgc.miguel.fortguide.theory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.TheoryItem;

public class TheoryActivity
    extends AppCompatActivity implements TheoryContract.View {

  public static String TAG = TheoryActivity.class.getSimpleName();

  private TheoryContract.Presenter presenter;
  private TheoryAdapter listAdapter;

  // declaring the buttons, texts and images
  private Button addTheoryButton, bananaButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_theory);

    // finding buttons, texts and images id
    addTheoryButton = findViewById(R.id.addButton);
    bananaButton = findViewById(R.id.bananaButton);

    // listeners
    addTheoryButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startNewTheoryScreen();
      }
    });
    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });
    listAdapter = new TheoryAdapter(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        TheoryItem item = (TheoryItem) view.getTag();
        presenter.selectTheoryListData(item);
      }
    });
    RecyclerView recyclerView = findViewById(R.id.theoryList);
    recyclerView.setAdapter(listAdapter);

    // do the setup
    TheoryScreen.configure(this);

    // calling the presenter in order to fetch data
    //presenter.fetchData();
  }

  @Override
  protected void onResume() {
    super.onResume();
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(TheoryContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(final TheoryViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        listAdapter.setItems(viewModel.theoryItemList); //Puts theoryItemList in the cells of the Recycler  }
      }
    });
  }

}
