package com.example.adminqrcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.journeyapps.barcodescanner.CaptureActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnScan;
    private TextView tvLicense;
    private TextView tvVehicleType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScan = findViewById(R.id.btn_scan);
        tvLicense = findViewById(R.id.tv_license);
        tvVehicleType = findViewById(R.id.tv_vhtype);

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the QR code scanner
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) { //Display yung Result ng License Driver
            // kukunin yung result ng qrcode
            String result = data.getStringExtra("SCAN_RESULT");
            tvLicense.setText(result); // Set scanned result to TextView
        }

        if (data != null) { //Display yung Result ng Vehicle Type Driver
            // kukunin yung result ng qrcode
            String result = data.getStringExtra("SCAN_RESULT");
            tvVehicleType.setText(result); // Set scanned result to TextView
        }
    }
}