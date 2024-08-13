package com.example.conferenceabstractbooklet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.ViewHolder> {

    Context context;
    ArrayList<SubjectModel> list;

    public ThemeAdapter(ThemeActivity context, ArrayList<SubjectModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_subject,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SubjectModel model = list.get(position);
        holder.subjectName.setText(model.getSubjectName());

        holder.itemView.setOnClickListener(v -> {
            if(position == 0){
                Intent intent = new Intent(context, AbstractsActivity.class);
                intent.putExtra("name",model.getSubjectName());
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
            else if(position == 1){
                Intent intent = new Intent(context, SubTheme2.class);
                intent.putExtra("name",model.getSubjectName());
                intent.putExtra("position",position);
                context.startActivity(intent);
            }else if(position == 2){
                Intent intent = new Intent(context, SubTheme3.class);
                intent.putExtra("name",model.getSubjectName());
                intent.putExtra("position",position);
                context.startActivity(intent);
            }else if(position == 3){
                Intent intent = new Intent(context, SubTheme4.class);
                intent.putExtra("name",model.getSubjectName());
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
            else if(position == 4){
                Intent intent = new Intent(context, SubTheme5.class);
                intent.putExtra("name",model.getSubjectName());
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
            else if(position == 5){
                Intent intent = new Intent(context, SubTheme6.class);
                intent.putExtra("name",model.getSubjectName());
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
            else if(position == 6){
                Intent intent = new Intent(context, SubTheme7.class);
                intent.putExtra("name",model.getSubjectName());
                intent.putExtra("position",position);
                context.startActivity(intent);
            }


        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subjectName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subjectName = itemView.findViewById(R.id.chapterName);
        }
    }
}
