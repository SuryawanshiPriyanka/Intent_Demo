package com.example.abhinav.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private static final int RESULT_PICK_CONTACT = 1;
    EditText edtxt_email, edtxt_contact,edtxt_compmail,edtxt_subject;
    Button btn_save;
    ImageView img_mail,img_call;
    String email,call;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtxt_email=(EditText)findViewById(R.id.edtxt_email);
        edtxt_contact=(EditText)findViewById(R.id.edtxt_contact);
        edtxt_compmail=(EditText)findViewById(R.id.edtxt_compmail);
        edtxt_subject=(EditText)findViewById(R.id.edtxt_subject);
        btn_save=(Button) findViewById(R.id.btn_save);
        img_call=(ImageView)findViewById(R.id.img_call);
        img_mail=(ImageView)findViewById(R.id.img_mail);
        img_mail.setOnClickListener(this);
        img_call.setOnClickListener(this);
        btn_save.setOnClickListener(this);
    }
    @Override
    public void onClick(View view)
    {
        if (view.getId()==R.id.btn_save)
        {

        }
      if(view.getId()==R.id.img_mail)
      {
          email=edtxt_email.getText().toString().trim();
          boolean result = isEmailAddressValid(email);
          if(result)
          {
              Intent sendIntent = new Intent();
              sendIntent.setAction(Intent.ACTION_SEND);
              sendIntent.putExtra(Intent.EXTRA_TEXT, edtxt_compmail.getText().toString());
              sendIntent.putExtra(Intent.EXTRA_SUBJECT,edtxt_subject.getText().toString());
              sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
              sendIntent.setType("text/plain");
              startActivity(sendIntent);
              Toast.makeText(this, "valid email address", Toast.LENGTH_SHORT).show();
          }
          else
          {
              Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
          }
      }
      if(view.getId()==R.id.img_call)
      {
          call=edtxt_contact.getText().toString().trim();
          selectContact();
      }
    }
    private void selectContact()
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        if (call.equals(""))
       {
           intent.setData(Uri.parse("tel:"+"0987654321"));
       }
       else
       {
           intent.setData(Uri.parse("tel:"+call));
       }
        startActivity(intent);
    }
    public static boolean isEmailAddressValid(String email)
    {
        boolean isEmailValid = false;

        String strExpression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern objPattern = Pattern.compile(strExpression, Pattern.CASE_INSENSITIVE);
        Matcher objMatcher = objPattern.matcher(inputStr);
        if (objMatcher.matches())
        {
            isEmailValid = true;
        }
        return isEmailValid;
    }
    

}
