package com.example.conferenceabstractbooklet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfWorkshopActivity extends AppCompatActivity {
    PDFView pdfView;
    TextView chapterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_workshop);

        pdfView = findViewById(R.id.pdfViewWorkshop);
        chapterName = findViewById(R.id.topicWorkshop);

        int position = getIntent().getIntExtra("position",0);
        String chapter = getIntent().getStringExtra("name");

        if(position==0){
            pdfView.fromAsset("chair/1.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==1){
            pdfView.fromAsset("chair/2.pdf").load();
            chapterName.setText(chapter);
        }else if(position==2){
            pdfView.fromAsset("chair/3.pdf").load();
            chapterName.setText(chapter);
        }
    }
}