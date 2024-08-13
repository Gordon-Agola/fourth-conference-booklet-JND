package com.example.conferenceabstractbooklet;

import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


import com.github.barteksc.pdfviewer.PDFView;

public class SubTheme2PdfView extends AppCompatActivity {
    PDFView pdfView;
    TextView chapterName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sub_theme2_pdf_view);
        pdfView = findViewById(R.id.pdfViewWorkshop);
        chapterName = findViewById(R.id.abstractTopic);

        int position = getIntent().getIntExtra("position",0);
        String chapter = getIntent().getStringExtra("name");

        if(position==0){
            pdfView.fromAsset("sub2/1.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==1){
            pdfView.fromAsset("sub2/2.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==2){
            pdfView.fromAsset("sub2/3.pdf").load();
            chapterName.setText(chapter);
        }else if(position==3){
            pdfView.fromAsset("sub2/4.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==4){
            pdfView.fromAsset("sub2/5.pdf").load();
            chapterName.setText(chapter);
        }
    }
}