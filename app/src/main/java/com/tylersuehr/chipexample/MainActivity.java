package com.tylersuehr.chipexample;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.tylersuehr.chips.ChipsInputLayout;

import java.util.List;

/**
 * Copyright © 2017 Tyler Suehr
 *
 * @author Tyler Suehr
 * @version 1.0
 */
public class MainActivity extends ContactLoadingActivity
        implements ContactOnChipAdapter.OnContactClickListener {
    private ChipsInputLayout mChipsInput;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup chips input
        mChipsInput = (ChipsInputLayout)findViewById(R.id.chips_input);
        mChipsInput.setImageRenderer(new GlideRenderer());

        // Load the current user's contact information
        loadContactsWithRuntimePermission();
    }

    /**
     * When we have contact chips available, let's make them filterable in our ChipsInputView!
     */
    @Override
    protected void onContactsAvailable(List<ContactChip> chips) {
        System.out.println("Number of contacts: " + chips.size());
        mChipsInput.setFilterableChipList(chips);
    }

    @Override
    protected void onContactsReset() {}

    @Override
    public void onContactClicked(ContactChip chip) {}
}