package com.geeks.hw31;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendMessageButton = findViewById(R.id.sendMessageButton);
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Hello, this is your message!";

                openGmail(message);

                navigateToSecondActivity(message);
            }
        });
    }

    private void openGmail(String message) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"example@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.setPackage("com.google.android.gm");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send email using:"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void navigateToSecondActivity(String message) {
        Intent secondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
        secondActivityIntent.putExtra("MESSAGE_KEY", message);
        startActivity(secondActivityIntent);
    }
}
