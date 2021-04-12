package com.victor.sneakpeek2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Toolbar toolbar;
    ViewPager viewPager;
    AdapterCards adapterCards;
    AdapterShoes adapterShoes;
    List<Shoe> shoes;
    List<Model> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Your collection.");
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.collectionView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CollectionDatabase db = new CollectionDatabase(this);
        adapterShoes = new AdapterShoes(this, db.getShoes());
        recyclerView.setAdapter(adapterShoes);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.img01, "Air Jordan 1 UNC", "Blue shoe for blue toes"));
        models.add(new Model(R.drawable.img02, "Nike Dunk Low City Market", "Bad shoe too much plastic"));
        models.add(new Model(R.drawable.img03, "Nike x Supreme SB Dunk Low", "Movie"));

        adapterCards = new AdapterCards(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapterCards);
        viewPager.setPadding(130, 0,130,0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add){
            Intent i = new Intent(this, AddShoe.class);
            startActivity(i);
            // Toast.makeText(this, "button has been clicked", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}