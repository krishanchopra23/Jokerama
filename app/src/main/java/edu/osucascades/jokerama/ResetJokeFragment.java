package edu.osucascades.jokerama;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class ResetJokeFragment extends DialogFragment {
    //creating the DialogFragment
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.reset_dialog_title)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
