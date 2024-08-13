package com.example.conferenceabstractbooklet;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SubTheme7 extends AppCompatActivity {
    TextView subTopic;
    ArrayList<SubjectModel> list;
    SubTheme7Adapter adapter;
    RecyclerView recyclerView;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_theme7);
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

        list.add(new SubjectModel("Production Of Mushroom from Selected Bio-Waste\n"));
        list.add(new SubjectModel("Effects of particle size, soaking, sprouting and boiling on phosphorus-protein ratio values in serum phosphorus control among haemodialysis patients"));
        list.add(new SubjectModel("Antimicrobial Use and Sensitivity of Mastitis Pathogens Among Smallholder Dairy Cows in Peri-Urban Areas of Nakuru City, Kenya"));




        adapter = new SubTheme7Adapter(this, list);
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