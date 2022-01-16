package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView textViewName;
    CheckBox milk;
    CheckBox lemon;
    CheckBox sugar;
    Spinner spinnerTea;
    Spinner spinnerCoffee;
    String result;
    String hello;
    String nameOfDrink;
    StringBuilder add=new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewName = findViewById(R.id.textView);
        hello = getIntent().getStringExtra("key");
        textViewName.setText("Привет, " + hello + "!");
        spinnerTea = findViewById(R.id.spinnerTea);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);
        milk = findViewById(R.id.checkBoxMilk);
        lemon = findViewById(R.id.checkBoxLemon);
        sugar = findViewById(R.id.checkBoxSugar);
    }

    public void choose_drink(View view) {
        if (view.getId()==R.id.radioButtonTea){
            nameOfDrink = "Tea";
            spinnerTea.setVisibility(View.VISIBLE);
            spinnerCoffee.setVisibility(View.GONE);
        }else{
            nameOfDrink = "Coffee";
            spinnerTea.setVisibility(View.GONE);
            spinnerCoffee.setVisibility(View.VISIBLE);
        }
    }

    public void order(View view) {
        if (nameOfDrink=="Tea"){
            String []tarr = getResources().getStringArray(R.array.tea);
            result = tarr[spinnerTea.getSelectedItemPosition()];
        }else{
            String []carr = getResources().getStringArray(R.array.Coffee);
            result = carr[spinnerCoffee.getSelectedItemPosition()];
        }
        if(milk.isChecked()){
            add.append("milk ");
        }
        if(lemon.isChecked()){
            add.append("lemon ");
        }
        if(sugar.isChecked()){
            add.append("sugar ");
        }
        String odresult = String.format("Клиент %s заказал напиток %s с добавками %s", hello, result, add.toString());
        Toast.makeText(this, odresult, Toast.LENGTH_LONG).show();
    }
}