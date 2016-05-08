package bit.dail3.gpsteleporter;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity implements LocationListener {

    private TextView txtvLongitudeValue;
    private TextView txtvLatitudeValue;
    private TextView txtvClosestCityValue;
    private ProgressBar progressBar;
    private ImageView imgvCityImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgvCityImage = (ImageView) findViewById(R.id.imgvCityImage);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        txtvLongitudeValue = (TextView) findViewById(R.id.txtvLongitudeValue);
        txtvLatitudeValue = (TextView) findViewById(R.id.txtvLatitudeValue);
        txtvClosestCityValue = (TextView) findViewById(R.id.txtvClosestCityValue);
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String providerName = locationManager.getBestProvider(criteria, false);
        locationManager.requestLocationUpdates(providerName, 400, 5, this);
    }

//            btnTeleport.setEnabled(false);
//            PullCityFromInternet pullcity = new PullCityFromInternet(MainActivity.this);
//            progressBar.setVisibility(View.VISIBLE);
//            pullcity.execute();


    public TextView getTxtvLongitudeValue() {
        return txtvLongitudeValue;
    }

    public TextView getTxtvLatitudeValue() {
        return txtvLatitudeValue;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public TextView getTxtvClosestCityValue() {
        return txtvClosestCityValue;
    }

    public ImageView getImgvCityImage() {
        return imgvCityImage;
    }

    @Override
    public void onLocationChanged(Location location) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        txtvLatitudeValue.setText(String.format("%.3f", latitude));
        txtvLongitudeValue.setText(String.format("%.3f", longitude));
        PullCityFromInternet pullcity = new PullCityFromInternet(MainActivity.this);
        progressBar.setVisibility(View.VISIBLE);
        pullcity.execute(location.getLatitude(), location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}