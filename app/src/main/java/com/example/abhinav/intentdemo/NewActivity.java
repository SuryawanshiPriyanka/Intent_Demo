package com.example.abhinav.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtxt_fname,edtxt_mname,edtxt_lname;
    Button btn_senddata;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        edtxt_fname=(EditText)findViewById(R.id.edtxt_fname);
        edtxt_mname=(EditText)findViewById(R.id.edtxt_mname);
        edtxt_lname=(EditText)findViewById(R.id.edtxt_lname);
        btn_senddata=(Button) findViewById(R.id.btn_senddata);

        btn_senddata.setOnClickListener(this);
       /* Bundle bundle = getIntent().getBundleExtra("fullname");

        String name = (String)bundle.get("name");
        String lname = bundle.getString("lname");

        Toast.makeText(this, ""+name +" "+lname, Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public void onClick(View view)
    {
        Intent intent=new Intent(this,ViewActivity.class);
        intent.putExtra("name",edtxt_fname.getText().toString());
        intent.putExtra("mname",edtxt_mname.getText().toString());
        intent.putExtra("lname",edtxt_lname.getText().toString());
        startActivity(intent);
    }
}
