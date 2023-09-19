package com.example.myphone;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerview extends RecyclerView.Adapter<recyclerview.ViewHolder> {
    Context context;
    ArrayList<contact> arrContacts;

    recyclerview(Context context,ArrayList<contact> arrContacts){
        this.context=context;
        this.arrContacts=arrContacts;
    }
    @NonNull
    @Override
    public recyclerview.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.contactmodel,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerview.ViewHolder holder, int position) {
        holder.imga.setImageResource(arrContacts.get(position).img);
        holder.textname.setText(arrContacts.get(position).name);
        holder.textnumber.setText(arrContacts.get(position).number);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.add_update);
                EditText editname=dialog.findViewById(R.id.editname);
                EditText editnumber=dialog.findViewById(R.id.editnumber);
                Button button2=dialog.findViewById(R.id.button2);
                button2.setText("update");
                TextView textView=dialog.findViewById(R.id.textview);
                textView.setText("UPDATE VALUE");
                editname.setText(arrContacts.get(position).name);
                editnumber.setText(arrContacts.get(position).number);
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name="",number="";
                        if (!editname.getText().toString().equals("")) {
                            name = editname.getText().toString();

                        } else {
                            Toast.makeText(context, "please enter valid details", Toast.LENGTH_SHORT).show();

                        }
                        if (!editnumber.getText().toString().equals("")) {
                            number = editnumber.getText().toString();
                        } else {
                            Toast.makeText(context, "please enter valid details", Toast.LENGTH_SHORT).show();
                        }
                        arrContacts.set(position,new contact(name,number));
                        notifyItemChanged(position);
                        dialog.dismiss();

                    }
                });
                dialog.show();







            }
        });





    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textname, textnumber;
        ImageView imga;
        LinearLayout linearLayout;
        public ViewHolder(View view) {
            super(view);
            textname=view.findViewById(R.id.textname);
            textnumber=view.findViewById(R.id.textnumber);
            imga=view.findViewById(R.id.imga);
            linearLayout=view.findViewById(R.id.linearlayout);



        }
    }
}

