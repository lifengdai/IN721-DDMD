package bit.dail3.testgooglemap;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by dailifeng on 16/5/7.
 */
public class PullCityFromInternet extends AsyncTask<Void, Void, String> {

    private Activity activity;
    private double longitude;
    private double latitude;
    private final int LONGITUDE = 0;
    private final int LATITUDE = 1;

    public PullCityFromInternet(Activity activity)
    {
        super();
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Void... params) {
        boolean haveCity = false;
        String JSONData = null;
        String cityName = "";

        while(!haveCity) {
            longitude = RandomLocation.GenerateRandomLocation(LONGITUDE);
            latitude = RandomLocation.GenerateRandomLocation(LATITUDE);

            String URLString = "http://www.geoplugin.net/extras/location.gp?" +
                    "lat=" + latitude +
                    "&long=" + longitude +
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
                while ((bufferString = bufferedReader.readLine()) != null) {
                    stringBuilder = stringBuilder.append(bufferString);
                }
                JSONData = stringBuilder.toString();
                //JSONArray parentArray = new JSONArray(JSONData);
                //cityName = parentArray.getJSONObject(0).optString("geoplugin_place", "None");
                JSONObject parentObject = new JSONObject(JSONData);
                cityName = parentObject.optString("geoplugin_place", "None");
                haveCity = !cityName.equals("None");
            } catch (NullPointerException | JSONException | IOException e) {
                e.printStackTrace();
            }
        }

        return cityName;
    }

    @Override
    protected void onPostExecute(String fetchedData)
    {
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(latitude, longitude);
        ((MapsActivity) activity).getmMap().addMarker(new MarkerOptions().position(sydney).title("Marker in " + fetchedData));
        ((MapsActivity) activity).getmMap().moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
