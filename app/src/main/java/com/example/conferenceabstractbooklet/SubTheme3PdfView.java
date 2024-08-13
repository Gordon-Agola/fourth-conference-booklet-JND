package com.example.conferenceabstractbooklet;

import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


import com.github.barteksc.pdfviewer.PDFView;

public class SubTheme3PdfView extends AppCompatActivity {
    PDFView pdfView;
    TextView chapterName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sub_theme3_pdf_view);
        pdfView = findViewById(R.id.pdfViewWorkshop);
        chapterName = findViewById(R.id.abstractTopic);

        int position = getIntent().getIntExtra("position",0);
        String chapter = getIntent().getStringExtra("name");

        if(position==0){
            pdfView.fromAsset("sub3/1.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==1){
            pdfView.fromAsset("sub3/2.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==2){
            pdfView.fromAsset("sub3/3.pdf").load();
            chapterName.setText(chapter);
        }else if(position==3){
            pdfView.fromAsset("sub3/4.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==4){
            pdfView.fromAsset("sub3/5.pdf").load();
            chapterName.setText(chapter);
        }else if(position==5){
            pdfView.fromAsset("sub3/6.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==6){
            pdfView.fromAsset("sub3/7.pdf").load();
            chapterName.setText(chapter);
        }else if(position==7){
            pdfView.fromAsset("sub3/8.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==8){
            pdfView.fromAsset("sub3/9.pdf").load();
            chapterName.setText(chapter);
        }else if(position==9){
            pdfView.fromAsset("sub3/10.pdf").load();
            chapterName.setText(chapter);
        }else if(position==10){
            pdfView.fromAsset("sub3/11.pdf").load();
            chapterName.setText(chapter);
        }
    }
}