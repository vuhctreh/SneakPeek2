package com.victor.sneakpeek2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * The type Edit shoe.
 */
public class EditShoe extends AppCompatActivity {

    /**
     * The Shoe name.
     */
    EditText shoeName, /**
     * The Shoe sku.
     */
    shoeSku;
    /**
     * The Db.
     */
    CollectionDatabase db;
    /**
     * The Shoe.
     */
    Shoe shoe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_shoe);

        // Set toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        shoeName = findViewById(R.id.name);
        shoeSku = findViewById(R.id.sku);

        //gets the ID of the shoe passed via the intent
        Intent i = getIntent();
        long id = i.getLongExtra("ID", 0);

        //gets shoe with matchin ID from database
        db = new CollectionDatabase(this);
        shoe = db.getShoe(id);

        // sets action bar title
        getSupportActionBar().setTitle("Edit: ");

        //sets text of EditTexts using retrieved Shoe from db
        shoeName.setText(shoe.getName());
        shoeSku.setText(shoe.getSku());

        // onClick to delete shoe from database.
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener((view) -> {
            db.deleteShoe(shoe.getID());
            goToMain();
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    // creates menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit_menu, menu);
        return true;
    }

    // handle save button press in toolbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // if ids match, updates shoe object and calls editShoe method.
        if (item.getItemId() == R.id.editShoe){
            shoe.setName(shoeName.getText().toString());
            shoe.setSku(shoeSku.getText().toString());
            int editId = db.editShoe(shoe);
            /*
            * As IDs auto-increment they are assumed to be unique, thus only one
            * entry should be edited in the db meaning editShoe returns 1. If statement
            * below checks for successful edit.
            * */
            if(editId == 1)
                // redirect to activity main
                goToMain();
            else {
                // if error, display toast
                Toast.makeText(this, "An error occured while saving.", Toast.LENGTH_SHORT).show();
            }
        }

        // handle back button click
        if(item.getItemId() == android.R.id.home) {
            goToMain();
        }

        return super.onOptionsItemSelected(item);
    }

    // return to MainActivity
    private void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}