package com.example.conferenceabstractbooklet;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SubTheme3 extends AppCompatActivity {
    TextView subTopic;
    ArrayList<SubjectModel> list;
    SubTheme3Adapter adapter;
    RecyclerView recyclerView;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_theme3);
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

        list.add(new SubjectModel("Knowledge, attitude, and practice of Nutrition Preconception among Women of reproductive age attending OPD at Kambuga Hospital, Uganda:"));
        list.add(new SubjectModel("The Role of Micro-Biota in Early Childhood Malnutrition and its long-term Health Consequences in Mathare, Nairobi – Kenya"));
        list.add(new SubjectModel("The TeAMS Toolkit: A co-designed tool to support team-based management of children with acute malnutrition at Migori County Referral Hospital"));
        list.add(new SubjectModel("Strengthening Integrated Management of Acute Malnutrition: Enhancing Capacity of Health Care Workforce and Systems on IMAM in Kwale County"));
        list.add(new SubjectModel("Addressing Early-Stage Malnutrition through the Baby-Friendly Hospital Initiative: A Case Study in Kinango Subcounty Hospital"));
        list.add(new SubjectModel("Twenty-four-hour movement behaviours in the early years in Tanzania: Sunrise pilot study\n" ));
        list.add(new SubjectModel("Dietary Intake in Children (6-48 Months) and Mothers (15-49 Years) in Different Farming Systems in Kenya Using Multipass 24-Hour Recall\n" ));
        list.add(new SubjectModel("Nutrition and the human gut microbiome: Gut health status among children with compromised water, sanitation and hygiene in Siaya County Kenya"));
        list.add(new SubjectModel("Determinants of Food access and Diet quality of Women of Reproductive age from fish farming households in Western Kenya"));
        list.add(new SubjectModel("Prevalence and determinants of stunting in children under the age of five, in Bisho, South Africa"));
        list.add(new SubjectModel("Socio-Demographic and Economic Characteristics, Dietary Intake, and Nutritional Status of Households with Children Aged 1-3 Years in Households in Seme Sub-County, Kenya"));





        adapter = new SubTheme3Adapter(this, list);
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