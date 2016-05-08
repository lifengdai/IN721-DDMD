package bit.dail3.gpsteleporter;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;

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
public class PullCityFromInternet extends AsyncTask<Double, Void, String> {

    private Activity activity;
    private final int LONGITUDE = 0;
    private final int LATITUDE = 1;

    public PullCityFromInternet(Activity activity) {
        super();
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Double... params) {
        String JSONData = null;
        String cityName = "";

        //longitude = RandomLocation.GenerateLocationByGPS(activity)[0];
        //latitude = RandomLocation.GenerateLocationByGPS(activity)[1];

        String URLString = "http://www.geoplugin.net/extras/location.gp?" +
                "lat=" + params[0] +
                "&long=" + params[1] +
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
        } catch (NullPointerException | JSONException | IOException e) {
            e.printStackTrace();
        }


        return cityName;
    }

    @Override
    protected void onPostExecute(String fetchedData) {
        ((MainActivity) activity).getTxtvClosestCityValue().setText(fetchedData);
        ((MainActivity) activity).getProgressBar().setVisibility(View.GONE);
        PullImageFromFlickr pullimage = new PullImageFromFlickr(activity);
        pullimage.execute(fetchedData);
    }
}
