package bit.dail3.language_trainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {

    private DataAnalyse dataAnalyse;
    private ImageView imgvPicture;
    private Button btnCheckNext;
    private RadioButton CheckedButton;
    private RadioButton rdobtnDer;
    private RadioButton rdobtnDas;
    private RadioButton rdobtnDie;
    private RadioGroup rdogpxAnswers;
    private TextView txtvName;
    private View v;
    private int questionNum;
    private Tuples<Integer, String, String> data;

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_question, container, false);
        rdobtnDer = (RadioButton) v.findViewById(R.id.rdobtnDer);
        rdobtnDas = (RadioButton) v.findViewById(R.id.rdobtnDas);
        rdobtnDie = (RadioButton) v.findViewById(R.id.rdobtnDie);
        imgvPicture = (ImageView) v.findViewById(R.id.imgvPicture);
        btnCheckNext = (Button) v.findViewById(R.id.btnCheckNext);
        btnCheckNext.setOnClickListener(new CheckAndNext());
        rdogpxAnswers = (RadioGroup) v.findViewById(R.id.rdogpxAnswers);
        rdogpxAnswers.setOnCheckedChangeListener(new whichHasChecked());
        dataAnalyse = new DataAnalyse();
        questionNum = 1;
        txtvName = (TextView) v.findViewById(R.id.txtvName);
        btnCheckNext.setEnabled(false);
        setQuestionOnScreen();
        return v;
    }

    private void setQuestionOnScreen()
    {
        data = dataAnalyse.requestQuestion(questionNum);
        imgvPicture.setImageResource(data.getFirst());
        String question = QuestionNumber() + data.getSecond();
        txtvName.setText(question);
    }

    private String QuestionNumber()
    {
        return "Question " + questionNum + "\r\n";
    }

    private void setAllRadioButtonInital()
    {
        rdobtnDas.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        rdobtnDer.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        rdobtnDie.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        rdogpxAnswers.clearCheck();
        CheckedButton = null;
    }

    private void paintCorrectGreen(String correct)
    {
        switch (correct)
        {
            case "Das":
            rdobtnDas.setBackgroundColor(getResources().getColor(R.color.colorCorrect));
            break;
            case "Der":
                rdobtnDer.setBackgroundColor(getResources().getColor(R.color.colorCorrect));
                break;
            case "Die":
                rdobtnDie.setBackgroundColor(getResources().getColor(R.color.colorCorrect));
                break;
        }
    }

    class CheckAndNext implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            Button b = (Button) v;
            if(b.getText().equals("Check"))
            {
                String answer = CheckedButton.getText().toString();
                if(dataAnalyse.CheckAnswer(questionNum, answer))
                {
                    CheckedButton.setBackgroundColor(getResources().getColor(R.color.colorCorrect));
                }
                else
                {
                    CheckedButton.setBackgroundColor(getResources().getColor(R.color.colorWrong));
                    paintCorrectGreen(data.getThird());
                }
                if(questionNum > 10)
                {
                    b.setText("Show Result");
                }
                else
                {
                    b.setText("Next Question");
                }
            }
            else
            {
                if(b.getText().equals("Next Question"))
                {
                    questionNum++;
                    setQuestionOnScreen();
                    b.setText("Check");
                    btnCheckNext.setEnabled(false);
                }
                else
                {
                    Fragment result = new ResultFragment();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.rltvlotMain, result);
                    ft.commit();
                }
                setAllRadioButtonInital();
            }
        }
    }

    class whichHasChecked implements RadioGroup.OnCheckedChangeListener
    {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            CheckedButton = (RadioButton)v.findViewById(checkedId);
            if((rdobtnDas.isChecked()) || (rdobtnDie.isChecked()) || (rdobtnDer.isChecked()))
            {
                btnCheckNext.setEnabled(true);
            }
        }
    }
}
