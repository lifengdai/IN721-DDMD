package bit.dail3.simple_file_citys;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<String> cities = new ArrayList<String>();
        String fileName = "Citys.txt";
        AssetManager am = getAssets();

        try {
            InputStream is = am.open(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String city = null;
            while ((city = bufferedReader.readLine()) != null)
            {
                cities.add(city);
            }

            bufferedReader.close();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, cities);
            listView.setAdapter(adapter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
