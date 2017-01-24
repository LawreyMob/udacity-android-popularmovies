package com.example.android.popularmovies;

import android.content.Context;
import com.example.android.popularmovies.data.Movie;
import com.squareup.picasso.Picasso;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Lawrey on 23/1/17.
 */

public class MoviesAdapter extends BaseAdapter {

    private final Context mContext;
    private Movie[] mMovies;

    public MoviesAdapter(Context context, Movie[] movies) {
        this.mContext = context;
        this.mMovies = movies;
    }

    @Override
    public int getCount() {
        if (mMovies != null) {
            return mMovies.length;
        }
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Movie movie= mMovies[position];

        // view holder pattern
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.movie_item, null);

            final ImageView imageViewCoverArt = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
            final TextView titleTextView = (TextView)convertView.findViewById(R.id.textview_movie_title);
            final TextView votesTextView = (TextView)convertView.findViewById(R.id.textview_movie_votes);

            final ViewHolder viewHolder = new ViewHolder(titleTextView, votesTextView, imageViewCoverArt);
            convertView.setTag(viewHolder);
        }

        final ViewHolder viewHolder = (ViewHolder)convertView.getTag();
        viewHolder.imageViewCoverArt.setImageResource(R.drawable.abc);
        viewHolder.titleTextView.setText(movie.getmTitle());
        viewHolder.votesTextView.setText(String.valueOf(movie.getmVoteAverage())+"/10");

        // make sure to comment out this image setter
        //viewHolder.imageViewCoverArt.setImageResource(book.getImageResource());

        Picasso.with(mContext).load(movie.getImageURL()).into(viewHolder.imageViewCoverArt);

        return convertView;
    }

    private class ViewHolder {
        private final TextView titleTextView;
        private final TextView votesTextView;
        private final ImageView imageViewCoverArt;

        public ViewHolder(TextView nameTextView, TextView authorTextView, ImageView imageViewCoverArt) {
            this.titleTextView = nameTextView;
            this.votesTextView = authorTextView;
            this.imageViewCoverArt = imageViewCoverArt;
        }
    }

    /**
     * This method is used to set the weather forecast on a ForecastAdapter if we've already
     * created one. This is handy when we get new data from the web but don't want to create a
     * new ForecastAdapter to display it.
     *
     * @param movieData The new movie data to be displayed.
     */
    public void setMovieData(Movie[] movieData) {
        mMovies = movieData;
        notifyDataSetChanged();
    }

}
