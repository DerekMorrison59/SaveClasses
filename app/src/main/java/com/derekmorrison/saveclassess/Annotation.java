package com.derekmorrison.saveclassess;

/**
 * Created by Derek on 1/18/2017.
 */

public class Annotation {

    private String mComment;
    private String mUser;
    private int mLineNumber;

    public Annotation(String mComment, String mUser, int mLineNumber) {
        this.mComment = mComment;
        this.mUser = mUser;
        this.mLineNumber = mLineNumber;
    }

    public String getComment() {
        return mComment;
    }

    public String getUser() {
        return mUser;
    }

    public int getLineNumber() {
        return mLineNumber;
    }
}
