package vcu.edu.thesaurus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(View v) {
        if (v.getId() == R.id.button) {

            EditText a =(EditText)findViewById(R.id.enterWord);
            String str = a.getText().toString();
            Intent i = new Intent(MainActivity.this, EnterValues.class);
            i.putExtra("searchTerm",str);
            startActivity(i);

        }
    }
    public void onButtonFind(View v) {
        if (v.getId() == R.id.buttonFind) {


            EditText a =(EditText)findViewById(R.id.enterWord);
            String str = a.getText().toString();

            Intent i = new Intent(MainActivity.this, Results.class);
            i.putExtra("searchTerm",str);
            startActivity(i);

        }
    }

}
