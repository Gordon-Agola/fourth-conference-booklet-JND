package com.example.conferenceabstractbooklet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<SubjectModel> list;
    SubjectAdapter adapter;
    RecyclerView recyclerView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menu;
    View header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerSubject);
        menu = findViewById(R.id.menu);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navView);

        list = new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        list.add(new SubjectModel("COVER PAGE"));
        list.add(new SubjectModel("INTRODUCTION"));
        list.add(new SubjectModel("CONFERENCE PANEL DISCUSSIONS."));
        list.add(new SubjectModel("KEYNOTES ADDRESSES"));
        list.add(new SubjectModel("PRE-CONFERENCE WORKSHOPS"));
        list.add(new SubjectModel("CONFERENCE CHAIR AND RAPPORTEURS"));
        list.add(new SubjectModel("SUB THEMES"));
        list.add(new SubjectModel("CONFERENCE PROGRAM "));
        list.add(new SubjectModel("APPENDIX 1: CONFERENCE PARTNERS & ORGANISERS."));
        list.add(new SubjectModel("APPENDIX 2: CONFERENCE COMMITTEE MEMBERS"));




        adapter = new SubjectAdapter(this, list);
        recyclerView.setAdapter(adapter);

        header = navigationView.getHeaderView(0);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else{
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();


                if(id == R.id.home){

                    Toast.makeText(MainActivity.this,"home",Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if(id == R.id.share){
                    String shareBody = "Hey, I am using Conference abstract Booklet for third International Conference In Nutrion and Dietecians:\n"+"https://play.google.com/store/apps/details?id=com.kndi.conferenceabstractbooklet&pcampaignid=web_share";

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    startActivity(intent);
                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                else if(id == R.id.rate) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.kndi.conferenceabstractbooklet&pcampaignid=web_share")));
                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                return true;
            }
        });


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }
}