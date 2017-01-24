package com.example.android.popularmovies.data;

import java.io.Serializable;

/**
 * Created by Lawrey on 23/1/17.
 */

public class Movie implements Serializable {

    private final String mTitle;
    private final String mOverview;
    private final double mVoteAverage;
    private final String mImagePath;
    private final String mReleaseDate;

    private static final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w185";

    public Movie(String mTitle, String mOverview, double mVoteAverage, String mImagePath, String mReleaseDate) {
        this.mTitle = mTitle;
        this.mOverview = mOverview;
        this.mVoteAverage = mVoteAverage;
        this.mImagePath = mImagePath;
        this.mReleaseDate = mReleaseDate;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmOverview() {
        return mOverview;
    }

    public double getmVoteAverage() {
        return mVoteAverage;
    }

    public String getmImagePath() {
        return mImagePath;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }

    public String getImageURL() {
        return BASE_IMAGE_URL + this.mImagePath;
    }
}
