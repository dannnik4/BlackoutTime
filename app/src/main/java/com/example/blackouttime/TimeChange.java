package com.example.blackouttime;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.blackouttime.Time;

public class TimeChange extends Time {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static TimeChange newInstance(int sectionNumber) {
        TimeChange fragment = new TimeChange();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public TimeChange() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.time, container, false);

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