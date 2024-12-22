package com.geeks.hw31;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        TextView receivedMessage = findViewById(R.id.receivedMessage);

        String message = getIntent().getStringExtra("MESSAGE_KEY");
        if (message != null && !message.isEmpty()) {
            receivedMessage.setText(message);
        } else {
            receivedMessage.setText("No message received.");
        }
    }
}

