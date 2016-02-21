package bit.dail3.first_code_practial_1_2a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView dogName;
    private Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rand = new Random();
        setContentView(R.layout.activity_main);
        dogName = (TextView) findViewById(R.id.dogName);
        dogName.setText(randomSelect());
    }

    private String randomSelect()
    {
        int randNum = rand.nextInt(4);
        String selectName = "";

        switch (randNum)
        {
            case 0:
                selectName = getResources().getString(R.string.Dog_Poodle);
                break;

            case 1:
                selectName = getResources().getString(R.string.Dog_Labrador);
                break;

            case 2:
                selectName = getResources().getString(R.string.Dog_Shar_Pei);
                break;

            case 3:
                selectName = getResources().getString(R.string.Dog_Newfoundland);
                break;
        }

        return selectName;
    }
}
