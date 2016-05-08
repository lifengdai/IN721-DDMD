package bit.dail3.gpsteleporter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created by dailifeng on 16/5/8.
 */
public class PullImageFromFlickr extends AsyncTask<String, Void, Bitmap> {

    private Activity activity;

    public PullImageFromFlickr(Activity activity) {
        super();
        this.activity = activity;
    }


    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap photograph = null;
        String city = params[0];
        String JSONData = "";
        String URLString = "https://api.flickr.com/services/rest/?" +
                "method=flickr.photos.search" +
                "&api_key=eda41a123d459be0f85276d37290651e" +
                "&tags=" + city +
                "&format=json" +
                "&nojsoncallback=1";

        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] certs, String authType) {
            }
        }};

        try {
            URL URLObject = new URL(URLString);
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
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
            JSONObject parent = new JSONObject(JSONData);
            JSONObject photosObject = parent.getJSONObject("photos");
            JSONObject photoObject = photosObject.getJSONArray("photo").getJSONObject(0);
            String id = photoObject.getString("id");
            String server = photoObject.getString("server");
            String farm = photoObject.getString("farm");
            String secret = photoObject.getString("secret");
            String photoURL = "http://farm" + farm +
                    ".staticflickr.com/" + server +
                    "/" + id + "_" + secret + "_m.jpg";
            URL photo = new URL(photoURL);
            HttpURLConnection imageConnection = (HttpURLConnection) photo.openConnection();
            imageConnection.connect();
            InputStream imageInput = imageConnection.getInputStream();
            photograph = BitmapFactory.decodeStream(imageInput);
        } catch (NullPointerException | IOException | JSONException | NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
        return photograph;
    }

    @Override
    protected void onPostExecute(Bitmap fetchedData) {
        ((MainActivity) activity).getImgvCityImage().setImageBitmap(fetchedData);
    }
}
