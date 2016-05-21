package bit.dail3.viewanimationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new StandUpImage());
    }

    class StandUpImage implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            YoYo.with(Techniques.StandUp).duration(1000).playOn(imageView);
        }
    }
}
