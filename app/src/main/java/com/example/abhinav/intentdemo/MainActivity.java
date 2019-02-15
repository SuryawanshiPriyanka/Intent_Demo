package com.example.abhinav.intentdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private static final int RESULT_LOAD_IMAGE=100;
    private static final int TAKE_PICTURE=101;
    private static final int RESULT_PICK_CONTACT = 1;

    EditText edtxt_email, edtxt_contact,edtxt_compmail,edtxt_subject;
            TextView txt_pickimg;
    Button btn_save;
    ImageView img_mail,img_call,img_gallary,img_camera,img_image;
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
        txt_pickimg=(TextView)findViewById(R.id.txt_pickimg);
        btn_save=(Button) findViewById(R.id.btn_save);

        img_call=(ImageView)findViewById(R.id.img_call);
        img_mail=(ImageView)findViewById(R.id.img_mail);
        img_gallary=(ImageView)findViewById(R.id.img_gallary);
        img_camera=(ImageView)findViewById(R.id.img_camera);
        img_image=(ImageView)findViewById(R.id.img_image);

        img_mail.setOnClickListener(this);
        img_call.setOnClickListener(this);
        img_gallary.setOnClickListener(this);
        img_camera.setOnClickListener(this);
        btn_save.setOnClickListener(this);


    }
    @Override
    public void onClick(View view)
    {
        if(view.getId()==R.id.btn_save)
        {
            Intent intent=new Intent(MainActivity.this,NewActivity.class);
            startActivity(intent);
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

      if (view.getId()==R.id.img_gallary)
      {

          Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
          startActivityForResult(i, RESULT_LOAD_IMAGE);

      }
      if(view.getId()==R.id.img_camera)
      {
          Intent intents = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
          startActivityForResult(intents, TAKE_PICTURE);
      }
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK)
        {

            switch(requestCode)
            {
                case RESULT_LOAD_IMAGE:
                    try
                    {
                        Uri selectedImage=data.getData();
                        Bitmap selected_img_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                        img_image.setImageBitmap(selected_img_bitmap);

                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case TAKE_PICTURE :

                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");

                    img_image.setImageBitmap(imageBitmap);
                    break;
            }

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
