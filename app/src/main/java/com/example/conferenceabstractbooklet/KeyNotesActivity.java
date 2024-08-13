package com.example.conferenceabstractbooklet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class KeyNotesActivity extends AppCompatActivity {
    TextView subTopic;
    ArrayList<SubjectModel> list;
    KeyNoteAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_notes);
        subTopic = findViewById(R.id.keyNotesName);
        recyclerView = findViewById(R.id.keyNotesRecycler);

        String chapter = getIntent().getStringExtra("name");
        subTopic.setText(chapter);


        list = new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        list.add(new SubjectModel("Dr. David Okeyo (MSc.,PhD, MSc. PH) : FOOD CHOICE DILEMMA: A REVIEW OF ANIMAL FOOD SOURCES RISKS, PLANT BASED DIET AND POLICY SOLUTION"));
        list.add(new SubjectModel("Prof. George Grant : PREVENTING AND POSSIBLY REVERSING DEMENTIA AND ALZHEIMER’S USING THERMOTHERAPY AND VIBROACOUSTIC THERAPY IN 12 SUBJECTS OVER THREE MONTHS."));
        list.add(new SubjectModel("Beatrice N. Kiage-Mokua,PhD. RND. : AGROECOLOGY’S ROLE IN MITIGATING CLIMATE IMPACT ON FOOD, NUTRITION,AND HEALTH"));
        list.add(new SubjectModel("Dr. George Ooko Abong’ B.SC., MSC., Ph.D (University of Nairobi),ITPDip. FS (Ghent University) : FOOD SAFETY AND NUTRITION NEXUS: IMPACT IN HUMAN HEALTH."));
        list.add(new SubjectModel("Prof. Nguka Gordon (RMD, PhD) : TRACING THE MISSING LINK IN IMPLEMENTATION OF ONE HEALTH APPROACH IN KENYA: THE BIG QUESTION IS ‘HAS KENYA IMPLEMENTED THE CONCEPT OF ONE HEALTH APPROACH WITHIN ITS HEALTH CARE SYSTEM‘"));
        list.add(new SubjectModel("Prof. Silvenus Konyole,PhD., RDN : MICRONUTRIENT STUDIES DYNAMICS IN SUB-SAHARA AFRICA: RESEARCH GAPS,CHALLENGES AND IMPLICATIONS FOR POLICY AND PROGRAMS"));


        adapter = new KeyNoteAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }
}