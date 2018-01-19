package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
/**
 * Created by fanjie on 18-1-18.
 */

public abstract class Mood{
    private Date date;

    public Mood(Date date){
        this.date = date;
    }

    public Date getDate(){
        return date;

    }
    public void setDate(Date date){
        this.date = date;
    }


}