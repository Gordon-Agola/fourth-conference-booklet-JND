package com.example.conferenceabstractbooklet;

import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


import com.github.barteksc.pdfviewer.PDFView;

public class SubTheme4PdfView extends AppCompatActivity {
    PDFView pdfView;
    TextView chapterName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sub_theme4_pdf_view);
        pdfView = findViewById(R.id.pdfViewWorkshop);
        chapterName = findViewById(R.id.abstractTopic);

        int position = getIntent().getIntExtra("position",0);
        String chapter = getIntent().getStringExtra("name");

        if(position==0){
            pdfView.fromAsset("sub4/1.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==1){
            pdfView.fromAsset("sub4/2.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==2){
            pdfView.fromAsset("sub4/3.pdf").load();
            chapterName.setText(chapter);
        }else if(position==3){
            pdfView.fromAsset("sub4/4.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==4){
            pdfView.fromAsset("sub4/5.pdf").load();
            chapterName.setText(chapter);
        }else if(position==5){
            pdfView.fromAsset("sub4/6.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==6){
            pdfView.fromAsset("sub4/7.pdf").load();
            chapterName.setText(chapter);
        }else if(position==7){
            pdfView.fromAsset("sub4/8.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==8){
            pdfView.fromAsset("sub4/9.pdf").load();
            chapterName.setText(chapter);
        }
    }
}