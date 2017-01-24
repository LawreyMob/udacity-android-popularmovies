package com.example.android.popularmovies.utilities;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Lawrey on 23/1/17.
 */

public class NetworkUtils {

    /* Note this APIs are following Movie DB API v3 */

    private static final String TAG = NetworkUtils.class.getSimpleName();

    private static final String API_KEY = "ad4ffb49ab5d292de1cd561c5ff9fb71";

    private static final String MOVIEDB_URL = "https://api.themoviedb.org/3";

    final static String MOVIE_PARAM = "movie";
    final static String APIKEY_PARAM = "api_key";

    public static URL buildUrl(String movieType) {
        Uri builtUri = Uri.parse(MOVIEDB_URL).buildUpon()
                .appendPath(MOVIE_PARAM)
                .appendPath(movieType)
                .appendQueryParameter(APIKEY_PARAM, API_KEY)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.v(TAG, "Built URI " + url);

        return url;
    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

}
