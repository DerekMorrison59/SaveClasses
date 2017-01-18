package com.derekmorrison.saveclassess;

/**
 * Created by Derek on 1/18/2017.
 *
 * This class contains the user name, the line number that the note is attached to and the
 * actual text of the annotation
 */

public class Annotation {

    private String mNote;
    private String mUser;
    private int mLineNumber;

    public Annotation(String mNote, String mUser, int mLineNumber) {
        this.mNote = mNote;
        this.mUser = mUser;
        this.mLineNumber = mLineNumber;
    }

    public String getComment() {
        return mNote;
    }

    public String getUser() {
        return mUser;
    }

    public int getLineNumber() {
        return mLineNumber;
    }
}
