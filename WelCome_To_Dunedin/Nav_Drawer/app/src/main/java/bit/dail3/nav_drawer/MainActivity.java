package bit.dail3.nav_drawer;

import android.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView AllDunedin = (ListView) findViewById(R.id.lvAllDunedin);

        ArrayAdapter<CharSequence> everyThing = ArrayAdapter.createFromResource(this, R.array.all_dunedin, layout.simple_list_item_1);
        AllDunedin.setAdapter(everyThing);

        AllDunedin.setOnItemClickListener(new ListViewItemClick());
    }

    class ListViewItemClick implements ListView.OnItemClickListener
    {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            String pageName = parent.getItemAtPosition(position).toString();

            switch (pageName)
            {
                case "Services":
                    Intent servicePage = new Intent(MainActivity.this, Services.class);
                    startActivity(servicePage);
                    break;
                case "Dining":
                    Intent DiningPage = new Intent(MainActivity.this, Dining.class);
                    startActivity(DiningPage);
                    break;
                case "Fun Things To Do":
                    Intent Fun_Things_To_DoPage = new Intent(MainActivity.this, Fun_Things_To_Do.class);
                    startActivity(Fun_Things_To_DoPage);
                    break;
                case "Shopping":
                    Intent ShoppingPage = new Intent(MainActivity.this, Shopping.class);
                    startActivity(ShoppingPage);
                    break;
            }
        }
    }
}
