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

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.category_phrases)));

        String colorStr = "#" + Integer.toHexString(ContextCompat.getColor(this,R.color.category_phrases_dark));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(colorStr));
        }


        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Where are you going?", "minto wuksus", "phrase_where_are_you_going"  ));
        words.add(new Word("What is your name?", "tinnә oyaase'nә","phrase_what_is_your_name"));
        words.add(new Word("My name is...", "oyaaset...","phrase_my_name_is"));
        words.add(new Word("How are you feeling?", "michәksәs?", "phrase_how_are_you_feeling"));
        words.add(new Word("I’m feeling good.", "kuchi achit","phrase_im_feeling_good"));
        words.add(new Word("Are you coming?", "әәnәs'aa?","phrase_are_you_coming"));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", "phrase_yes_im_coming"));
        words.add(new Word("I’m coming.", "әәnәm","phrase_im_coming"));
        words.add(new Word("Let’s go.", "yoowutis","phrase_lets_go"));
        words.add(new Word("Come here.", "әnni'nem","phrase_come_here"));


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
