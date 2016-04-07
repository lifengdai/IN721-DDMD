package bit.dail3.city_country_sql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowCities extends AppCompatActivity {

    private TextView txtvCities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cities);
        txtvCities = (TextView) findViewById(R.id.txtvCities);
        putCitiesOn();
    }

    private void putCitiesOn()
    {
        String cities = "";
        ArrayList<String> result = getIntent().getStringArrayListExtra("Result");
        for (int i = 0; i < result.size(); i++)
        {
            cities += result.get(i) + "\r\n";
        }
        txtvCities.setText(cities);
    }
}
