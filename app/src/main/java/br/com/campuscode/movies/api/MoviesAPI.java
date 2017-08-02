package br.com.campuscode.movies.api;

import br.com.campuscode.movies.Config;
import br.com.campuscode.movies.model.MovieResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesAPI {

    @GET("discover/movie?&api_key=" + Config.API_KEY)
    Call<MovieResult> getMoviesSorted(@Query("sort_by") SortType sort);
}
