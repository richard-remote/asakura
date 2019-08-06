package com.example.asakura;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class Test_Dialog extends AppCompatDialogFragment {
    //The Objects for the EditText view in the Dialog and the listener
    EditText editTextInput;
    ExampleDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        //Inflate the View using the layout for the AlertDialog
        View view = inflater.inflate(R.layout.layout_dialog, null);

        //Use the inflated View object to build the AlertDialog
        builder.setView(view).setTitle("Enter Zipcode"); 

        //EditText Object for the input EditText View
        editTextInput = view.findViewById(R.id.input);
        editTextInput.setOnKeyListener();
        //Return the AlertDialog
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener {
        void applyTexts(String username);
    }
}
