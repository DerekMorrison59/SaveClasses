package com.derekmorrison.saveclassess;

import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created by Derek on 1/17/2017.
 *
 * Comment contains the name of the commenter, the comment and the date/time the comment was created
 */

public class Comment {

    private String mComment;
    private String mUser;
    private long mTimeStamp;

    public Comment() {
        setTimeStamp();
    }

    public Comment(String comment, String user) {
        this.mComment = comment;
        this.mUser = user;
        setTimeStamp();
    }

    // use UTC to make it easier to work across timezones
    private void setTimeStamp() {
        GregorianCalendar g = new GregorianCalendar();
        g.setTimeZone(TimeZone.getTimeZone("UTC"));
        mTimeStamp =  g.getTimeInMillis();
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String mComment) {
        this.mComment = mComment;
    }

    public String getUser() {
        return mUser;
    }

    public void setUser(String mUser) {
        this.mUser = mUser;
    }

    public long getTimeStamp() {
        return mTimeStamp;
    }

    // consider removing this method so the timestamp reflects the creation of this class
    public void setTimeStamp(long mTimeStamp) {
        this.mTimeStamp = mTimeStamp;
    }

}
