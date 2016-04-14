package bit.dail3.webservices;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;

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
public class AsyncLastFM extends AsyncTask<Void, Void, String > {

    private Activity activity;

    public AsyncLastFM(Activity activity)
    {
        super();
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Void... params) {
        String JSONData = null;
        String URLString = "http://ws.audioscrobbler.com/2.0/?" +
                "method=chart.gettopartists" +
                "&api_key=58384a2141a4b9737eacb9d0989b8a8c" +
                "&format=json";
        try {
            URL URLObject = new URL(URLString);
            HttpURLConnection connection = (HttpURLConnection) URLObject.openConnection();
            connection.connect();
            //int respondsCode = connection.getResponseCode();
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
        NameListenersPair[] NameListenersPairList = new NameListenersPair[20];

        try {
            JSONObject OuterObject = new JSONObject(fetchedData);
            JSONObject Artists = OuterObject.getJSONObject("artists");
            JSONArray Artist = Artists.getJSONArray("artist");
            for (int i = 0; i < 20; i++)
            {
                JSONObject ArtistObject = Artist.getJSONObject(i);
                String name = ArtistObject.getString("name");
                String listeners = ArtistObject.getString("listeners");
                NameListenersPairList[i] = new NameListenersPair(name, listeners);
            }
            ListView listView = (ListView) activity.findViewById(R.id.listView);
            listView.setAdapter(new ArrayAdpterTopArtist(activity, android.R.layout.simple_list_item_1, NameListenersPairList));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}