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

public class NumbersActivity extends AppCompatActivity {

    private static final String TAG = "ham";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.category_numbers)));

        String colorStr = "#" + Integer.toHexString(ContextCompat.getColor(this,R.color.category_numbers_dark));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(colorStr));
        }


        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("One", "lutti"));
        words.add(new Word("Two", "otiiko"));
        words.add(new Word("Three", "tolookosu"));
        words.add(new Word("Four", "oyyisa"));
        words.add(new Word("Five", "massokka"));
        words.add(new Word("Six", "temmokka"));
        words.add(new Word("Seven", "kenekaku"));
        words.add(new Word("Eight", "kawinta"));
        words.add(new Word("Nine", "wo’e"));
        words.add(new Word("Ten", "na’aacha"));




        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);


    }

    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }


}
