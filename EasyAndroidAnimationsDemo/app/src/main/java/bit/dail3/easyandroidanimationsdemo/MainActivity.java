package bit.dail3.easyandroidanimationsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.easyandroidanimations.library.ExplodeAnimation;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new ExplodeImageWhenTouchIt());
    }

    class ExplodeImageWhenTouchIt implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            ExplodeAnimation explodeAnimation = new ExplodeAnimation(imageView);
            explodeAnimation.animate();
        }
    }
}
