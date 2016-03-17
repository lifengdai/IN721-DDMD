package bit.dail3.getcoloroftextview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtvWhatIsAComputer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnChageColor = (Button)findViewById(R.id.btnChageColor);
        txtvWhatIsAComputer = (TextView)findViewById(R.id.txtvWhatIsAComputer);
        btnChageColor.setOnClickListener(new changeColor());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if((requestCode == 0) && (resultCode == Activity.RESULT_OK))
        {
            int txtColor = data.getIntExtra(getResources().getString(R.string.color), 0);
            txtvWhatIsAComputer.setTextColor(txtColor);
        }
    }

    class changeColor implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Intent getcolor = new Intent(MainActivity.this, Setting.class);
            startActivityForResult(getcolor, 0);
        }
    }
}
