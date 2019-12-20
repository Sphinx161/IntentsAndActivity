package com.example.activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class displayData extends AppCompatActivity {
    private TextView displayName;
    private TextView displayEmail;
    private TextView displayPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        displayEmail = findViewById(R.id.get_email);
        displayName = findViewById(R.id.get_name);
        displayPhone = findViewById(R.id.get_phone);

        Bundle extra = getIntent().getExtras();

        if(extra != null){
            displayName.setText(extra.getString("Name"));
            displayEmail.setText(extra.getString("Email"));
            displayPhone.setText(extra.getString("Phone"));
        }

        displayName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.putExtra("msg","From activity 2");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
