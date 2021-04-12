package com.victor.sneakpeek2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * The type Add shoe.
 */
public class AddShoe extends AppCompatActivity {

    /**
     * The Toolbar.
     */
    Toolbar toolbar;
    /**
     * The Shoe name.
     */
    EditText shoeName,
    /**
     * The Shoe sku.
     */
    shoeSKU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shoe);

        //Set toolbar title
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Add to your collection: ");
        // Set toolbar as action bar and enable back button
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Assign elements in view to their respective variables
        shoeName = findViewById(R.id.shoeName);
        shoeSKU = findViewById(R.id.sku);
    }

    // creates options menu using save_menu layout
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // handles menu being clicked
        if(item.getItemId() == R.id.save){
            // saves contents of fields shoeName and shoeSKU to SQL database
            Shoe shoe = new Shoe(shoeName.getText().toString(), shoeSKU.getText().toString());
            CollectionDatabase db = new CollectionDatabase(this);
            db.addShoe(shoe);
            //toast notification upon successful save
            Toast.makeText(this, "Successfully added to collection.", Toast.LENGTH_SHORT).show();
            // redirect to main activity
            goToMain();
        }
        if(item.getItemId() == android.R.id.home) {
            //handle back button click
            goToMain();
        }
        return true;
    }

    private void goToMain() {
        // redirects to main
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}