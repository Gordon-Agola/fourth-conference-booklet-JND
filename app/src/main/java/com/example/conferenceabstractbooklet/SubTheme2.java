package com.example.conferenceabstractbooklet;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SubTheme2 extends AppCompatActivity {
    TextView subTopic;
    ArrayList<SubjectModel> list;
    SubTheme2Adapter adapter;
    RecyclerView recyclerView;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_theme2);
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

        list.add(new SubjectModel("Nutritional Knowledge and Nutritional Status of Diabetes Type 2 Patients in Kikuyu Mission Hospital, Nairobi, Kenya"));
        list.add(new SubjectModel("Malnutrition Risk of Cancer Outpatients Using Malnutrition Universal Screening Tool in Nyeri County Referral Hospital Kenya"));
        list.add(new SubjectModel("Adherence To Dietary Recommendations in The Management of Type 2 Diabetic Patients Attending Diabetic Clinic at Nyahururu County Referral Hospital, Kenya"));
        list.add(new SubjectModel("Long-term Home Enteral Nutrition: Feeding Tube-related Complications and Problems in old age Patients"));
        list.add(new SubjectModel("Enhancing Preparedness and Response to Disease Outbreaks through implementing a one health approach in Isiolo county, Kenya"));







        adapter = new SubTheme2Adapter(this, list);
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