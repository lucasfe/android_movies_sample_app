package br.com.campuscode.movies.api;

import br.com.campuscode.movies.model.MovieResult;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesAPI {

    @GET("discover/movie?sort_by=popularity.desc&api_key=2765a0483a4939f9053eeaf7e45ed597")
    Call<MovieResult> getMostPopularMovies();


}
