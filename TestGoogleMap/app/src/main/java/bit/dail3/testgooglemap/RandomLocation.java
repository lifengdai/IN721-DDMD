package bit.dail3.testgooglemap;

import java.util.Random;

/**
 * Created by dailifeng on 16/5/7.
 */
public class RandomLocation {

    private static final double longitudeLimit = 180.00;
    private static final double latitudeLimit = 90.00;

    public RandomLocation() { }

    //generate a random location
    public static double GenerateRandomLocation(int longOrLa)
    {
        Random random = new Random();
        double location = 0.0;
        boolean flag = random.nextBoolean();

        switch (longOrLa)
        {
            case 0:
                location = random.nextDouble() * longitudeLimit;
                break;
            case 1:
                location = random.nextDouble() * latitudeLimit;
                break;
        }

        location = flag ? location : -location;
        return location;
    }
}
