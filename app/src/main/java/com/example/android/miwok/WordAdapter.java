package com.example.android.miwok;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word>{

    WordAdapter(@NonNull Context context, ArrayList<Word> words) {
        super(context,0, words);
    }
    /**
     * Provides a view from and AdapterView(ListView,GridView, etc)
     *
     * @param position The AdapterView position that is requesting a view
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdopterView.
     */

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word word = getItem(position);

        //Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        miwokTextView.setTypeface(null,Typeface.BOLD);
        //Get the Miwok translation from the currentWord object and set this
        // text on the Miwok TextVew
        assert word != null;
        miwokTextView.setText(word.getmMiwokTranslation());


        //Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        //Get the default translation from the currentWord object and set
        // this text on the default TextVew
        defaultTextView.setText(word.getmDefaultTranslation());


        ImageView miwokImageView = (ImageView) listItemView.findViewById(R.id.miwok_image_view);

        if (word.hasImage() == false){
            // Hide the ImageView(set visibility to GONE)
            miwokImageView.setVisibility(View.GONE);
        }else
            //Set the ImageView to the image resource specified in word
            miwokImageView.setImageResource(word.getmImageResourceId());


        // Return the whole list item layout (containing 2 TextViews and ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
