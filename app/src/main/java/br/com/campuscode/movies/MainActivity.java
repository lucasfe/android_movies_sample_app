package br.com.campuscode.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.campuscode.movies.adapters.MoviesAdapter;

public class MainActivity extends AppCompatActivity implements MoviesAdapter.ItemClickListener {


    MoviesAdapter adapter;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            List<String> urls = new ArrayList<>();
            urls.add("www.teste.com");
            urls.add("www.teste.com");
            urls.add("www.teste.com");
            urls.add("www.teste.com");
            urls.add("www.teste.com");
            urls.add("www.teste.com");
            urls.add("www.teste.com");


            // set up the RecyclerView
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_movies);
            int numberOfColumns = 3;
            recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
            adapter = new MoviesAdapter(this, urls);
            adapter.setClickListener(this);
            recyclerView.setAdapter(adapter);

        }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "Testing Recycler view", Toast.LENGTH_SHORT).show();
    }
}
