package bit.dail3.doublefetch;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

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

/**
 * Created by dailifeng on 16/4/14.
 */
public class AsyncLastFM extends AsyncTask<Void, Void, Bitmap>
{
    private Activity activity;

    public AsyncLastFM(Activity activity)
    {
        super();
        this.activity = activity;
    }

    @Override
    protected Bitmap doInBackground(Void... params)
    {
        Bitmap image = null;
        String URLString = "http://ws.audioscrobbler.com/2.0/?" +
                "method=chart.gettopartists" +
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
            String JSONData = stringBuilder.toString();
            JSONObject OuterObject = new JSONObject(JSONData);
            JSONObject Artists = OuterObject.getJSONObject("artists");
            JSONArray Artist = Artists.getJSONArray("artist");
            JSONObject ArtistObject = Artist.getJSONObject(0);
            JSONArray imageArray = ArtistObject.getJSONArray("image");
            JSONObject imageObject = imageArray.getJSONObject(0);
            String imageURL = imageObject.getString("#text");
            URL imageURLObject = new URL(imageURL);
            HttpURLConnection imageConnection = (HttpURLConnection) imageURLObject.openConnection();
            imageConnection.connect();
            InputStream imageInputStream = imageConnection.getInputStream();
            image = BitmapFactory.decodeStream(imageInputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return image;
    }

    @Override
    protected void onPostExecute(Bitmap fetchedData)
    {
        ImageView imageView = (ImageView) activity.findViewById(R.id.imageView);
        imageView.setImageBitmap(fetchedData);
    }
}
