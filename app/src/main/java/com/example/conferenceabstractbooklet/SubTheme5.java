package com.example.conferenceabstractbooklet;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SubTheme5 extends AppCompatActivity {
    TextView subTopic;
    ArrayList<SubjectModel> list;
    SubTheme5Adapter adapter;
    RecyclerView recyclerView;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_theme5);
        searchView = findViewById(R.id.searchViewAbstract);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterlist(newText);
                return true;
            }
        });

        subTopic = findViewById(R.id.abstractName);
        recyclerView = findViewById(R.id.abstractRecycler);

        String chapter = getIntent().getStringExtra("name");
        subTopic.setText(chapter);


        list = new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        list.add(new SubjectModel("Enhancing Multisectoral Efforts to Combat Malnutrition in Kenya; A One Health Approach"));
        list.add(new SubjectModel("Striving Towards One Health: Collaborative Strategies for Optimizing Nutrition Status of Children"));
        list.add(new SubjectModel("Reporting and Methodological Quality of Clinical Practice Guidelines for Management of Malnutrition in the East African Community. A Systematic Review"));
        list.add(new SubjectModel("Malnutrition related deaths in Infants and children enrolled in Child Health and Mortality Prevention Surveillance (CHAMPS) Kenyan site, May 2017 -December 2022"));
        list.add(new SubjectModel("Effective Strategies for Workshops on Communicable and Non-Communicable Diseases: A Case Study of Rift Valley Technical Training Institute"
                ));
        list.add(new SubjectModel("Treatment of Moderate Acute Malnutrition through Community Health Volunteers is a cost-effective Intervention: Evidence from a Resource-Limited Setting"));
        list.add(new SubjectModel("Effectiveness of Task Shifting in the Management of Malnourished Children in Northern Kenya: A Cluster-Randomized Controlled Trial"));
        list.add(new SubjectModel("Perceptions towards management of acute malnutrition by community health volunteers in northern Kenya."));








        adapter = new SubTheme5Adapter(this, list);
        recyclerView.setAdapter(adapter);
    }

    private void filterlist(String text) {
        ArrayList <SubjectModel> filtereList = new ArrayList<>();
        for(SubjectModel subjectModel:list){
            if(subjectModel.getSubjectName().toLowerCase().contains(text.toLowerCase())){
                filtereList.add(subjectModel);
            }
        }
        if(filtereList.isEmpty()){
            Toast.makeText(this, "No Data Found",Toast.LENGTH_SHORT).show();
        }else{
            adapter.setFilteredList(filtereList);
        }
    }
}