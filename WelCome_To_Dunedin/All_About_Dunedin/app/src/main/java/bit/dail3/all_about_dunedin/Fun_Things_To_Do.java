package bit.dail3.all_about_dunedin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Fun_Things_To_Do extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        TextView tvPageTitle = (TextView)findViewById(R.id.tvPageTitle);
        tvPageTitle.setText(getResources().getString(R.string.fun_things_to_do_activity_title));

        ImageView imgvPicture = (ImageView)findViewById(R.id.imgvPicture);
        imgvPicture.setImageResource(R.drawable.ic_launcher);
    }
}
