package com.example.myapplication211;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private long startTime;
    private long totalTime = 0; // Total visible time in milliseconds
    private TextView timeTextView;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate called");

        // Initialize the TextView and Button
        timeTextView = findViewById(R.id.timeTextView);
        resetButton = findViewById(R.id.resetButton);

        // Set the initial text
        updateTextView();

        // Set OnClickListener for the reset button
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalTime = 0;
                updateTextView();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called");
        startTime = System.currentTimeMillis();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");

        // Calculate visible time and add to totalTime
        long endTime = System.currentTimeMillis();
        totalTime += (endTime - startTime);
        updateTextView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }

    // Update the TextView with the current total visible time in seconds
    private void updateTextView() {
        int seconds = (int) (totalTime / 1000);
        timeTextView.setText("Total time: " + seconds + " seconds");
    }
}