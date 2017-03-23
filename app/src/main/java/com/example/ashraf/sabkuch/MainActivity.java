package com.example.ashraf.sabkuch;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button001);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });
        AlertDialog.Builder alertdialoguebilder=new AlertDialog.Builder(this);
        alertdialoguebilder.setMessage("hi button dabao");
        alertdialoguebilder.setPositiveButton("abhi time hai", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"nahiiiiii",Toast.LENGTH_SHORT).show();

            }
        });
        alertdialoguebilder.setNegativeButton("Pleaaaase", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"okaaaayyyyy",Toast.LENGTH_SHORT).show();
            }
        });
        alertdialoguebilder.setNeutralButton("Get Lost!!!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alertDialog=alertdialoguebilder.create();
        alertDialog.show();


    }
}
