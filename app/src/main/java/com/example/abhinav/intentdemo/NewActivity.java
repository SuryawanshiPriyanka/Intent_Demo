package com.example.abhinav.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity implements View.OnClickListener
{
  //  EditText edtxt_fname,edtxt_mname,edtxt_lname;
    //Button btn_senddata;
   // ImageView img_plus;
    private static final int ADD=100;
    TextView txt_name,txt_age,txt_mobileno;
    ImageView img_add;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
/*
        edtxt_fname=(EditText)findViewById(R.id.edtxt_fname);
        edtxt_mname=(EditText)findViewById(R.id.edtxt_mname);
        edtxt_lname=(EditText)findViewById(R.id.edtxt_lname);
        btn_senddata=(Button) findViewById(R.id.btn_senddata);
        img_plus=(ImageView)findViewById(R.id.img_plus);

        btn_senddata.setOnClickListener(this);
        img_plus.setOnClickListener(this);*/

        txt_name=(TextView)findViewById(R.id.txt_name);
        txt_age=(TextView)findViewById(R.id.txt_age);
        txt_mobileno=(TextView)findViewById(R.id.txt_mobileno);
        img_add=(ImageView)findViewById(R.id.img_add);
        img_add.setOnClickListener(this);


    }

    @Override
    public void onClick(View view)
    {
        if(view.getId()==R.id.img_add)
        {
            Intent intent=new Intent(this,ViewActivity.class);
            startActivityForResult(intent, ADD);
        }
        /*if (view.getId()==R.id.img_plus)
        {
            Intent intent =new Intent(this,ViewActivity.class);
            startActivity(intent);
        }*/
        /*Intent intent=new Intent(this,ViewActivity.class);
        intent.putExtra("name",edtxt_fname.getText().toString());
        intent.putExtra("mname",edtxt_mname.getText().toString());
        intent.putExtra("lname",edtxt_lname.getText().toString());
        startActivity(intent);*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==ADD && resultCode==RESULT_OK)
        {

            String name = data.getStringExtra("name");
            String age = data.getStringExtra("age");
            String mobileno = data.getStringExtra("mobileno");
            txt_name.setText(name);
            txt_age.setText(age);
            txt_mobileno.setText(mobileno);
        }
    }
}



