package bit.dail3.request_data;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
            String name = edttxtName.getText().toString();
            if(name.length() < 5)
            {
                Toast.makeText(Settings.this, getResources().getString(R.string.toast_txt), Toast.LENGTH_SHORT).show();
            }
            else {
                Intent back = new Intent();
                back.putExtra(getResources().getString(R.string.extra_string), name);
                setResult(Activity.RESULT_OK, back);
                finish();
            }
        }
    }
}
