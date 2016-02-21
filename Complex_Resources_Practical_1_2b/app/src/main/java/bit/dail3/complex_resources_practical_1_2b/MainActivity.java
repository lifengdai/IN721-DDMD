package bit.dail3.complex_resources_practical_1_2b;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView days;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resources = getResources();
        days = (TextView) findViewById(R.id.days);
        days.setText(fridaysOn());
    }

    private String fridaysOn()
    {
        String fridays = resources.getString(R.string.Feb_Fri_Are_On) + " ";
        int datesArray[] = resources.getIntArray(R.array.FebFridays);
        for(int i : datesArray)
        {
            fridays += i + " ";
        }
        return fridays;
    }
}
