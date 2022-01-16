package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextname=findViewById(R.id.editTextTextPersonName);
    }

    public void start(View view) {
        String name=editTextname.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("key", name);
        if (!name.isEmpty()){
            startActivity(intent);}
        else{
        Toast.makeText(this,"Name is required to continue", Toast.LENGTH_LONG).show();}
    }
}
