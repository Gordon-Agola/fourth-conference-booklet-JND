package com.example.conferenceabstractbooklet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ProgrammeActivity extends AppCompatActivity {

    TextView subTopic;
    ArrayList<SubjectModel> list;
    ProgrammeAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programme);

        subTopic = findViewById(R.id.programmeName);
        recyclerView = findViewById(R.id.programmeRecycler);

        String chapter = getIntent().getStringExtra("name");
        subTopic.setText(chapter);


        list = new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        list.add(new SubjectModel("PROGRAM FOR MONDAY THE 12TH OF AUGUST 2024"));
        list.add(new SubjectModel("PROGRAM FOR TUESDAY THE 13TH OF AUGUST 2024"));
        list.add(new SubjectModel("PROGRAM FOR WEDNESDAY THE 14TH OF AUGUST 2024"));
        list.add(new SubjectModel("PROGRAM FOR THURSDAY THE 15TH OF AUGUST 2024"));
        list.add(new SubjectModel("GENERAL PROGRAM"));


        adapter = new ProgrammeAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }
}