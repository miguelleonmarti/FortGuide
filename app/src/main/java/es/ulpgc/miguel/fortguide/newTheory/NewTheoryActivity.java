package es.ulpgc.miguel.fortguide.newTheory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.ulpgc.miguel.fortguide.R;

public class NewTheoryActivity
    extends AppCompatActivity implements NewTheoryContract.View {

  public static String TAG = NewTheoryActivity.class.getSimpleName();

  private NewTheoryContract.Presenter presenter;

  // declaring the buttons, texts and images
   Button bananaButton, cancelButton, sendButton;
   EditText userEditText, nameEditText, descriptionEditText;

  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_theory);

    // finding buttons, texts and images id
    bananaButton=findViewById(R.id.bananaButton);
    cancelButton=findViewById(R.id.cancelButton);
    sendButton=findViewById(R.id.sendButton);
    userEditText=findViewById(R.id.userEditText);
    nameEditText=findViewById(R.id.nameEditText);
    descriptionEditText=findViewById(R.id.descriptionEditText);

    // listeners
    bananaButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.startMenuScreen();
      }
    });
    cancelButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        onBackPressed();
      }
    });
    sendButton.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v){
        if(userEditText.getText().toString().equals("") || nameEditText.getText().toString().equals("") || descriptionEditText.getText().toString().equals("")){
          Toast toast = Toast.makeText(getApplicationContext(), R.string.newTheory_error, Toast.LENGTH_SHORT);
          toast.show();
        }else{
          presenter.insertNewTheory(userEditText.getText().toString(),  nameEditText.getText().toString(), descriptionEditText.getText().toString());
        }
      }
    });

    // do the setup
    NewTheoryScreen.configure(this);

    // calling the presenter in order to fetch data
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

  @Override
  public void onTheoryInserted() {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.theory_inserted, Toast.LENGTH_SHORT);
        toast.show();
        finish();
      }
    });
  }
}
