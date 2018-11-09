package com.example.android.miwok;

import android.content.Context;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */

public class Word {


    // Default translation for the word
    private String mDefaultTranslation;

    //Miwok translation for the work
    private String mMiwokTranslation;





    /**
     * Constructs a new TextView with initial values for text and text color.
     */
    public Word (String DefaultTranslation, String MiwokTranslation){

        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;

    }

    /**
     * Get the default translation of the word.
     * @return String default word
     */

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }


    /**
     * Get the miwok translation of the word.
     * @return String miwok word
     */
    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }
}
