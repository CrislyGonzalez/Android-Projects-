package com.example.crisly_pc.laboratorio3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.DialogFragment;


public class TecDialogFragment extends DialogFragment{

    public static final String ARGUMENTO_TITLE = " TITLE ";
    public static final String ARGUMENTO_FULL_SNIPPET = " FULL_SNIPPET ";
    private String title;
    private String fullSnippet;


    public TecDialogFragment() {}


    public static TecDialogFragment newInstance(String title, String fullSnippet) {
            TecDialogFragment fragment = new TecDialogFragment();
            Bundle b = new Bundle();
            b.putString(ARGUMENTO_TITLE , title);
            b.putString(ARGUMENTO_FULL_SNIPPET , fullSnippet);
            fragment.setArguments(b);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        Bundle args = getArguments();
        title = args.getString(ARGUMENTO_TITLE);
        fullSnippet = args.getString(ARGUMENTO_FULL_SNIPPET);
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(fullSnippet)
                .create();
        return dialog;
    }


}
