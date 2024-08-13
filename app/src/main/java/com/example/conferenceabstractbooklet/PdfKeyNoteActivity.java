package com.example.conferenceabstractbooklet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfKeyNoteActivity extends AppCompatActivity {

    PDFView pdfView;
    TextView chapterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_key_note);

        pdfView = findViewById(R.id.pdfViewNote);
        chapterName = findViewById(R.id.topicNote);

        int position = getIntent().getIntExtra("position",0);
        String chapter = getIntent().getStringExtra("name");

        if(position==0){
            pdfView.fromAsset("keynotes/1.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==1){
            pdfView.fromAsset("keynotes/2.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==2){
            pdfView.fromAsset("keynotes/3.pdf").load();
            chapterName.setText(chapter);
        }else if(position==3){
            pdfView.fromAsset("keynotes/4.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==4){
            pdfView.fromAsset("keynotes/5.pdf").load();
            chapterName.setText(chapter);
        }else if(position==5){
            pdfView.fromAsset("keynotes/6.pdf").load();
            chapterName.setText(chapter);
        }
    }
}