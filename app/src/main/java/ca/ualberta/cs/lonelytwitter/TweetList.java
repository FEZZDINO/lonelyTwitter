package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by fanjie on 18-2-15.
 */

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException("too much tweet!");
        }
        else{
            tweets.add(tweet);
        }
    }

    public ArrayList<Tweet> getTweet(){
        return tweets;
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public int getCount(){
        return tweets.size();
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

}
