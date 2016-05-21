package bit.dail3.thirdparty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.skyfishjy.library.RippleBackground;

public class MainActivity extends AppCompatActivity {

    private RippleBackground rippleBackground;
    private boolean startOrStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rippleBackground = (RippleBackground)findViewById(R.id.content);
        ImageView imageView = (ImageView) findViewById(R.id.centerImage);
        startOrStop = false;
        imageView.setOnClickListener(new rippleImageView());
    }

    class rippleImageView implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            startOrStop = !startOrStop;
            if(!startOrStop)
                rippleBackground.startRippleAnimation();
            else
                rippleBackground.stopRippleAnimation();
        }
    }
}
