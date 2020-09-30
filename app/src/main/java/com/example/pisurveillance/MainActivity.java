package com.example.pisurveillance;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "FirebaseMessagingServce";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Subscribe to the topic for FCM
        FirebaseMessaging.getInstance().subscribeToTopic("pushNotifications")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    // Print to the screen the result of subscription
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "successful";
                        if (!task.isSuccessful()) {
                            msg = "failed";
                        }
                        Log.d(TAG, msg);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

        Toast.makeText(getApplicationContext(), "Topic Subscribed", Toast.LENGTH_LONG).show();
    }

}