package br.com.campuscode.movies.api;

import java.util.List;

import br.com.campuscode.movies.model.Movie;
import br.com.campuscode.movies.model.MovieList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesAPI {

    @GET("discover/movie?sort_by=popularity.desc&api_key=2765a0483a4939f9053eeaf7e45ed597")
    Call<List<Movie>> getMostPopularMovies();



    @GET("movie/top_rated?api_key=2765a0483a4939f9053eeaf7e45ed597")
    Call<MovieList> getTopRatedMovies();

}
