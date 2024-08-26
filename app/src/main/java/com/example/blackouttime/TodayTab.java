package com.example.blackouttime;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TodayTab extends Fragment {

    private EditText startTimeEditText, endTimeEditText, intenseStartTimeEditText, intenseEndTimeEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_layout, container, false);

        startTimeEditText = rootView.findViewById(R.id.start_time);
        endTimeEditText = rootView.findViewById(R.id.end_time);
        intenseStartTimeEditText = rootView.findViewById(R.id.intense_start_time);
        intenseEndTimeEditText = rootView.findViewById(R.id.intense_end_time);

        return rootView;
    }
}