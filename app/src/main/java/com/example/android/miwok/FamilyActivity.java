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

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.category_family)));

        String colorStr = "#" + Integer.toHexString(ContextCompat.getColor(this,R.color.category_family_dark));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(colorStr));
        }



        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("father", "әpә", R.drawable.family_father,"family_father"));
        words.add(new Word("mother", "әṭa", R.drawable.family_mother,"family_mother"));
        words.add(new Word("son", "angsi", R.drawable.family_son,"family_son"));
        words.add(new Word("daughter", "tune", R.drawable.family_daughter, "family_daughter"));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother, "family_older_brother"));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother,"family_younger_brother"));
        words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister,"family_older_sister"));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister,"family_younger_sister"));
        words.add(new Word("grandmother ", "ama", R.drawable.family_grandmother,"family_grandmother"));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, "family_grandfather"));



        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
