package com.cos.retrofit2movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.cos.retrofit2movieapp.adapter.MovieAdapter;
import com.cos.retrofit2movieapp.model.Movie;
import com.cos.retrofit2movieapp.service.MovieService;
import com.cos.retrofit2movieapp.viewmodel.MovieViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private RecyclerView rvMovie;
    private MovieAdapter movieAdapter;
    private MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initData();
        initObserve();
        initListener();

    }
    private void init(){
        rvMovie=findViewById(R.id.rv_movie);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvMovie.setLayoutManager(layoutManager);

        //어댑터
        movieAdapter = new MovieAdapter(MainActivity.this);
        rvMovie.setAdapter(movieAdapter);

        //ViewModel
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

    }

    private void initData(){ //초기 데이터 생성
       movieViewModel.findAll();
    }


    private  void initObserve(){
    movieViewModel.subscribe().observe(this, new Observer<List<Movie>>() {
        @Override
        public void onChanged(List<Movie> movies) {
            //데이터가 변경되면 어댑터에게 알려주면된다.
            movieAdapter.setMovies(movies);
        }
    });
    }

    private void initListener(){
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,  ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {


            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Log.d(TAG, "onSwiped: "+ viewHolder.getAdapterPosition());
                long id = movieAdapter.getMovieId(viewHolder.getAdapterPosition());
                movieViewModel.deleteById(viewHolder.getAdapterPosition());
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rvMovie);
    }
}
