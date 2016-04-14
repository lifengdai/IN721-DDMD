package bit.dail3.usersearch;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by dailifeng on 16/4/14.
 */
public class AsyncLastFM extends AsyncTask<String, Void, String>
{

    private Activity activity;

    public AsyncLastFM(Activity activity)
    {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... params)
    {
        String JSONData = null;
        String URLString = "http://ws.audioscrobbler.com/2.0/?" +
                "method=artist.getsimilar" +
                "&artist=" + params[0] +
                "&api_key=58384a2141a4b9737eacb9d0989b8a8c" +
                "&format=json";
        try {
            URL URLObject = new URL(URLString);
            HttpURLConnection connection = (HttpURLConnection) URLObject.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String bufferString;
            StringBuilder stringBuilder = new StringBuilder();
            while((bufferString = bufferedReader.readLine()) != null)
            {
                stringBuilder = stringBuilder.append(bufferString);
            }
            JSONData = stringBuilder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSONData;
    }

    @Override
    protected void onPostExecute(String fetchedData)
    {
        ListView listView = (ListView) activity.findViewById(R.id.listView);
        ArrayList<String> names = new ArrayList<>();
        try {
            JSONObject outerObject = new JSONObject(fetchedData);
            JSONObject similarartists = outerObject.getJSONObject("similarartists");
            JSONArray artist = similarartists.getJSONArray("artist");
            for (int i = 0; i < 10; i++)
            {
                JSONObject artistObject = artist.getJSONObject(i);
                names.add(artistObject.getString("name"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        listView.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, names));
    }
}
