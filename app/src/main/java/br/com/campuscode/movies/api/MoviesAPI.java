package br.com.campuscode.movies.api;

import br.com.campuscode.movies.Config;
import br.com.campuscode.movies.model.MovieResult;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesAPI {

    @GET("discover/movie?sort_by=popularity.desc&api_key=" + Config.API_KEY)
    Call<MovieResult> getMostPopularMovies();


}
