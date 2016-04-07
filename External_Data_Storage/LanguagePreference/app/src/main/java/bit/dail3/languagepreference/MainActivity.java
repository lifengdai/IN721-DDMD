package bit.dail3.languagepreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private TextView txtvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rdogpLanguage = (RadioGroup) findViewById(R.id.rdogpLanguage);
        RadioGroup rdogpColor = (RadioGroup) findViewById(R.id.rdogpColor);
        rdogpLanguage.setOnCheckedChangeListener(new WhatLanguage());
        rdogpColor.setOnCheckedChangeListener(new WhatColor());

        txtvStatus = (TextView) findViewById(R.id.txtvStatus);

        sharedPreferences = getSharedPreferences("language_color ", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(sharedPreferences.contains("language"))
        {
            String preLang = sharedPreferences.getString("language", null);
            txtvStatus.setText(preLang);
        }

        if(sharedPreferences.contains("color"))
        {
            int preColor = sharedPreferences.getInt("color", 0);
            txtvStatus.setTextColor(preColor);
        }
    }

    private String languageSwitch(String language)
    {
        String helloWorld = "";

        switch (language)
        {
            case "French":
                helloWorld = "Bonjour Le Monde";
                break;

            case "German":
                helloWorld = "Hallo Welt";
                break;

            case "Spanish":
                helloWorld = "Hola Mundo";
                break;
        }
        return helloWorld;
    }

    private int colorSwitch(String color)
    {
        int colour = 0;

        switch (color)
        {
            case "Green":
                colour = getResources().getColor(R.color.green);
                break;

            case "Yellow":
                colour = getResources().getColor(R.color.yellow);
                break;

            case "Blue":
                colour = getResources().getColor(R.color.blue);
                break;
        }

        return colour;
    }

    class WhatLanguage implements RadioGroup.OnCheckedChangeListener
    {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioButton rdobtn = (RadioButton)findViewById(checkedId);
            String greetings = languageSwitch(rdobtn.getText().toString());
            editor.putString("language", greetings);
            txtvStatus.setText(greetings);
            editor.commit();
        }
    }

    class WhatColor implements RadioGroup.OnCheckedChangeListener
    {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioButton rdobtn = (RadioButton)findViewById(checkedId);
            int colorNum = colorSwitch(rdobtn.getText().toString());
            editor.putInt("color", colorNum);
            txtvStatus.setTextColor(colorNum);
            editor.commit();
        }
    }
}