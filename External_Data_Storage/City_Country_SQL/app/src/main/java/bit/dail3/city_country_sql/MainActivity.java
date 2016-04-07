package bit.dail3.city_country_sql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CityCountrySQL cityCountrySQL;
    private ArrayList<String> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityCountrySQL = new CityCountrySQL(this);
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cityCountrySQL.getAllCountry());
        listView.setAdapter(stringArrayAdapter);
        listView.setOnItemClickListener(new searchWhenClick());
    }

    public ArrayList<String> getResult() {
        return result;
    }

    class searchWhenClick implements ListView.OnItemClickListener
    {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String country = (String) parent.getItemAtPosition(position);
            result = cityCountrySQL.SearchData(country);
            Intent intent = new Intent(MainActivity.this, ShowCities.class);
            intent.putExtra("Result", result);
            startActivity(intent);
        }
    }
}
