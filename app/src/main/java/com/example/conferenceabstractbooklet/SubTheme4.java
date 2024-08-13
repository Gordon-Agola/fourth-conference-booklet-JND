package com.example.conferenceabstractbooklet;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SubTheme4 extends AppCompatActivity {
    TextView subTopic;
    ArrayList<SubjectModel> list;
    SubTheme4Adapter adapter;
    RecyclerView recyclerView;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_theme4);
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

        list.add(new SubjectModel("Yacon Based Snacks: A Source of Fructooligosaccharides, Phenolic Compounds, Antioxidant Activity and Low Glycemic Index.\n"));
        list.add(new SubjectModel("Potential Of Edible Seaweed of The Kenyan Coast as A Micronutrient Source\n"));
        list.add(new SubjectModel("Optimal Nutrition during Pregnancy: Food Intake Versus Supplementation\n"));
        list.add(new SubjectModel("Characterization of the Nutritional Properties of Sorghum Composite Flours Using Different Food to Food Fortification Approaches"));
        list.add(new SubjectModel("Adherence To Iron Deficiency Interventions Among Pregnant Women Attending Antenatal Clinics in Ubungo Municipality, Dar Es Salaam, Tanzania."));
        list.add(new SubjectModel("Nutrition Knowledge and Dietary Intake of Vitamin A And Iron Among Lactating Teenagers in Kisumu County\n"));
        list.add(new SubjectModel("Addressing Micronutrient Deficiencies to Reduce Cancer Risk in Kenya: Challenges and Strategies for Prevention\n"));
        list.add(new SubjectModel("Utilization of Bean leaves as a cheap source of Vitamin A, Iron and Zinc"));
        list.add(new SubjectModel("Nutritive Value of The Pineapple Peels Compared to The Flesh and Its Incorporation to Human Diet and Nutrition."));





        adapter = new SubTheme4Adapter(this, list);
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