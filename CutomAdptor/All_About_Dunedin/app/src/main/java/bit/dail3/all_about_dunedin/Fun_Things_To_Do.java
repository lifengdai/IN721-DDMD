package bit.dail3.all_about_dunedin;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Fun_Things_To_Do extends AppCompatActivity {

    private FunThings[] funThingses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun__things__to__do);
        initalDataArray();
        ListView lstvFunThings = (ListView) findViewById(R.id.lstvFunThings);
        DrawableAdpter allTheFunThings = new DrawableAdpter(this, android.R.layout.simple_list_item_1, funThingses);
        lstvFunThings.setAdapter(allTheFunThings);
    }

    private void initalDataArray()
    {
        Resources resources = getResources();
        funThingses = new FunThings[12];
        funThingses[0] = new FunThings("Launcher", resources.getDrawable(R.drawable.ic_launcher));
        funThingses[1] = new FunThings("Larnach Castle", resources.getDrawable(R.drawable.larnach_castle));
        funThingses[2] = new FunThings("Moana Pool", resources.getDrawable(R.drawable.moana_pool));
        funThingses[3] = new FunThings("Monarch", resources.getDrawable(R.drawable.monarch));
        funThingses[4] = new FunThings("Octagon", resources.getDrawable(R.drawable.octagon));
        funThingses[5] = new FunThings("Olveston", resources.getDrawable(R.drawable.olveston));
        funThingses[6] = new FunThings("Otago Polytechnic", resources.getDrawable(R.drawable.op));
        funThingses[7] = new FunThings("Peninsula", resources.getDrawable(R.drawable.peninsula));
        funThingses[8] = new FunThings("Salt Water Pool", resources.getDrawable(R.drawable.salt_water_pool));
        funThingses[9] = new FunThings("Speights Brewery", resources.getDrawable(R.drawable.speights_brewery));
        funThingses[10] = new FunThings("Sk Kilda Beach", resources.getDrawable(R.drawable.st_kilda_beach));
        funThingses[11] = new FunThings("Taeri Gorge Railway", resources.getDrawable(R.drawable.taeri_gorge_railway));
    }

}
