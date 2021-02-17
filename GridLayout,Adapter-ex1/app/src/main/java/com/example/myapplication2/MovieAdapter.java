package com.example.myapplication2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MovieAdapter extends BaseAdapter {
    private final List<Movie> movies;
    private static final String TAG = "ItemAdapter";

    //1.아이템 받고
    MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }
    public void addItem(Movie movie){
        movies.add(movie);
        notifyDataSetChanged();
    }
    public void removeItme(int position){
        movies.remove(position);
        notifyDataSetChanged();
    }

    //2설정
    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //객체를 생성해서 그림을 그리는 함수
    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //parent = listView
        //1.부모 컨텍스트 가져오기(Context는 MainActivity이다.)
        MainActivity mainActivity = (MainActivity) parent.getContext();

//        MainActivity MainActivityContext = (MainActivity)parent.getContext();

        //인플레이터 = 메모리에 띄운다.

        LayoutInflater inflater = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //강제성이 없어서!!
        //인플레이터 객체 생성 완료(xml을 자바 객체로 만들게 해주는 도구)
        View view = inflater.inflate(R.layout.list_item, parent, false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        ImageView ivpic = view.findViewById(R.id.iv_pic);

        tvTitle.setText(movies.get(position).getTitle());
        ivpic.setImageResource(movies.get(position).getPic());

        //3.리턴
        return view;
    }
}
