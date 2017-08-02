package br.com.campuscode.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.campuscode.movies.R;
import br.com.campuscode.movies.controller.MoviesController;
import br.com.campuscode.movies.model.Movie;

public class DetailsActivity extends AppCompatActivity {

    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("movie")) {
            movie = (Movie) intent.getSerializableExtra("movie");

            Picasso.with(this).load(movie.getBackdropPath()).placeholder(R.drawable.ic_insert_photo_black).into((ImageView)findViewById(R.id.movie_backdrop));

            ((TextView)findViewById(R.id.movie_title)).setText(movie.getTitle());
            ((TextView)findViewById(R.id.movie_release_date)).setText("Release Date: " + movie.getReleaseDate());
            ((TextView)findViewById(R.id.movie_vote_average)).setText("Vote Average: " + String.valueOf(movie.getVoteAverage()));
            ((TextView)findViewById(R.id.movie_votes)).setText("Votes: " + String.valueOf(movie.getVoteCount()));
            ((TextView)findViewById(R.id.movie_description)).setText(movie.getOverview());
        }
    }
}
