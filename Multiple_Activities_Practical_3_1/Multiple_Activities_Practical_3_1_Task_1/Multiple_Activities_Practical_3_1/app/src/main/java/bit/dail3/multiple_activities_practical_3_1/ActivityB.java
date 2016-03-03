package bit.dail3.multiple_activities_practical_3_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnChangeActivity = (Button) findViewById(R.id.btnChangeActivity);
        TextView tvShowActivity = (TextView) findViewById(R.id.tvShowActivity);
        tvShowActivity.setText(getResources().getString(R.string.in_activity_B));
        btnChangeActivity.setOnClickListener(new gotoNextActivity());
    }

    class gotoNextActivity implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Intent toNextActivity = new Intent(ActivityB.this, ActivityC.class);
            startActivity(toNextActivity);
        }
    }
}
