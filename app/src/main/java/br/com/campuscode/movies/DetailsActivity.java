package br.com.campuscode.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.campuscode.movies.R;
import br.com.campuscode.movies.controller.MoviesController;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String popularityUrl = getString(R.string.base_api_url) + getString(R.string.api_discover_popularity_parameter) + "&" + getString(R.string.api_key_parameter);

        MoviesController controller = new MoviesController();
        controller.start();

    }
}
