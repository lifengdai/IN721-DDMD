package bit.dail3.request_data;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGoToSetting = (Button)findViewById(R.id.btnGoToSetting);
        txtvName = (TextView)findViewById(R.id.txtvName);
        btnGoToSetting.setOnClickListener(new gotoSettings());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if((requestCode == 0) && (resultCode == Activity.RESULT_OK))
        {
            String result = data.getStringExtra(getResources().getString(R.string.extra_string));
            txtvName.setText(result);
        }
    }

    class gotoSettings implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Intent getResult = new Intent(MainActivity.this, Settings.class);
            startActivityForResult(getResult, 0);
        }
    }
}
