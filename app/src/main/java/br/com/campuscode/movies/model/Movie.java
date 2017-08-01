package br.com.campuscode.movies.model;

import br.com.campuscode.movies.Config;

public class Movie {

    String title;
    String overview;
    String release_date;
    float vote_average;
    int vote_count;
    String backdrop_path;
    String poster_path;

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return release_date;
    }


    public float getVoteAverage() {
        return vote_average;
    }

    public int getVoteCount() {
        return vote_count;
    }

    public String getBackdropPath() {
        return Config.BACKDROP_BASE_PATH + backdrop_path;
    }

    public String getPosterPath() {
        return Config.POSTER_BASE_PATH + poster_path;
    }
}
