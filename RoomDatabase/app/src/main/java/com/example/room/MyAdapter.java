package com.example.room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context context;
    List<Student>list;
    public MyAdapter(MainActivity mainActivity, List<Student> studentList) {
        context=mainActivity;
        list=studentList;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.row_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.i.setText(list.get(position).getId());
        holder.n.setText(list.get(position).getName());
        holder.d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.database.studentDao().delete(list.get(position));

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView i,n;

        Button d;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            i=itemView.findViewById(R.id.res_id);
            n=itemView.findViewById(R.id.res_name);
            d=itemView.findViewById(R.id.delete);
        }
    }
}
