package com.example.android.popularmovies.utilities;

import android.content.ContentValues;
import android.content.Context;

import com.example.android.popularmovies.data.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;

/**
 * Created by Lawrey on 24/1/17.
 */

public class MovieJSONUtils {

    /**
     * This method parses JSON from a web response and returns an array of Movies
     * Later on, we'll be parsing the JSON into structured data within the
     * getFullWeatherDataFromJson function, leveraging the data we have stored in the JSON. For
     * now, we just convert the JSON into human-readable strings.
     *
     * @param movieJsonStr JSON response from server
     *
     * @return Array of Strings describing weather data
     *
     * @throws JSONException If JSON data cannot be properly parsed
     */
    public static Movie[] getMoviesFromJSON(Context context, String movieJsonStr)
            throws JSONException {

        final String MDB_RESULTS = "results";

        final String MDB_POSTERPATH = "poster_path";

        final String MDB_OVERVIEW = "overview";

        final String MDB_TITLE = "original_title";

        final String MDB_VOTES = "vote_average";

        final String MDB_RELEASE_DATE = "release_date";

        final String MDB_ID = "id";

        final String MDB_STATUS_CODE = "status_code";

        /* Movies array to hold each movie object */
        Movie[] parsedMovieData = null;

        JSONObject movieJson = new JSONObject(movieJsonStr);

        /* Is there an error? */
        if (movieJson.has(MDB_STATUS_CODE)) {
            return null;
        }

        JSONArray moviesArray = movieJson.getJSONArray(MDB_RESULTS);

        parsedMovieData = new Movie[moviesArray.length()];

        for (int i = 0; i < moviesArray.length(); i++) {

            /* Get the JSON object for the movie */
            JSONObject movieObject = moviesArray.getJSONObject(i);

            String title = movieObject.getString(MDB_TITLE);
            String overview = movieObject.getString(MDB_OVERVIEW);
            double voteAverage = movieObject.getDouble(MDB_VOTES);
            String imagePath = movieObject.getString(MDB_POSTERPATH);
            String releaseDate = movieObject.getString(MDB_RELEASE_DATE);

            Movie newMovie = new Movie(title, overview, voteAverage, imagePath, releaseDate);

            parsedMovieData[i] = newMovie;
        }

        return parsedMovieData;
    }

}
