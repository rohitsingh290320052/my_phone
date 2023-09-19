package com.example.myphone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<contact> arrcontacts = new ArrayList<>();
    recyclerview adapter;
    RecyclerView recycle;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycle = findViewById(R.id.recycle);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update);
                EditText editname=dialog.findViewById(R.id.editname);
                TextView textView=dialog.findViewById(R.id.textview);
                EditText editnumber=dialog.findViewById(R.id.editnumber);
                Button button2=dialog.findViewById(R.id.button2);
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name="",number="";
                        if (!editname.getText().toString().equals("")) {
                            name = editname.getText().toString();

                        } else {
                            Toast.makeText(MainActivity.this, "please enter valid details", Toast.LENGTH_SHORT).show();

                        }
                        if (!editnumber.getText().toString().equals("")) {
                            number = editnumber.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "please enter valid details", Toast.LENGTH_SHORT).show();
                        }
                        arrcontacts.add(new contact(name,number));
                        adapter.notifyItemInserted(arrcontacts.size()-1);
                        recycle.scrollToPosition(arrcontacts.size()-1);
                        dialog.dismiss();






                    }
                });

                dialog.show();



            }
        });
        recycle.setLayoutManager(new LinearLayoutManager(this));
        arrcontacts.add(new contact(R.drawable.i, "Ankit", "987412563"));
        arrcontacts.add(new contact(R.drawable.i, "Yuvi", "987431500"));
        arrcontacts.add(new contact(R.drawable.i, "Arav", "987431556"));
        arrcontacts.add(new contact(R.drawable.i, "random", "984546545"));
        arrcontacts.add(new contact(R.drawable.i, "Abhi", "987434446"));
        arrcontacts.add(new contact(R.drawable.i, "roundd", "984547415"));
        adapter=new recyclerview(this,arrcontacts);
        recycle.setAdapter(adapter);





    }
}