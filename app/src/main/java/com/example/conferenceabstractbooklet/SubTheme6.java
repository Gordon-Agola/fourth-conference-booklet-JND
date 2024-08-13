package com.example.conferenceabstractbooklet;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SubTheme6 extends AppCompatActivity {
    TextView subTopic;
    ArrayList<SubjectModel> list;
    SubTheme6Adapter adapter;
    RecyclerView recyclerView;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_theme6);
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

        list.add(new SubjectModel("Dietary patterns, physical activity and cardiovascular disease biomarkers among female workers of reproductive age at Moi Teaching & Referral Hospital"));
        list.add(new SubjectModel("Impact of Modern Diet on the Prevalence of Lifestyle Diseases in the Kikuyu Community of Othaya Sub County, Nyeri South District: A call for returning to Traditional Diets\n"));





        adapter = new SubTheme6Adapter(this, list);
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