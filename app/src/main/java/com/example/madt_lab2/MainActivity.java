package com.example.madt_lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Spinner spnChoice;
    private EditText editText;
    private TextView txtViewRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spnChoice = findViewById(R.id.spinner);
        editText = findViewById(R.id.editText);
        txtViewRes = findViewById(R.id.txtViewRes);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.count_options, android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnChoice.setAdapter(adapter);
    }

    public void Count(View view) {
        String input = editText.getText().toString().trim();

        if (input.isEmpty()) {
            Toast.makeText(this, "Enter some text", Toast.LENGTH_SHORT).show();
            return;
        }

        TextCounting counter = new TextCounting();

        String choice = spnChoice.getSelectedItem().toString();
        int result;

        if (choice.equals("Words")) {
            result = counter.countWords(input);
        } else {
            result = counter.countCharacters(input);
        }

        txtViewRes.setText("Count: " + result);
    }
}


