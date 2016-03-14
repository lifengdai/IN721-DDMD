package bit.dail3.fragment_partical;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment {


    public PictureFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View pictureView = inflater.inflate(R.layout.fragment_picture, container, false);

        return pictureView;
    }
}
