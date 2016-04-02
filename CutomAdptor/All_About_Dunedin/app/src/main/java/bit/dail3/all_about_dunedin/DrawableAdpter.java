package bit.dail3.all_about_dunedin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dailifeng on 16/4/1.
 */
public class DrawableAdpter extends ArrayAdapter<FunThings>{

    private Context context;

    public DrawableAdpter(Context context, int resource, FunThings[] objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View costomView = inflater.inflate(R.layout.drawable_adpter, parent, false);
        ImageView imgvPic = (ImageView) costomView.findViewById(R.id.imgvPic);
        TextView txtvText = (TextView) costomView.findViewById(R.id.txtvText);

        FunThings funThings = getItem(position);

        imgvPic.setImageDrawable(funThings.getPicture());
        txtvText.setText(funThings.getLocation());
        return costomView;
    }
}
