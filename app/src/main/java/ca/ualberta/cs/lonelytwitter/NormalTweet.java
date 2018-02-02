/*
 * Copyright  © 2018 Team 24. CMPUT 301. University of alberta - All Rights Reserved.
 * You may use, distribute or modify this code under terms and conditions of Code of Student Behaviour at
 * University of Alberta.
 * You can find a copy of the lisence in this project. Otherwise, please contact fanjie@ualberta.ca
 *
 */

package ca.ualberta.cs.lonelytwitter;

/**
 * Created by dezfuli on 1/16/18.
 */
import java.util.Date;

/**
 * Normal tweets
 */
public class NormalTweet extends Tweet {
    NormalTweet(String message){
        super(message);
    }

    NormalTweet(String message, Date date){
        super(message, date);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
