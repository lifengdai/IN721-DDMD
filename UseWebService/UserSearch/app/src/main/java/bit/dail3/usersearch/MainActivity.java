package bit.dail3.usersearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edttxtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new Search());
        edttxtName = (EditText) findViewById(R.id.edttxtName);
    }

    class Search implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            String nameToBeSearch = edttxtName.getText().toString();
            AsyncLastFM asyncLastFM = new AsyncLastFM(MainActivity.this);
            asyncLastFM.execute(nameToBeSearch);
        }
    }
}