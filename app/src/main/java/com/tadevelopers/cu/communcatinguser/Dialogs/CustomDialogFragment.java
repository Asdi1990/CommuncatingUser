package com.tadevelopers.cu.communcatinguser.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.tadevelopers.cu.communcatinguser.R;

import java.util.zip.Inflater;

public class CustomDialogFragment extends DialogFragment {
    private final String TAG = "AUC_CUSTOM";
    private EditText editTextFN;
    private EditText editTextLN;

    private ExampleDialogListener mHost;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mHost = (ExampleDialogListener)context;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public interface ExampleDialogListener{
        void applyText(String firstName,String lastname);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // TODO: Create the custom layout using the LayoutInflater class
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.custom_dialog_layout,null);

        // TODO: Build the dialog
        builder.setTitle("Please enter your name")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "OK Clicked");
                        String firstN = editTextFN.getText().toString();
                        String firstL = editTextLN.getText().toString();
                        mHost.applyText(firstN,firstL);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "Cancel clicked");
                    }
                }).setView(v);
        editTextFN = v.findViewById(R.id.edtFirstName);
        editTextLN = v.findViewById(R.id.edtLastName);

        return builder.create();
    }
}
