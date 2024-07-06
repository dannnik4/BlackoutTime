package com.example.blackouttime;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TimeChange extends Fragment {

    public static TimeChange newInstance() {
        Bundle args = new Bundle();
        TimeChange fragment = new TimeChange();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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
        View tabLayout = getActivity().findViewById(R.id.tab_layout);
        if (startTime.isEmpty() || endTime.isEmpty()) {
            tabLayout.setBackgroundColor(Color.RED);
        } else {
            tabLayout.setBackgroundColor(Color.GREEN);
        }
    }
}
