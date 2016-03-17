package bit.dail3.request_data;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends AppCompatActivity {

    private EditText edttxtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        edttxtName = (EditText)findViewById(R.id.edttxtName);
        btnReturn.setOnClickListener(new goBack());
    }

    class goBack implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Intent back = new Intent();
            back.putExtra(getResources().getString(R.string.extra_string), edttxtName.getText().toString());
            setResult(Activity.RESULT_OK, back);
            finish();
        }
    }
}
