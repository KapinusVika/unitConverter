package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button btn;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textview);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString().trim();

                if (input.isEmpty()) {
                    textView.setText("Please enter a value.");
                    return;
                }

                try {
                    double kilos = Double.parseDouble(input);
                    double pounds = makeConversion(kilos);
                    textView.setText(String.format("%.2f", pounds));
                } catch (NumberFormatException e) {
                    textView.setText("Invalid input. Please enter a numeric value.");
                }
            }
        });
    }

    public double makeConversion(double kilos) {
        return kilos * 2.20462;
    }
}