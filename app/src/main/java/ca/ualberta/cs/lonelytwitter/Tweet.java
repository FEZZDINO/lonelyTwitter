package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

import ca.ualberta.cs.lonelytwitter.TweetTooLongException;

public abstract class Tweet implements Tweetable{

        private String message;
        private Date date;

        public date(String message) {
            this.message = message;
        }
        public Tweet(String message, Date date){
            this.message = message;
            this.date = date;
        }
        public Date getDate(){
            return date;

        }
        public void setDate(Date date){
            this.date = date;
        }

        public String getMessage(){
            return this.message;
        }

        public void setMessage(String message) throws TweetTooLongException {
            if (message.length() > 140) {
                throw new TweetTooLongException();

            }else{
                this.message = message;

            }
        }

        public  abstract Boolean isImportant();
}