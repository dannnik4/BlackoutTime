package com.example.blackouttime;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class TomorrowTab extends Fragment {

    private EditText startTimeEditText, endTimeEditText, intenseStartTimeEditText, intenseEndTimeEditText;
    private CheckBox noBlackoutCheckBox, allDayCheckBox, noIntenseBlackoutCheckBox, intenseAllDayCheckBox;
    private BlackoutViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_layout, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(BlackoutViewModel.class);

        startTimeEditText = rootView.findViewById(R.id.start_time);
        endTimeEditText = rootView.findViewById(R.id.end_time);
        intenseStartTimeEditText = rootView.findViewById(R.id.intense_start_time);
        intenseEndTimeEditText = rootView.findViewById(R.id.intense_end_time);
        noBlackoutCheckBox = rootView.findViewById(R.id.no_blackout);
        allDayCheckBox = rootView.findViewById(R.id.all_day);
        noIntenseBlackoutCheckBox = rootView.findViewById(R.id.no_intense_blackout);
        intenseAllDayCheckBox = rootView.findViewById(R.id.intense_all_day);

        startTimeEditText.setText(viewModel.startTime);
        endTimeEditText.setText(viewModel.endTime);
        intenseStartTimeEditText.setText(viewModel.intenseStartTime);
        intenseEndTimeEditText.setText(viewModel.intenseEndTime);
        noBlackoutCheckBox.setChecked(viewModel.noBlackoutChecked);
        allDayCheckBox.setChecked(viewModel.allDayChecked);
        noIntenseBlackoutCheckBox.setChecked(viewModel.noIntenseBlackoutChecked);
        intenseAllDayCheckBox.setChecked(viewModel.intenseAllDayChecked);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                viewModel.startTime = startTimeEditText.getText().toString();
                viewModel.endTime = endTimeEditText.getText().toString();
                viewModel.intenseStartTime = intenseStartTimeEditText.getText().toString();
                viewModel.intenseEndTime = intenseEndTimeEditText.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        };

        startTimeEditText.addTextChangedListener(textWatcher);
        endTimeEditText.addTextChangedListener(textWatcher);
        intenseStartTimeEditText.addTextChangedListener(textWatcher);
        intenseEndTimeEditText.addTextChangedListener(textWatcher);

        noBlackoutCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> viewModel.noBlackoutChecked = isChecked);
        allDayCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> viewModel.allDayChecked = isChecked);
        noIntenseBlackoutCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> viewModel.noIntenseBlackoutChecked = isChecked);
        intenseAllDayCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> viewModel.intenseAllDayChecked = isChecked);

        return rootView;
    }
}
