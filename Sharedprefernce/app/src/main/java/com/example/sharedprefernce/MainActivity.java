package com.example.sharedprefernce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText uname,upass;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=findViewById(R.id.uname);
        upass=findViewById(R.id.upass);
        preferences=getSharedPreferences("Data",MODE_PRIVATE);
        String n=preferences.getString("name",null);
        String p=preferences.getString("pass",null);
        if(n!=null|p!=null){
            startActivity(new Intent(this,MainActivity2.class));
        }
    }

    public void login(View view) {
        String name=uname.getText().toString();
        String pass=upass.getText().toString();
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("name",name);
        editor.putString("pass",pass);
        editor.commit();
        Intent i= new Intent(this,MainActivity2.class);
        i.putExtra("key",name);
        startActivity(i);


    }
}