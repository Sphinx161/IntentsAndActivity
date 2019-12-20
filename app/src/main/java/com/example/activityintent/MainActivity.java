package com.example.activityintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText showName;
    private EditText showEmail;
    private EditText showPhone;
    private Button showData;

    private final int REQUEST_CODE = 7;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            assert data != null;
            String val = data.getStringExtra("msg");
            Toast.makeText(MainActivity.this,val,Toast.LENGTH_LONG)
                    .show();
            
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showName = findViewById(R.id.show_name);
        showEmail = findViewById(R.id.show_email);
        showPhone = findViewById(R.id.show_phone);
        showData = findViewById(R.id.button);

        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_val = showName.getText().toString();
                String email_val = showEmail.getText().toString();
                String phone_val = showPhone.getText().toString();

                if(!(name_val.isEmpty() || email_val.isEmpty() || phone_val.isEmpty())){
                    Intent i = new Intent(MainActivity.this,displayData.class);
                    i.putExtra("Name",name_val);
                    i.putExtra("Email",email_val);
                    i.putExtra("Phone",phone_val);
                    startActivityForResult(i,REQUEST_CODE);


                }else{
                    Toast.makeText(MainActivity.this,"FIll THE DETAILS",Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }
}
