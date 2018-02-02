/*Tweet
 * version 1.0
 *
 * Feb/2/2018
 *
 *
 * Copyright  © 2018 Team 24. CMPUT 301. University of alberta - All Rights Reserved.
 * You may use, distribute or modify this code under terms and conditions of Code of Student Behaviour at
 * University of Alberta.
 * You can find a copy of the lisence in this project. Otherwise, please contact fanjie@ualberta,ca
 */



package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a tweet
 *
 * @author Fanjie SHen
 *
 * @version 1.0
 *
 */
public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;

    /**
     * Consructs a tweet instance using the given message
     *
     * @param message the message of the tweet
     */
    Tweet(String message){

        this.message = message;
        date = new Date();
//        message = message;
    }

    /**
     * Constructs a tweet instance with date
     * @param message
     * @param date
     */
    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    public String getMessage(){
        return message;
    }

    /**
     * Sets the message of the tweet
     *
     * @param message - the new message of the tweet
     * @throws TweetTooLongException - is thrown when the message is over 140 characters
     * @see ImportantTweet
     * @see NormalTweet
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() < 140){
            this.message = message;
        }
        else{
            throw new TweetTooLongException();
        }
    }

    /**
     * get the current date
     * @return current date
     */
    public Date getDate(){
        return date;
    }

    /**
     * set the date
     * @param date - the new date user set
     */
    public void setDate(Date date){
        this.date = date;
    }

    public abstract Boolean isImportant();

    public String  toString(){
        return date.toString() + " | " + message;
    }
}
