package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by fanjie on 18-2-15.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest(){
        super(LonelyTwitterActivity.class);

    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding a normal tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }
    public void testthisTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding a normal tweet");
        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }


    public void testGetTweet(){
    TweetList tweets =new TweetList();
    Tweet tweet = new NormalTweet("adding a new tweet");
    tweets.add(tweet);
    Tweet returnedTweet = tweets.getTweet(0);
    assertEquals(returnedTweet.getDate(),  tweet.getDate());

    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("my tweet");

        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        assertEquals(tweets.getCount(), 0);
        Tweet tweet = new NormalTweet("my tweet");
        tweets.add(tweet);
        assertEquals(tweets.getCount(), 1);
    }

    public void testDeleteTweet()
    {
        TweetList tweets = new TweetList();
        Tweet tweet =  new NormalTweet("adding a new tweet");
        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }
}
}