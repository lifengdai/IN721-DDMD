package bit.dail3.language_trainer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {


    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_result, container, false);
        TextView txtvCorrect = (TextView) v.findViewById(R.id.txtvCorrect);
        TextView txtvWrong = (TextView) v.findViewById(R.id.txtvWrong);
        TextView txtvCorrectRate = (TextView) v.findViewById(R.id.txtvCorrectRate);
        int Correct = DataAnalyse.getCorrectQuestions();
        String SCorrect = Integer.toString(DataAnalyse.getCorrectQuestions());
        String wrong = Integer.toString(11 - DataAnalyse.getCorrectQuestions());
        double correctRate = Correct / 11.0 * 100.0;
        String SCorrectRate = String.format("%.1f", correctRate);
        txtvCorrect.setText("Correct: " + SCorrect);
        txtvWrong.setText("Wrong: " + wrong);
        txtvCorrectRate.setText("Correct rate: " + SCorrectRate + "%");
        return v;
    }

}
