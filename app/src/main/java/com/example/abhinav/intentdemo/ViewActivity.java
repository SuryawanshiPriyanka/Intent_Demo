package com.example.abhinav.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {

    //TextView txt_fname,txt_mname,txt_lname;
   // EditText edtxt_firstname,edtxt_middelname,edtxt_lastname;
    EditText edtxt_name,edtxt_age,edtxt_mobileno;
    Button btn_okay;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        edtxt_name=(EditText)findViewById(R.id.edtxt_name);
        edtxt_age=(EditText)findViewById(R.id.edtxt_age);
        edtxt_mobileno=(EditText)findViewById(R.id.edtxt_mobileno);
        btn_okay=(Button)findViewById(R.id.btn_okay);
        btn_okay.setOnClickListener(this);
       /* txt_fname=(TextView)findViewById(R.id.txt_fname);
        txt_mname=(TextView)findViewById(R.id.txt_mname);
        txt_lname=(TextView)findViewById(R.id.txt_lname);*/
/*
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String mname = intent.getStringExtra("mname");
        String lname = intent.getStringExtra("lname");

        txt_fname.setText(name);
        txt_mname.setText(mname);
        txt_lname.setText(intent.getStringExtra("lname"));

        Toast.makeText(this, ""+name +" "+mname +" "+lname, Toast.LENGTH_SHORT).show();*/

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btn_okay)
        {
           Intent intent=new Intent();
            intent.putExtra("name",edtxt_name.getText().toString());
            intent.putExtra("age",edtxt_age.getText().toString());
            intent.putExtra("mobileno",edtxt_mobileno.getText().toString());
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
