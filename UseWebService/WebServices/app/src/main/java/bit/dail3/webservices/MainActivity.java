package bit.dail3.webservices;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFillList = (Button) findViewById(R.id.btnFillList);
        btnFillList.setOnClickListener(new fillLTheList());
    }

    class fillLTheList implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            AsyncLastFM asyncLastFM = new AsyncLastFM(MainActivity.this);
            asyncLastFM.execute();
        }
    }
}
