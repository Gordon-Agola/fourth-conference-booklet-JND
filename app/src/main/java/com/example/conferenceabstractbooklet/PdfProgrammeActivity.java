package com.example.conferenceabstractbooklet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfProgrammeActivity extends AppCompatActivity {

    PDFView pdfView;
    TextView chapterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_programme);

        pdfView = findViewById(R.id.pdfViewProgrammePdf);
        chapterName = findViewById(R.id.topicProgrammePdf);

        int position = getIntent().getIntExtra("position",0);
        String chapter = getIntent().getStringExtra("name");

        if(position==0){
            pdfView.fromAsset("program/1.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==1){
            pdfView.fromAsset("program/2.pdf").load();
            chapterName.setText(chapter);
        }else if(position==2){
            pdfView.fromAsset("program/3.pdf").load();
            chapterName.setText(chapter);
        }else if(position==3){
            pdfView.fromAsset("program/4.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==4){
            pdfView.fromAsset("program/general.pdf").load();
            chapterName.setText(chapter);
        }

    }
}