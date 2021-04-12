package com.victor.sneakpeek2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SelectedCardActivity extends AppCompatActivity {
    TextView tvCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_card);

        tvCard = findViewById(R.id.selectedCard);

        Intent intent = getIntent();

        if(intent.getExtras() != null) {
            Model model = (Model) intent.getSerializableExtra("data");

            tvCard.setText(model.getTitle());
        }
    }
}