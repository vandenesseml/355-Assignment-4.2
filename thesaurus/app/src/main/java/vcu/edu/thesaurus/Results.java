package vcu.edu.thesaurus;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Max Vandenesse on 3/19/2018.
 */

public class Results extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        String searchTerm = getIntent().getStringExtra("searchTerm");
        String term = helper.searchThesaurus(searchTerm);
        TextView tvResult = (TextView)findViewById(R.id.displayResult);
            tvResult.setText(term);
    }
}
