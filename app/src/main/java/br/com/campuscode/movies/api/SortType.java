package br.com.campuscode.movies.api;

public enum SortType {
    POPULARITY_DESC("popularity.desc"),
    POPULARITY_ASC("popularity.asc"),
    VOTE_AVERAGE_DESC("vote_average.desc"),
    VOTE_AVERAGE_ASC("vote_average.asc"),
    VOTE_COUNT_DESC("vote_count.desc"),
    VOTE_COUNT_ASC("vote_count.asc");

    private final String query;

    SortType(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return this.query;
    }
}
