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

public class AddShoe extends AppCompatActivity {

    Toolbar toolbar;
    EditText shoeName, shoeSKU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shoe);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Add to your collection: ");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        shoeName = findViewById(R.id.shoeName);
        shoeSKU = findViewById(R.id.sku);

        shoeName.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0){

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.save){
            Shoe shoe = new Shoe(shoeName.getText().toString(), shoeSKU.getText().toString());
            CollectionDatabase db = new CollectionDatabase(this);
            db.addShoe(shoe);
            Toast.makeText(this, "Successfully added to collection.", Toast.LENGTH_SHORT).show();
            goToMain();
        }
        if(item.getItemId() == R.id.delete){
            Toast.makeText(this, "Shoe discarded", Toast.LENGTH_SHORT).show();
            goToMain();
        }
        return true;
    }

    private void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}