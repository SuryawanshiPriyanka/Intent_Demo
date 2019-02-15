package com.example.abhinav.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {

    TextView txt_fname,txt_mname,txt_lname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        txt_fname=(TextView)findViewById(R.id.txt_fname);
        txt_mname=(TextView)findViewById(R.id.txt_mname);
        txt_lname=(TextView)findViewById(R.id.txt_lname);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String mname = intent.getStringExtra("mname");
        String lname = intent.getStringExtra("lname");

        txt_fname.setText(name);
        txt_mname.setText(mname);
        txt_lname.setText(intent.getStringExtra("lname"));

        Toast.makeText(this, ""+name +" "+mname +" "+lname, Toast.LENGTH_SHORT).show();

    }
}
