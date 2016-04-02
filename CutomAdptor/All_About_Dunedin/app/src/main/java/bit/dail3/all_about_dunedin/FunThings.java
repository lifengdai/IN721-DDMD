package bit.dail3.all_about_dunedin;

import android.graphics.drawable.Drawable;

/**
 * Created by dailifeng on 16/4/1.
 */
public class FunThings {

    private String location;
    private Drawable picture;

    public FunThings(String location, Drawable picture)
    {
        this.location = location;
        this.picture = picture;
    }

    public String getLocation() {
        return location;
    }

    public Drawable getPicture() {
        return picture;
    }
}
