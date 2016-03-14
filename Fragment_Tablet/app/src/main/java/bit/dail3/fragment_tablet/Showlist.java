package bit.dail3.fragment_tablet;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Showlist extends Fragment {


    public Showlist() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View listviewView = inflater.inflate(R.layout.fragment_showlist, container, false);
        ListView lvAnimal = (ListView)listviewView.findViewById(R.id.lvAnimal);
        ArrayAdapter<CharSequence> animal =
                ArrayAdapter.createFromResource(getActivity(), R.array.list, android.R.layout.simple_list_item_1);
        lvAnimal.setAdapter(animal);
        return listviewView;
    }

}
