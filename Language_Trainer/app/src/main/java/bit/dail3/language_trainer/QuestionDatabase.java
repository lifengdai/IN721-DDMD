package bit.dail3.language_trainer;

import java.util.ArrayList;

/**
 * Created by dailifeng on 16/3/26.
 */
public class QuestionDatabase
{
    private static ArrayList<Tuples<Integer, String, String>> QuestionCode;

    private QuestionDatabase(){}

    public static void inital()
    {
        QuestionCode = new ArrayList<>();
        QuestionCode.add(new Tuples<>(R.drawable.das_auto, "auto", "Das"));
        QuestionCode.add(new Tuples<>(R.drawable.das_haus, "haus", "Das"));
        QuestionCode.add(new Tuples<>(R.drawable.das_schaf, "schaf", "Das"));
        QuestionCode.add(new Tuples<>(R.drawable.der_apfel, "apfel", "Der"));
        QuestionCode.add(new Tuples<>(R.drawable.der_baum, "baum", "Der"));
        QuestionCode.add(new Tuples<>(R.drawable.der_stuhl, "stuhl", "Der"));
        QuestionCode.add(new Tuples<>(R.drawable.die_ente, "ente", "Die"));
        QuestionCode.add(new Tuples<>(R.drawable.die_hexe, "hexe", "Die"));
        QuestionCode.add(new Tuples<>(R.drawable.die_kuh, "kuh", "Die"));
        QuestionCode.add(new Tuples<>(R.drawable.die_milch, "milch", "Die"));
        QuestionCode.add(new Tuples<>(R.drawable.die_strasse, "strasse", "Die"));
    }

    public static ArrayList<Tuples<Integer, String, String>> getQuestionCode() {
        return QuestionCode;
    }

    public static void setQuestionCode(ArrayList<Tuples<Integer, String, String>> questionCode) {
        QuestionCode = questionCode;
    }
}
