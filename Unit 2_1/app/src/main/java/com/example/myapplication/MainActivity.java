package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int num;
    String name, Customer;

    EditText ID;
    EditText Name;
    EditText Address;

    Button SubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.CustomerName);
        Address = (EditText) findViewById(R.id.CustomerAddress);
        ID = (EditText) findViewById(R.id.CustomerID);

        SubmitButton = (Button) findViewById(R.id.SubmitButton);
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = Name.getText().toString();
                Customer = Address.getText().toString();
                num = Integer.valueOf(ID.getText().toString());

                if (num > 999)
                {
                    ShowToast("The ID you entered is too high.");
                }
                for(int i=0; i < Customer.length(); i++) {
                    Boolean flag = Character.isDigit(Customer.charAt(i));
                    if (flag) {
                        System.out.println("Numbers are not allowed in this field.");
                    }
                }

                if (name == null || Customer == null || ID.getText().toString() == null)
                {
                    ShowToast("Each field must have value.");
                }

            }
        });

    }

    private void ShowToast(String text)
    {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

}