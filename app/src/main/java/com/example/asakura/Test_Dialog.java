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
import android.widget.Button;

public class Test_Dialog extends AppCompatDialogFragment {
    //The Objects for the EditText view in the Dialog and the listener
    EditText editTextInput;
    ExampleDialogListeners listener;
    Button buttonSubmit;
    Button buttonCancel;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        //Inflate the View using the layout for the AlertDialog
        View view = inflater.inflate(R.layout.layout_dialog, null);

        //EditText and Button Objects for the Views in the layout
        editTextInput = view.findViewById(R.id.input);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);
        buttonCancel = view.findViewById(R.id.buttonCancel);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        /*
        This is where I would use the if Statement to change the text color based on the content of the
        EditTextObject...or in this case, editTextInput
        */
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editTextInput.getText().toString();
                listener.applyTexts(input);
                dismiss();
            }
        });

        /*
        dialogBuilder.setView(dialogView);
        dialogBuilder.show();
        */
        //Use the inflated View object to build the AlertDialog
        builder.setView(view).setTitle("Enter Zipcode");

        //Return the AlertDialog
        return builder.create();
    }

    //Exception handler method
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListeners) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ");
        }
    }

    //This will allow the Main Activity to accept information from this Dialog
    //Activity must implement Test_Dialog.(name of the interface below)
    public interface ExampleDialogListeners {
        void applyTexts(String input);
    }
}
