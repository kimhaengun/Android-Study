package com.example.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//컬렉션 정보
class ItemAdapter extends BaseAdapter {

    private final List<Movie> movies;
    private static final String TAG = "ItemAdapter";

    public ItemAdapter(List<Movie> movies){
        this.movies=movies;
    }

    //전체크기를 확인하기 위해서 필요 (나도, 어댑터도)
    @Override
    public int getCount() { //전체 아이템 사이즈 = movies.size()
        return movies.size();
    }

    //클릭하거나 어떤 이벤트 발생시에 컬렉션 정보를 확인하기 위해 필요(나도, 어댑터)
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
        Log.d(TAG, "getView: "+position);
        if (convertView==null){
            Log.d(TAG, "convertView가 null이 아닙니다.");
        }
        //1.부모 컨텍스트 가져오기(Context는 MainActivity이다.)
        Context context = parent.getContext();
        MainActivity MainActivity = (MainActivity) context;

//        MainActivity MainActivityContext = (MainActivity)parent.getContext();

        //인플레이터 = 메모리에 띄운다.
        //인플레이터 객체 생성 완료(xml을 자바 객체로 만들게 해주는 도구)
        LayoutInflater inflater = (LayoutInflater) MainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //강제성이 없어서!!
        View view=inflater.inflate(R.layout.list_item,parent, false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        tvTitle.setText(movies.get(position).getTitle());



//        view.setOnClickListener(v -> {
////            Toast.makeText(context, "클릭됨"+position, Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(context, DetailActivity.class);
//            intent.putExtra("title",movies.get(position).getTitle());
//            MainActivity.startActivity(intent);
//
//        });
//
//        view.setOnLongClickListener(v -> {
//            Toast.makeText(context, "롱클릭됨"+position, Toast.LENGTH_SHORT).show();
//            Log.d(TAG, "movies 사이즈: "+movies.size());
//            movies.remove(position); //해당 position
//            Log.d(TAG, "movies 변경 사이즈: "+movies.size()); //확인결과 데이터는 사라졌지만 화면 로딩이 안됨.
//            this.notifyDataSetChanged(); //데이터 변경 후 UI동기화 시 호출해야함.
//            return  true;
//        });
        return view;
    }
}
