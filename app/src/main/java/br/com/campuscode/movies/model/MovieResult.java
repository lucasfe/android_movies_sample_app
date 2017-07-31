package br.com.campuscode.movies.model;

import java.util.List;

public class MovieResult {

    int page;
    int totalResults;
    int totalPages;
    List<Movie> results;

    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<Movie> getResults() {
        return results;
    }
}
