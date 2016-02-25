package bit.dail3.event_handler_practical_2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etTxt = (EditText) findViewById(R.id.EtxtNoAt);
        EditText etUsername = (EditText) findViewById(R.id.etUsername);
        Button btnEventTester = (Button) findViewById(R.id.btnEventTest);

        btnEventTester.setOnClickListener(new ButtonEventShortTestClick());
        btnEventTester.setOnLongClickListener(new ButtonEventLongTestClick());
        etTxt.setOnKeyListener(new EditTextNoAt());
        etUsername.setOnKeyListener(new EnterUsername());
    }

    class ButtonEventShortTestClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, getResources().getString(R.string.ClickNormal), Toast.LENGTH_SHORT).show();
        }
    }

    class ButtonEventLongTestClick implements View.OnLongClickListener {
        @Override
        public boolean onLongClick(View v) {
            Toast.makeText(MainActivity.this, getResources().getString(R.string.ClickLong), Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    class EditTextNoAt implements View.OnKeyListener {

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if ((keyCode == KeyEvent.KEYCODE_AT) && (event.getAction() == KeyEvent.ACTION_UP)) {
                Toast.makeText(MainActivity.this, getResources().getString(R.string.NoAt), Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    }

    class EnterUsername implements View.OnKeyListener {

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            Editable usernameText = ((EditText) v).getText();
            String thankToastText = getResources().getText(R.string.Thank) + " " + usernameText.toString();
            String notificationToastText = getResources().getText(R.string.UsernameLengthNotification) + " " + usernameText.toString();
            if ((keyCode == KeyEvent.KEYCODE_ENTER) && (event.getAction() == KeyEvent.ACTION_UP)) {
                if (usernameText.length() == getResources().getInteger(R.integer.UsernameLength)) {
                    Toast.makeText(MainActivity.this, thankToastText, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, notificationToastText, Toast.LENGTH_SHORT).show();
                }
            }
            return false;
        }
    }
}
