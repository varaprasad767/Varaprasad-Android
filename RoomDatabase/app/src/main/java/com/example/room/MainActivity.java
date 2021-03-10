package com.example.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    List<Student> studentList;
    RecyclerView recyclerView;

    Student student;
    static StudentDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.id);
        et2=findViewById(R.id.name);
        recyclerView=findViewById(R.id.rec);

        //nomal data

        database= Room.databaseBuilder(this,StudentDatabase.class,"mydb")
                .allowMainThreadQueries().build();

    }

    public void save(View view) {

        String i=et1.getText().toString();
        String n=et2.getText().toString();
        student=new Student();
        student.setId(i);
        student.setName(n);

        database.studentDao().insert(student);
        Toast.makeText(this, "Data sucessfully inserted ", Toast.LENGTH_SHORT).show();
    }

    public void retrivedata(View view) {
        studentList=database.studentDao().readdata();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(this,studentList));
    }
}