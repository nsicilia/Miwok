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

    private int NO_IMAGE = -1;

    //Resource Id for the relate image
    private int mImageResourceId = NO_IMAGE;

    //Resouce name of the related audio
    private String mAudioResourceName;



    /**
     * Creates a new Word object.
     * @param DefaultTranslation is the word in a language the user's phone is set to
     * @param MiwokTranslation is the word in Miwok
     */
    public Word (String DefaultTranslation, String MiwokTranslation){

        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;

    }

    /**
     * Creates a new Word object.
     * @param DefaultTranslation is the word in a language the user's phone is set to
     * @param MiwokTranslation is the word in Miwok
     * @param AudioResourceName takes the name of the individual audio files
     */
    public Word ( String DefaultTranslation, String MiwokTranslation,String AudioResourceName){

        mAudioResourceName = AudioResourceName;
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;

    }

    /**
     * Creates a new Word object.
     * @param DefaultTranslation is the word in a language the user's phone is set to
     * @param MiwokTranslation is the word in Miwok
     * @param ImageResource is the drawable image resource id of the related image
     * @param AudioResourceName takes the name of the individual audio files
     */
    public Word ( String DefaultTranslation, String MiwokTranslation,int ImageResource, String AudioResourceName){

        mImageResourceId = ImageResource;
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mAudioResourceName = AudioResourceName;

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


    /**
     * Get the image related to the words.
     * @return Integer miwok image resource id
     */
    public int getmImageResourceId() { return mImageResourceId; }


    /**
     * Boolean method to determine mImageResourceId contents
     * @return true if mImageResourceId has a value
     */
    public boolean hasImage(){
        return mImageResourceId != -1;
    }


    /**
     * Get the image related to the words.
     * @return Integer miwok image resource id
     */
    public String getmAudioResourceName() { return mAudioResourceName; }
}


