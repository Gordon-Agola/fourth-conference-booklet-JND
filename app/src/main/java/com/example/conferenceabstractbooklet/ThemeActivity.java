package com.example.conferenceabstractbooklet;

import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ThemeActivity extends AppCompatActivity {
    TextView subTopic;
    ArrayList<SubjectModel> list;
    ThemeAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_theme);

        subTopic = findViewById(R.id.themeName);
        recyclerView = findViewById(R.id.themeRecycler);

        String chapter = getIntent().getStringExtra("name");
        subTopic.setText(chapter);


        list = new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        list.add(new SubjectModel("SUB-THEME ONE: CLIMATIC CHANGE AND FOOD SYSTEMS VALUE CHAIN - CCFSVC"));
        list.add(new SubjectModel("SUB-THEME TWO: GENERAL INTERVENTION IN ONE HEALTH - GIOH"));
        list.add(new SubjectModel("SUB-THEME THREE: Micro-Biota and Early -Stage Malnutrition - MBESM"));
        list.add(new SubjectModel("SUB-THEME FOUR: MICRONUTRIENT FOOD PROCESSING COMMERCIALIZATION AND HEALTH- MFPCH"));
        list.add(new SubjectModel("SUB-THEME FIVE: MULTI-SECTORIAL AND MULTI-DISCIPLINARY COLLABORATIONS - MSMDC."));
        list.add(new SubjectModel("SUB-THEME SIX: ONE HEALTH, FOOD SYSTEMS AND ANTHROPOLOGY (CULTURE, RELIGIOUS DOCTRINES) - OHFSA"));
        list.add(new SubjectModel("SUB-THEME SEVEN KEY: ZOONOTIC DISEASES, FOOD AND HUMAN HEALTH - ZDFHH.."));


        adapter = new ThemeAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }
}