package bit.dail3.gpsteleporter;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;

import java.util.Random;

/**
 * Created by dailifeng on 16/5/7.
 */
public class RandomLocation {

    private static final double longitudeLimit = 180.00;
    private static final double latitudeLimit = 90.00;

    public RandomLocation() {
    }


    public static double[] GenerateLocationByGPS(Activity activity) {
        double[] location = new double[2];
        LocationManager locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String providerName = locationManager.getBestProvider(criteria, false);
        Location currentLocation = locationManager.getLastKnownLocation(providerName);
        double longt = currentLocation.getLongitude();
        double latit = currentLocation.getLatitude();
        location[0] = longt;
        location[1] = latit;
        return location;
    }
}
