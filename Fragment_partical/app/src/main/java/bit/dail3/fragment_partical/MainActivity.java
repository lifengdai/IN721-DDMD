package bit.dail3.fragment_partical;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPicture = (Button)findViewById(R.id.btnPicture);
        Button btnShowList = (Button)findViewById(R.id.btnShowList);

        btnPicture.setOnClickListener(new showPicture());
        btnShowList.setOnClickListener(new showListview());
    }

    class showPicture implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Fragment fragmentPicture = new PictureFragment();
            FragmentManager fm = getSupportFragmentManager();

            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.linearlayoutFragment, fragmentPicture);
            ft.commit();
        }
    }

    class showListview implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Fragment fragmentListview = new ListviewFragment();
            FragmentManager fm = getSupportFragmentManager();

            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.linearlayoutFragment, fragmentListview);
            ft.commit();
        }
    }
}
