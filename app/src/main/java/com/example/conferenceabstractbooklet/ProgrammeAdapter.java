package com.example.conferenceabstractbooklet;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProgrammeAdapter extends RecyclerView.Adapter<ProgrammeAdapter.ViewHolder> {

    Context context;
    ArrayList<SubjectModel> list;

    public ProgrammeAdapter(Context context, ArrayList<SubjectModel> list) {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubjectModel model = list.get(position);
        holder.subjectName.setText(model.getSubjectName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, PdfProgrammeActivity.class);
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
