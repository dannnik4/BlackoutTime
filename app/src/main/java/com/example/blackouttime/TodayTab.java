package com.example.blackouttime;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TodayTab extends Fragment {

    private EditText startTimeEditText, endTimeEditText, intenseStartTimeEditText, intenseEndTimeEditText;
    private CheckBox noBlackoutCheckBox, noIntenseBlackoutCheckBox;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_layout, container, false);

        startTimeEditText = rootView.findViewById(R.id.start_time);
        endTimeEditText = rootView.findViewById(R.id.end_time);
        intenseStartTimeEditText = rootView.findViewById(R.id.intense_start_time);
        intenseEndTimeEditText = rootView.findViewById(R.id.intense_end_time);

        noBlackoutCheckBox = rootView.findViewById(R.id.no_blackout);
        noIntenseBlackoutCheckBox = rootView.findViewById(R.id.no_intense_blackout);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkTimeInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };

        startTimeEditText.addTextChangedListener(textWatcher);
        endTimeEditText.addTextChangedListener(textWatcher);
        intenseStartTimeEditText.addTextChangedListener(textWatcher);
        intenseEndTimeEditText.addTextChangedListener(textWatcher);

        noBlackoutCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> checkTimeInputs());
        noIntenseBlackoutCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> checkTimeInputs());

        return rootView;
    }

    private void checkTimeInputs() {
        boolean isBlackoutTimeValid = noBlackoutCheckBox.isChecked() ||
                (!startTimeEditText.getText().toString().isEmpty() && !endTimeEditText.getText().toString().isEmpty());

        boolean isIntenseBlackoutTimeValid = noIntenseBlackoutCheckBox.isChecked() ||
                (!intenseStartTimeEditText.getText().toString().isEmpty() && !intenseEndTimeEditText.getText().toString().isEmpty());

        View tabLayout = getActivity().findViewById(R.id.bottom_navigation_view);
        if (isBlackoutTimeValid && isIntenseBlackoutTimeValid) {
            tabLayout.findViewById(R.id.todaytab).setBackgroundColor(Color.GREEN);
        } else {
            tabLayout.findViewById(R.id.todaytab).setBackgroundColor(Color.RED);
        }
    }
}