package bit.dail3.language_trainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Welcome_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__screen);
        RelativeLayout rltvlotOuter = (RelativeLayout) findViewById(R.id.rltvlotOuter);
        rltvlotOuter.setOnClickListener(new WholeThingClickable());
    }

    class WholeThingClickable implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            Intent passControl = new Intent(Welcome_Screen.this, MainActivity.class);
            startActivity(passControl);
        }
    }
}
