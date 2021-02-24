package com.example.retrofitex1;



import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {
    private static final String TAG = "UserAdapter";

    // 4번 컬렉션 생성
    private final List<Post> posts;

    public PostAdapter(List<Post> posts) {
        this.posts = posts;
    }

    // 5번 addItem, removeItem
    public void addItem(Post post){
        posts.add(post);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        posts.remove(position);
    }

    // 7번 getView랑 똑같음
    // 차이점이 있다면 listView는 화면에 3개가 필요 최초 로딩시에 3개를 그려야하니까 getView가 3번 호출됨
    // 그 다음에 스크롤을 해서 2개가 추가되야 될때, 다시 getView를 호출함.
    // 하지만 recyclerView는 스크롤을 해서 2개가 추가되어야 할 때 onBindViewHolder를 호출함
    // onCreateViewHolder는 해당 activity 실행시에만 호출 됨 / 최초 로딩시에만 호출되고 더이상 호출안됨
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // 메인 엑티비티에 연결할 객체를 만듬
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE); // 고정이다.
        View view = inflater.inflate(R.layout.post_item, parent,false); // 객체만 만들어져있음 뿌려져있지않음

        return new MyViewHolder(view); // view가 리스트뷰에 하나 그려짐
    }

    @Override // 최초 로딩끝나고 그 뒤부터는 얘가 호출됨, 데이터 추가
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        holder.setItem(posts.get(position));
    }

    // 6번 컬렉션 크기 알려주기 (화면에 몇개 그려야할지를 알아야 하기 때문)
    @Override
    public int getItemCount() {
        return posts.size();
    }

    // 1번 ViewHolder 만들기
    // ViewHolder란 하나의 View를 가지고 있는 Holder이다.
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // 2번 user_item이 가지고 있는 위젯들을 선언
        private TextView tvid;
        private TextView tvuserId;
        private TextView tvtitle;
        private TextView tvtext;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvid = itemView.findViewById(R.id.tv_id);
            tvuserId = itemView.findViewById(R.id.tv_userId);
            tvtitle = itemView.findViewById(R.id.tv_title);
            tvtext = itemView.findViewById(R.id.tv_text);
        }

        public void setItem(Post post){
            tvid.setText(post.getId().toString());
            tvuserId.setText(post.getUserId().toString());
            tvtitle.setText(post.getTitle());
            tvtext.setText(post.getText());
        }
    }
}
