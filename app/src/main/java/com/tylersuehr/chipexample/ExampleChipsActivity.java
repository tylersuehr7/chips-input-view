package com.tylersuehr.chipexample;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import com.tylersuehr.chips.ChipsInputLayout;
import java.util.List;

/**
 * Copyright © 2017 Tyler Suehr
 *
 * @author Tyler Suehr
 * @version 1.0
 */
public class ExampleChipsActivity extends ContactLoadingActivity
        implements ContactOnChipAdapter.OnContactClickListener {
    private ContactOnChipAdapter contactAdapter;
    private ChipsInputLayout chipsInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_chips);

        // Setup toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup the recycler
        this.contactAdapter = new ContactOnChipAdapter(this);
        RecyclerView recycler = (RecyclerView)findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(contactAdapter);

        // Setup chips input
        this.chipsInput = (ChipsInputLayout)findViewById(R.id.chips_input);

        // Load the current user's contact information
        loadContactsWithRuntimePermission();
    }

    /**
     * When we have contact chips available, let's make them filterable in our ChipsInputView!
     */
    @Override
    protected void onContactsAvailable(List<ContactChip> chips) {
        System.out.println("Number of contacts: " + chips.size());
        this.chipsInput.setFilterableChipList(chips);
    }

    @Override
    protected void onContactsReset() {

    }

    @Override
    public void onContactClicked(ContactChip chip) {

    }
}