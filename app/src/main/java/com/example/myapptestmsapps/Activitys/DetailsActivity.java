package com.example.myapptestmsapps.Activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapptestmsapps.Models.NewsHeadlines;
import com.example.myapptestmsapps.R;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    NewsHeadlines headlines;
    TextView txt_title,txt_author,txt_time, txt_detail, txt_content;
    ImageView img_news;
    CheckBox checkBoxHeart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txt_title = findViewById(R.id.text_detail_title);
        txt_author = findViewById(R.id.text_detail_author);
        txt_time = findViewById(R.id.text_detail_time);
        txt_detail = findViewById(R.id.text_detail_detail);
        txt_content = findViewById(R.id.text_detail_content);
        img_news = findViewById(R.id.img_detail_news);

        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        txt_title.setText(headlines.getTitle());
        txt_author.setText(headlines.getAuthor());
        txt_time.setText(headlines.getPublishedAt());
        txt_detail.setText(headlines.getDescription());
        txt_content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);


        CheckBox checkBoxHeart = (CheckBox) findViewById(R.id.cbHeart);
        checkBoxHeart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (((CheckBox)v).isChecked()) {
            Toast.makeText(getApplicationContext(), "Added in Favorites", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(getApplicationContext(), "Removed from Favorites", Toast.LENGTH_SHORT).show();
        }
    }
}