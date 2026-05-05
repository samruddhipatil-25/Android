package com.example.notificationfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String channel_id = "01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.button);

        // Create notification channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    channel_id,
                    "CHANNEL_01",
                    NotificationManager.IMPORTANCE_HIGH
            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        b.setOnClickListener(v -> {
            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(MainActivity.this, channel_id)
                            .setSmallIcon(R.drawable.java)
                            .setContentTitle("Notification of Application")
                            .setContentText("This is my first push notification")
                            .setPriority(NotificationCompat.PRIORITY_HIGH);

            // Android 13+ permission check
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(
                            new String[]{Manifest.permission.POST_NOTIFICATIONS},
                            100
                    );
                    Toast.makeText(this, "Allow notification permission and click again", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            NotificationManagerCompat.from(this)
                    .notify((int) System.currentTimeMillis(), builder.build());
        });
    }
}