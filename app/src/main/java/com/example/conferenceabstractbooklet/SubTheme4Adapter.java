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
import java.util.List;

public class SubTheme4Adapter extends RecyclerView.Adapter<SubTheme4Adapter.ViewHolder> {

    Context context;
    ArrayList<SubjectModel> list;
    public void setFilteredList(ArrayList<SubjectModel> filteredList){
        this.list = filteredList;

    }

    public SubTheme4Adapter(Context context, ArrayList<SubjectModel> list) {
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, SubTheme4PdfView.class);
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
