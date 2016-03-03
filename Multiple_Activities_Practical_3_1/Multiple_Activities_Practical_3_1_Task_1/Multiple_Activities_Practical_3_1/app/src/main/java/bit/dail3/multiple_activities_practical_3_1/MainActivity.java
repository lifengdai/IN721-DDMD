package bit.dail3.multiple_activities_practical_3_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnChangeActivity = (Button) findViewById(R.id.btnChangeActivity);
        btnChangeActivity.setOnClickListener(new ChangeActivity());
    }

    class ChangeActivity implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Intent gotoNextActivity = new Intent(MainActivity.this, ActivityB.class);
            startActivity(gotoNextActivity);
        }
    }
}
