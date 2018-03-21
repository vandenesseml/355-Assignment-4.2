package vcu.edu.thesaurus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Max Vandenesse on 3/19/2018.
 */

public class EnterValues extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_values);
    }
    public void onButtonSubmit(View v){
        if(v.getId() == R.id.submit){
            EditText synonym = (EditText)findViewById(R.id.enterSynonym);
            EditText antonym = (EditText)findViewById(R.id.enterAntonym);
            String strSynonym = synonym.getText().toString();
            String strAntonym = antonym.getText().toString();
            String searchTerm = getIntent().getStringExtra("searchTerm");
            Thesaurus t = new Thesaurus();
            t.setSearchTerm(searchTerm);
            t.setSynonym(strSynonym);
            t.setAntonym(strAntonym);
            helper.insertThesaurusEntry(t);
            Intent i = new Intent(EnterValues.this, MainActivity.class);
            startActivity(i);

        }
    }
}
