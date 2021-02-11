package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    int images[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
    R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j};
    String names[]={"Arjun Reddy","bahubali","Chatrapathi","Don","Ega","F2",
    "Gangaleder","Hello","I","Jalsa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        MyAdapter adapter=new MyAdapter(this,names,images);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}