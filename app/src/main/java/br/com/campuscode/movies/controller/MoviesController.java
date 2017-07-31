package br.com.campuscode.movies.controller;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.campuscode.movies.api.MoviesAPI;
import br.com.campuscode.movies.model.Movie;
import br.com.campuscode.movies.model.MovieResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesController implements Callback<MovieResult> {

    static final String BASE_URL = "https://api.themoviedb.org/3/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MoviesAPI moviesAPI = retrofit.create(MoviesAPI.class);

        Call<MovieResult> call = moviesAPI.getMostPopularMovies();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
        if (response.isSuccessful()) {
            MovieResult moviesList = response.body();
            for (Movie movie : moviesList.getResults()) {
                Log.d("Movie", "Movie: " + movie.getTitle());
            }
        }
        else {
            Log.d("Movie", "Response: " + response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<MovieResult> call, Throwable t) {
        t.printStackTrace();
    }
}
