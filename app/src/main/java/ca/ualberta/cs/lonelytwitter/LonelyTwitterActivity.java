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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
/**
 * acitivities of LonelyTwitter
 *
 * @author Fanjie SHen
 *
 * @version 1.0
 *
 */
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "tweet_list.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("LifeCycle ---->", "onCreate is called");
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);



		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();


				saveInFile();

			}
		});

        clearButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                tweetList.clear();

                adapter.notifyDataSetChanged();


                saveInFile();

            }
        });
	}

	@Override
	protected void onStart() {

		// TODO Auto-generated method stub
		super.onStart();
		Log.i("LifeCycle --->", "onStart is called");
		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this , R.layout.list_item, tweetList);


		oldTweetsList.setAdapter(adapter);


	}

	/**
	 * load from file
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();
			//taken from stakcoverflow//
			//2018-01-25//
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);



		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * save the text and date in the file
	 * @param text
	 * @param date
	 */
	private void saveInFile(String text, Date date) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();


		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("Lifecycle", "onDestroy is called");
	}
}