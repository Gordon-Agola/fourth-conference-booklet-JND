package com.example.conferenceabstractbooklet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class WorkshopActivity extends AppCompatActivity {

    TextView subTopic;
    ArrayList<SubjectModel> list;
    WorkshopsAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        subTopic = findViewById(R.id.workshopName);
        recyclerView = findViewById(R.id.workshopRecycler);

        String chapter = getIntent().getStringExtra("name");
        subTopic.setText(chapter);


        list = new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        list.add(new SubjectModel("Day 1: 13th August 2024"));
        list.add(new SubjectModel("Day 2: 14th August 2024"));
        list.add(new SubjectModel("Day 3: 15th August 2024"));


        adapter = new WorkshopsAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }
}