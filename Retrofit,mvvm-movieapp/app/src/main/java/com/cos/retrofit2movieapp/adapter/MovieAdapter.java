package com.cos.retrofit2movieapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.retrofit2movieapp.MainActivity;
import com.cos.retrofit2movieapp.R;
import com.cos.retrofit2movieapp.databinding.CardItemBinding;
import com.cos.retrofit2movieapp.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private static final String TAG = "MovieAdapter";

    private List<Movie> movies = new ArrayList<>();

    private final MainActivity mContext;

    public MovieAdapter(MainActivity mContext) {
        this.mContext = mContext;
    }
    public List<Movie> getMovies(){
        return movies;
    }

    public void setMovies(List<Movie> movies){
        this.movies = movies;
        notifyDataSetChanged();
    }

    public long getMovieId(int position){
        return movies.get(position).getId();
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardItemBinding cardItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext)
                , R.layout.card_item, parent, false
        );
        return new MovieViewHolder(cardItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.cardItemBinding.setMovie(movies.get(position)); //xml에 코드 집어넣는 코드
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    //card-item 디자인과 연결되기 때문에 확인하기
    //데이터 바인딩
    //1.gradle에
    //    dataBinding{
    //        enabled=true
    //    } 코드 삽입하기

    class MovieViewHolder extends RecyclerView.ViewHolder {

        private CardItemBinding cardItemBinding;


        public MovieViewHolder(@NonNull CardItemBinding cardItemBinding) {
            super(cardItemBinding.getRoot());
            this.cardItemBinding = cardItemBinding;
        }
    }
}
