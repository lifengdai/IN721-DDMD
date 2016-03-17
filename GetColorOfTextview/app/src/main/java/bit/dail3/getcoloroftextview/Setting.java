package bit.dail3.getcoloroftextview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        TextView txtvTheRain = (TextView)findViewById(R.id.txtvTheRain);

        Intent retrive = new Intent();
        retrive.putExtra(getResources().getString(R.string.color), txtvTheRain.getCurrentTextColor());
        setResult(Activity.RESULT_OK, retrive);
        finish();
    }
}
