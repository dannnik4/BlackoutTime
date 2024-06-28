package com.example.myapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.text.Editable;
import android.text.TextWatcher;

public class TimeChange extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        EditText startTimeEditText = rootView.findViewById(R.id.start_time);
        EditText endTimeEditText = rootView.findViewById(R.id.end_time);

        startTimeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkTimeInputs(startTimeEditText, endTimeEditText);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        endTimeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkTimeInputs(startTimeEditText, endTimeEditText);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        return rootView;
    }

    private void checkTimeInputs(EditText startTimeEditText, EditText endTimeEditText) {
        String startTime = startTimeEditText.getText().toString();
        String endTime = endTimeEditText.getText().toString();
        if (startTime.isEmpty() || endTime.isEmpty()) {
            // Если время не введено, подсветка красным
            getActivity().findViewById(R.id.tab_layout).setBackgroundColor(Color.RED);
        } else {
            // Если время введено, подсветка зеленым
            getActivity().findViewById(R.id.tab_layout).setBackgroundColor(Color.GREEN);
        }
    }
}