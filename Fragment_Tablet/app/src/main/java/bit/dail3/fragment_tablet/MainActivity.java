package bit.dail3.fragment_tablet;

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

        Button btnShowPicture = (Button)findViewById(R.id.btnShowPicture);
        Button btnShowList = (Button)findViewById(R.id.btnShowList);

        btnShowPicture.setOnClickListener(new showPicture());
        btnShowList.setOnClickListener(new showListview());
    }

    class showPicture implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Fragment fragmentPicture = new ShowPicture();
            FragmentManager fm = getSupportFragmentManager();

            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.lyContent, fragmentPicture);
            ft.commit();
        }
    }

    class showListview implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Fragment fragmentListview = new Showlist();
            FragmentManager fm = getSupportFragmentManager();

            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.lyContent, fragmentListview);
            ft.commit();
        }
    }

}
