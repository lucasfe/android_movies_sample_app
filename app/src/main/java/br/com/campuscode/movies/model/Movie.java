package br.com.campuscode.movies.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import br.com.campuscode.movies.Config;

public class Movie implements Serializable {

    String title;
    String overview;
    @SerializedName("release_date")
    String releaseDate;
    @SerializedName("vote_average")
    float voteAverage;
    @SerializedName("vote_count")
    int voteCount;
    @SerializedName("backdrop_path")
    String backdropPath;
    @SerializedName("poster_path")
    String posterPath;

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }


    public float getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public String getBackdropPath() {
        return Config.BACKDROP_BASE_PATH + backdropPath;
    }

    public String getPosterPath() {
        return Config.POSTER_BASE_PATH + posterPath;
    }
}
