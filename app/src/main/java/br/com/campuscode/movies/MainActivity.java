package br.com.campuscode.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

import br.com.campuscode.movies.adapters.MoviesAdapter;
import br.com.campuscode.movies.api.SortType;
import br.com.campuscode.movies.controller.MoviesController;

public class MainActivity extends AppCompatActivity implements MoviesAdapter.ItemClickListener, Observer {

    RecyclerView recyclerView;
    MoviesAdapter adapter;
    MoviesController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MoviesController();
        controller.addObserver(this);
        controller.start();

        configureRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item != null) {
            SortType sortType;
            switch (item.getItemId()) {
                case R.id.action_load_movies_popularity_asc:
                    sortType = SortType.POPULARITY_ASC;
                    break;
                case R.id.action_load_movies_average_desc:
                    sortType = SortType.VOTE_AVERAGE_DESC;
                    break;
                case R.id.action_load_movies_average_asc:
                    sortType = SortType.VOTE_AVERAGE_ASC;
                    break;
                case R.id.action_load_movies_vote_count_desc:
                    sortType = SortType.VOTE_COUNT_DESC;
                    break;
                case R.id.action_load_movies_vote_count_asc:
                    sortType = SortType.VOTE_COUNT_ASC;
                    break;
                default:
                    sortType = SortType.POPULARITY_DESC;
            }
            controller.getMoviesSorted(sortType);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(View view, int position) {
        Bundle extras = new Bundle();
        extras.putSerializable("movie", controller.getMoviesList().get(position));

        Intent detailsIntent = new Intent(this, DetailsActivity.class);
        detailsIntent.putExtras(extras);
        startActivity(detailsIntent);
    }

    @Override
    public void update(Observable observable, Object o) {
        if ((int)o == MoviesController.RESPONSE_SUCCESS) {
            setupAdapter();
        }
        else if ((int)o == MoviesController.RESPONSE_FAILED) {
            Toast.makeText(this, "Problems receiving API response", Toast.LENGTH_LONG).show();
        }
    }

    private void configureRecyclerView() {
        // set up the RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.rv_movies);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
    }

    private void setupAdapter() {
        adapter = new MoviesAdapter(this, controller.getMoviesList());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }



}
