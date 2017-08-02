package br.com.campuscode.movies.adapters;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.campuscode.movies.R;
import br.com.campuscode.movies.model.Movie;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>{

    private List<Movie> mMovies;
    private Context mContext;
    private LayoutInflater inflater;
    ItemClickListener mClickListener;

    public MoviesAdapter(Context context, List<Movie> imagesUrls) {
        mMovies = imagesUrls;
        mContext = context;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.movies_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = mMovies.get(position);
        Picasso.with(mContext).load(movie.getPosterPath()).placeholder(R.drawable.ic_insert_photo_black).into(holder.imageView);
        holder.titleView.setText(movie.getTitle());
        holder.releaseDateView.setText(movie.getReleaseDate());

    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView titleView;
        public TextView releaseDateView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_movie_poster);
            itemView.setOnClickListener(this);
            titleView = (TextView) itemView.findViewById(R.id.iv_movie_title);
            releaseDateView = (TextView) itemView.findViewById(R.id.iv_movie_release_date);
        }

        @Override
        public void onClick(View view) {
            mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }



}
