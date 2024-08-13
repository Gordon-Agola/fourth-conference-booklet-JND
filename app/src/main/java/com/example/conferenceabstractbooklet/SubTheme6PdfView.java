package com.example.conferenceabstractbooklet;

import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


import com.github.barteksc.pdfviewer.PDFView;

public class SubTheme6PdfView extends AppCompatActivity {
    PDFView pdfView;
    TextView chapterName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sub_theme6_pdf_view);
        pdfView = findViewById(R.id.pdfViewWorkshop);
        chapterName = findViewById(R.id.abstractTopic);

        int position = getIntent().getIntExtra("position",0);
        String chapter = getIntent().getStringExtra("name");

        if(position==0){
            pdfView.fromAsset("sub6/1.pdf").load();
            chapterName.setText(chapter);
        }
        else if(position==1){
            pdfView.fromAsset("sub6/2.pdf").load();
            chapterName.setText(chapter);
        }

    }
}