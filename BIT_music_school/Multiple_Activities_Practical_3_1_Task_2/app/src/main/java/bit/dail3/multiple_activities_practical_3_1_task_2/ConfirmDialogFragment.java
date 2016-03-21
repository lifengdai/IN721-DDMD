package bit.dail3.multiple_activities_practical_3_1_task_2;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;



/**
 * A simple {@link DialogFragment} subclass.
 */
public class ConfirmDialogFragment extends DialogFragment {

    MainActivity mainActivity;

    public ConfirmDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        mainActivity = (MainActivity)getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getResources().getString(R.string.dialog_title));
        builder.setMessage(mainActivity.course());
        builder.setPositiveButton("Yes", new yesButton());
        builder.setNegativeButton("No", new noButton());
        return  builder.create();
    }

    class yesButton implements DialogInterface.OnClickListener
    {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            mainActivity = (MainActivity)getActivity();
            mainActivity.giveMeMyData(true);
        }
    }

    class noButton implements DialogInterface.OnClickListener
    {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            mainActivity = (MainActivity)getActivity();
            mainActivity.giveMeMyData(false);
        }
    }
}
