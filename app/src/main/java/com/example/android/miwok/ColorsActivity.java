package com.example.android.miwok;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.category_colors)));

        String colorStr = "#" + Integer.toHexString(ContextCompat.getColor(this,R.color.category_colors_dark));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(colorStr));
        }



        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Red", "weṭeṭṭi"));
        words.add(new Word("Mustard Yellow", "chiwiiṭә"));
        words.add(new Word("Dusty Yellow", "ṭopiisә"));
        words.add(new Word("Green", "chokokki"));
        words.add(new Word("Brown", "ṭakaakki"));
        words.add(new Word("Gray", "ṭopoppi"));
        words.add(new Word("Black", "kululli"));
        words.add(new Word("White", "kelelli"));



        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home)
            this.finish();

        return super.onOptionsItemSelected(item);
    }
}
