package bit.dail3.webservices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by dailifeng on 16/4/14.
 */
public class ArrayAdpterTopArtist extends ArrayAdapter<NameListenersPair> {
    private Context context;

    public ArrayAdpterTopArtist(Context context, int resource, NameListenersPair[] objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(context);

        View costomView = inflater.inflate(R.layout.top_artists, parent, false);
        TextView txtvName = (TextView) costomView.findViewById(R.id.txtvName);
        TextView txtvListeners = (TextView) costomView.findViewById(R.id.txtvListeners);
        NameListenersPair nameListenersPair = getItem(position);
        txtvName.setText(nameListenersPair.getName());
        txtvListeners.setText(nameListenersPair.getListeners());
        return costomView;
    }
}
