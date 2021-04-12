package com.victor.sneakpeek2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /**
     * The Recycler view.
     */
    RecyclerView recyclerView;
    /**
     * The Toolbar.
     */
    Toolbar toolbar;
    /**
     * The View pager.
     */
    ViewPager viewPager;
    /**
     * The Adapter cards.
     */
    AdapterCards adapterCards;
    /**
     * The Adapter shoes.
     */
    AdapterShoes adapterShoes;
    /**
     * The Models.
     */
    List<Model> models;
    /**
     * The Db.
     */
    CollectionDatabase db = new CollectionDatabase(this);
    /**
     * The Spinner.
     */
    Spinner spinner;
    /**
     * The Selected index.
     */
    int selectedIndex;
    /**
     * The Selected size.
     */
    String selectedSize;
    /**
     * The Saved index.
     */
    int savedIndex;
    /**
     * The Saved size.
     */
    String savedSize;

    /**
     * The constant SHARED_PREFS.
     */
    public static final String SHARED_PREFS = "sharedPrefs";
    /**
     * The constant TEXT.
     */
    public static final String TEXT = "text";
    /**
     * The constant SIZE.
     */
    public static final String SIZE = "size";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // handles spinner initialisation on view
        spinner = findViewById(R.id.sizeSpinner);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.sizes, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);

        // loads SharedPreferences and updates views.
        loadData();
        updateViews();

        // loads toolbar
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Your collection.");
        setSupportActionBar(toolbar);

        // initiates recyclerView of user-made shoes using SQL db
        recyclerView = findViewById(R.id.collectionView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterShoes = new AdapterShoes(this, db.getShoes());
        recyclerView.setAdapter(adapterShoes);

        // Cards to be added to viewPager
        models = new ArrayList<>();
        models.add(new Model(R.drawable.img01, "Air Jordan 1 UNC", "555088-134", "£140", "06/03/2021"));
        models.add(new Model(R.drawable.img02, "Nike Dunk Low City Market", "DA6125-900", "£90", "04/03/2021"));
        models.add(new Model(R.drawable.img03, "Nike x Supreme SB Dunk Low", "DH3228-100", "£85", "04/03/2021"));

        adapterCards = new AdapterCards(models, this, savedSize);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapterCards);
        viewPager.setPadding(130, 0, 130, 0);
    }

    // creates toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_menu, menu);
        return true;
    }

    // Handle selection of "+" button on toolbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // redirect to AddShoe activity.
        if (item.getItemId() == R.id.add) {
            Intent i = new Intent(this, AddShoe.class);
            startActivity(i);
        }
        return true;
    }

    // Calls saveData to save select item in spinner to SharedPreferences
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedIndex = position;
        selectedSize = parent.getItemAtPosition(position).toString();
        saveData();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    /**
     * Save data to SharedPreferences.
     */
    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // puts selection from spinner into SharedPreferences
        editor.putInt(TEXT, selectedIndex);
        editor.putString(SIZE, selectedSize);
        editor.apply();
    }

    /**
     * Load data from SharedPreferences.
     */
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        savedIndex = sharedPreferences.getInt(TEXT, 1);
        savedSize = sharedPreferences.getString(SIZE, "7");
    }

    /**
     * Update views to savedSize.
     */
    public void updateViews() {
        spinner.setSelection(savedIndex);
        adapterCards = new AdapterCards(models, this, savedSize);
    }

}

