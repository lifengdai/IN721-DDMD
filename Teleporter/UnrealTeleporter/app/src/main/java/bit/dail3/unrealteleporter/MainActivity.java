package bit.dail3.unrealteleporter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView txtvLongitudeValue;
    private TextView txtvLatitudeValue;
    private TextView txtvClosestCityValue;
    private ProgressBar progressBar;
    private Button btnTeleport;
    private ImageView imgvCityImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgvCityImage = (ImageView) findViewById(R.id.imgvCityImage);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        btnTeleport = (Button) findViewById(R.id.btnTeleport);
        txtvLongitudeValue = (TextView) findViewById(R.id.txtvLongitudeValue);
        txtvLatitudeValue = (TextView) findViewById(R.id.txtvLatitudeValue);
        txtvClosestCityValue = (TextView) findViewById(R.id.txtvClosestCityValue);
        btnTeleport.setOnClickListener(new TeleportBetweenCitys());
    }

    class TeleportBetweenCitys implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            btnTeleport.setEnabled(false);
            PullCityFromInternet pullcity = new PullCityFromInternet(MainActivity.this);
            progressBar.setVisibility(View.VISIBLE);
            pullcity.execute();
        }
    }

    public TextView getTxtvLongitudeValue() {
        return txtvLongitudeValue;
    }

    public TextView getTxtvLatitudeValue() {
        return txtvLatitudeValue;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public Button getBtnTeleport() {
        return btnTeleport;
    }

    public TextView getTxtvClosestCityValue() {
        return txtvClosestCityValue;
    }

    public ImageView getImgvCityImage() {
        return imgvCityImage;
    }
}