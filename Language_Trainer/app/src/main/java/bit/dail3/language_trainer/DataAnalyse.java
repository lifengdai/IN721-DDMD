package bit.dail3.language_trainer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dailifeng on 16/3/26.
 */
public class DataAnalyse
{
    private Random random;
    private ArrayList<Tuples<Integer, String, String>> qc;
    private static int CorrectQuestions;

    public DataAnalyse()
    {
        random = new Random();
        CorrectQuestions = 0;
        QuestionDatabase.inital();
        RandomlizeQuestions();
    }

    private void RandomlizeQuestions()
    {
        qc = QuestionDatabase.getQuestionCode();
        Tuples<Integer, String, String> temp = null;

        for (int i = 0; i < 100; i++)
        {
            int randnum1 = random.nextInt(11);
            int randnum2 = random.nextInt(11);

            if (randnum1 != randnum2)
            {
                temp = qc.get(randnum1);
                qc.set(randnum1, qc.get(randnum2));
                qc.set(randnum2, temp);
            }
        }
    }

    public boolean CheckAnswer(int index, String answer)
    {
        Tuples<Integer, String, String> temp = qc.get(index - 1);
        if(temp.getThird().equals(answer))
        {
            CorrectQuestions++;
            return true;
        }
        else
        {
            return false;
        }
    }

    public Tuples<Integer, String, String> requestQuestion(int index)
    {
        return qc.get(index - 1);
    }

    public static int getCorrectQuestions() {
        return CorrectQuestions;
    }
}
