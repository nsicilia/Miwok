package com.example.android.miwok;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word>{

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer(mMediaPlayer);
        }
    };

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
    public View getView(int position, View convertView, @NonNull final ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final Word word = getItem(position);

        //Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        final TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

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


        final ImageView miwokImageView = (ImageView) listItemView.findViewById(R.id.miwok_image_view);

        if (word.hasImage() == false){
            // Hide the ImageView(set visibility to GONE)
            miwokImageView.setVisibility(View.GONE);
        }else
            //Set the ImageView to the image resource specified in word
            miwokImageView.setImageResource(word.getmImageResourceId());



        //Makes each list item clickable and plays the items audio
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Release the media player if it currently exists because we are about to play
                //a new audio file
                releaseMediaPlayer(mMediaPlayer);

               //Gets the audio name from the word object
               String temp = word.getmAudioResourceName();

               //Creates a resource object
                Resources res = getContext().getResources();

                //Takes name of the file and gets its int id
                int soundId = res.getIdentifier(temp,"raw", getContext().getPackageName());

                //playes the audio file using soundId
                mMediaPlayer = MediaPlayer.create(getContext(),soundId);
                //plays audio
                mMediaPlayer.start();

                //Setup a listener on the media player so we can stop and
                //release the media player once the sound has finished playing
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });



        // Return the whole list item layout (containing 2 TextViews and ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer(MediaPlayer mMediaPlayer) {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }


}
