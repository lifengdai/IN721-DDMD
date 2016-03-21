package bit.dail3.multiple_activities_practical_3_1_task_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        Button btnClickMe = (Button) findViewById(R.id.btnClickMe);
        btnClickMe.setOnClickListener(new ClickMeChangeActivity());
    }

    class ClickMeChangeActivity implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Intent enterEnrolment = new Intent(WelcomeScreen.this, MainActivity.class);
            startActivity(enterEnrolment);
        }
    }
}
