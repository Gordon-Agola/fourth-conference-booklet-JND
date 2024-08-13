package com.example.conferenceabstractbooklet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfViewActivity extends AppCompatActivity {
    PDFView pdfView;
    TextView chapterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);
        pdfView = findViewById(R.id.pdfView);
        chapterName = findViewById(R.id.topicName);

        int position = getIntent().getIntExtra("position",0);
        String chapter = getIntent().getStringExtra("name");

        if(position==0){
            pdfView.fromAsset("cover.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==1){
            pdfView.fromAsset("intro.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==2){
            pdfView.fromAsset("panel.pdf").load();
            chapterName.setText(chapter);
        }else if(position==4){
            pdfView.fromAsset("workshop.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==8){
            pdfView.fromAsset("append1.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==9){
            pdfView.fromAsset("append2.pdf").load();
            chapterName.setText(chapter);
        }

    }
}