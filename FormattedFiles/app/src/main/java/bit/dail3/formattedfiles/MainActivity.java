package bit.dail3.formattedfiles;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ItemIsClick());
    }

    class ItemIsClick implements ListView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int index = 0;
            String title = (String)parent.getItemAtPosition(position);
            for (int i = 0; i < titles().size(); i++)
            {
                if(titles().get(i).equals(title))
                {
                    index = i;
                    break;
                }
            }
            String desc = description().get(index);
            Toast.makeText(MainActivity.this, desc, Toast.LENGTH_SHORT).show();
        }
    }

    private ArrayList<String> description()
    {
        ArrayList<String> descriptions = new ArrayList<String>();
        ArrayList<JSONObject> eventO = eventsObjects();
        for(int i = 0; i < eventO.size(); i++)
        {
            JSONObject jsonObject = eventO.get(i);
            descriptions.add(getStringByNameFromJSONObject(jsonObject, "description"));
        }
        return descriptions;
    }

    private ArrayList<String> titles()
    {
        ArrayList<String> title = new ArrayList<String>();
        ArrayList<JSONObject> eventO = eventsObjects();
        for(int i = 0; i < eventO.size(); i++)
        {
            JSONObject jsonObject = eventO.get(i);
            title.add(getStringByNameFromJSONObject(jsonObject, "title"));
        }
        return title;
    }

    private ArrayList<JSONObject> eventsObjects()
    {
        ArrayList<JSONObject> ObjectArray = new ArrayList<JSONObject>();
        JSONObject objectOfAll = getJSONObjectFromString(readJOSN());
        JSONObject eventsObject = getJSONObjectByKey(objectOfAll, "events");
        JSONArray eventArray = getJSONArrayFromObjectByName(eventsObject, "event");
        int arraySize = eventArray.length();
        for (int i = 0; i < arraySize; i++)
        {
            ObjectArray.add(getJSONObjectFromArrayByIndex(eventArray, i));
        }
        return ObjectArray;
    }

    private String readJOSN()
    {
        String filename = "dunedin_events.json";
        String JSONInput = null;
        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open(filename);
            int fileSize = inputStream.available();
            byte[] JSONBuffer = new byte[fileSize];
            inputStream.read(JSONBuffer);
            inputStream.close();
            JSONInput = new String(JSONBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSONInput;
    }

    private JSONObject getJSONObjectFromString(String input)
    {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(input);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private JSONObject getJSONObjectByKey(JSONObject jsonObject, String key)
    {
        JSONObject jo = null;
        try {
            jo = jsonObject.getJSONObject(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jo;
    }

    private JSONArray getJSONArrayFromObjectByName(JSONObject jo, String name)
    {
        JSONArray array = null;
        try {
            array = jo.getJSONArray(name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return array;
    }

    private JSONObject getJSONObjectFromArrayByIndex(JSONArray jsonArray, int index){
        JSONObject jsonObject = null;
        try {
            jsonObject = jsonArray.getJSONObject(index);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private String getStringByNameFromJSONObject(JSONObject jsonObject, String name)
    {
        String title = null;
        try {
            title = jsonObject.getString(name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  title;
    }
}