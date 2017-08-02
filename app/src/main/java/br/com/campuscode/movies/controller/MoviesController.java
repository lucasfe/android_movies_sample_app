package br.com.campuscode.movies.controller;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Observable;

import br.com.campuscode.movies.Config;
import br.com.campuscode.movies.api.MoviesAPI;
import br.com.campuscode.movies.api.SortType;
import br.com.campuscode.movies.model.Movie;
import br.com.campuscode.movies.model.MovieResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesController extends Observable implements Callback<MovieResult> {

    MoviesAPI moviesAPI;
    private MovieResult result;
    public static final int RESPONSE_SUCCESS = 987;
    public static final int RESPONSE_FAILED = 986;

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        moviesAPI = retrofit.create(MoviesAPI.class);

        Call<MovieResult> call = moviesAPI.getMoviesSorted(SortType.POPULARITY_DESC);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
        if (response.isSuccessful()) {
            result = response.body();
            setChanged();
            notifyObservers(RESPONSE_SUCCESS);
        }
        else {
            Log.d("Movie", "Response not sucessfull: " + response.errorBody());
            setChanged();
            notifyObservers(RESPONSE_FAILED);
        }
    }

    @Override
    public void onFailure(Call<MovieResult> call, Throwable t) {
        t.printStackTrace();
    }

    public void getMoviesSorted(SortType sortType) {
        Call<MovieResult> call = moviesAPI.getMoviesSorted(sortType);
        call.enqueue(this);
    }

    public List<Movie> getMoviesList() {
        if (result != null) {
            return result.getResults();
        }
        return null;
    }
}
