package com.example.android.popularmovies;

import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.popularmovies.data.Movie;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Movie selectedMovie = (Movie) getIntent().getSerializableExtra("Movie");

        this.setTitle(selectedMovie.getmTitle());

        ImageView movieArtImageView = (ImageView) findViewById(R.id.imageview_movie_art);
        TextView movieTitleTextView = (TextView) findViewById(R.id.textview_movie_detail_title);
        TextView movieReleaseDateTextView = (TextView) findViewById(R.id.textview_movie_detail_release_date);
        TextView movieVotesTextView = (TextView) findViewById(R.id.textview_movie_detail_vote);
        TextView movieOverviewTextView = (TextView) findViewById(R.id.textview_movie_detail_overview);

        Picasso.with(this).load(selectedMovie.getImageURL()).into(movieArtImageView);
        movieTitleTextView.setText(selectedMovie.getmTitle());
        movieReleaseDateTextView.setText(selectedMovie.getmReleaseDate());
        movieVotesTextView.setText(String.valueOf(selectedMovie.getmVoteAverage()));
        movieOverviewTextView.setText(selectedMovie.getmOverview());

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
