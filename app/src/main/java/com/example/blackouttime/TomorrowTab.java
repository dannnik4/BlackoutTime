package com.example.blackouttime;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.Calendar;

public class TomorrowTab extends Fragment {

    private CheckBox noBlackoutCheckBox, allDayCheckBox, noIntenseBlackoutCheckBox, intenseAllDayCheckBox;
    private Button selectStartTimeButton, selectEndTimeButton, selectIntenseStartTimeButton, selectIntenseEndTimeButton;
    private BlackoutViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_layout, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(BlackoutViewModel.class);

        noBlackoutCheckBox = rootView.findViewById(R.id.no_blackout);
        allDayCheckBox = rootView.findViewById(R.id.all_day);
        noIntenseBlackoutCheckBox = rootView.findViewById(R.id.no_intense_blackout);
        intenseAllDayCheckBox = rootView.findViewById(R.id.intense_all_day);

        selectStartTimeButton = rootView.findViewById(R.id.select_start_time);
        selectEndTimeButton = rootView.findViewById(R.id.select_end_time);
        selectIntenseStartTimeButton = rootView.findViewById(R.id.select_intense_start_time);
        selectIntenseEndTimeButton = rootView.findViewById(R.id.select_intense_end_time);

        noBlackoutCheckBox.setChecked(viewModel.noBlackoutChecked);
        allDayCheckBox.setChecked(viewModel.allDayChecked);
        noIntenseBlackoutCheckBox.setChecked(viewModel.noIntenseBlackoutChecked);
        intenseAllDayCheckBox.setChecked(viewModel.intenseAllDayChecked);

        selectStartTimeButton.setText(viewModel.startTime.isEmpty() ? "Выбрать начало" : viewModel.startTime);
        selectEndTimeButton.setText(viewModel.endTime.isEmpty() ? "Выбрать конец" : viewModel.endTime);
        selectIntenseStartTimeButton.setText(viewModel.intenseStartTime.isEmpty() ? "Начало усиленных отключений" : viewModel.intenseStartTime);
        selectIntenseEndTimeButton.setText(viewModel.intenseEndTime.isEmpty() ? "Конец усиленных отключений" : viewModel.intenseEndTime);

        selectStartTimeButton.setOnClickListener(v -> showTimePickerDialog("start"));
        selectEndTimeButton.setOnClickListener(v -> showTimePickerDialog("end"));
        selectIntenseStartTimeButton.setOnClickListener(v -> showTimePickerDialog("intense_start"));
        selectIntenseEndTimeButton.setOnClickListener(v -> showTimePickerDialog("intense_end"));

        noBlackoutCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> viewModel.noBlackoutChecked = isChecked);
        allDayCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> viewModel.allDayChecked = isChecked);
        noIntenseBlackoutCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> viewModel.noIntenseBlackoutChecked = isChecked);
        intenseAllDayCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> viewModel.intenseAllDayChecked = isChecked);

        return rootView;
    }

    private void showTimePickerDialog(String type) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), (TimePicker view, int hourOfDay, int minuteOfHour) -> {
            String formattedTime = String.format("%02d:%02d", hourOfDay, minuteOfHour);

            if (type.equals("start")) {
                viewModel.startTime = formattedTime;
                selectStartTimeButton.setText(formattedTime);
            } else if (type.equals("end")) {
                viewModel.endTime = formattedTime;
                selectEndTimeButton.setText(formattedTime);
            } else if (type.equals("intense_start")) {
                viewModel.intenseStartTime = formattedTime;
                selectIntenseStartTimeButton.setText(formattedTime);
            } else if (type.equals("intense_end")) {
                viewModel.intenseEndTime = formattedTime;
                selectIntenseEndTimeButton.setText(formattedTime);
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }
}
