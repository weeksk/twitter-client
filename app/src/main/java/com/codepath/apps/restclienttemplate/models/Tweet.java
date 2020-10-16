package com.codepath.apps.restclienttemplate.models;

//import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Tweet {

    public User user;
    public String body;
    public long id;
    public static String createdAt;

    // empty constructor needed by the Parceler Library
    public Tweet() {}

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        tweet.body = jsonObject.getString("text");
        tweet.id = jsonObject.getLong("id");
        tweet.createdAt = jsonObject.getString("created_at");
        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }

//    public static String getFormattedTimestamp() {
//        return TimeFormatter.getTimeDifference(createdAt);
//    }
}