package bit.dail3.fragment_partical;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.R.layout;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListviewFragment extends Fragment {


    public ListviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View listviewView = inflater.inflate(R.layout.fragment_listview, container, false);
        ListView lvAnimal = (ListView)listviewView.findViewById(R.id.lvAnimal);
        ArrayAdapter<CharSequence> animal =
                ArrayAdapter.createFromResource(getActivity(), R.array.list, layout.simple_list_item_1);
        lvAnimal.setAdapter(animal);
        return listviewView;
    }

}
