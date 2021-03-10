package com.example.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert
    public  void insert(Student student);
    @Update
    public  void update(Student student);
    @Delete
    public  void delete(Student student);

    @Query("select * from student_table")
    public List<Student> readdata();


}
