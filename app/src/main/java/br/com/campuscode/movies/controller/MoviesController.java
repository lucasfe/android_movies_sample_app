package br.com.campuscode.movies.controller;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import br.com.campuscode.movies.api.MoviesAPI;
import br.com.campuscode.movies.model.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesController implements Callback<List<Movie>> {

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

        Call<List<Movie>> call = moviesAPI.getMostPopularMovies();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
        if (response.isSuccessful()) {
            List<Movie> moviesList = response.body();
            for (Movie movie : moviesList) {
                Log.d("Movie", "Movie: " + movie.getName());
            }
        }
        else {
            Log.d("Movie", "Response: " + response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Movie>> call, Throwable t) {
        t.printStackTrace();
    }
}
