package com.example.myapplication8;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {

    private final List<Chat> chats;

    public ChatAdapter(List<Chat> chats) {
        this.chats = chats;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.chat_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(chats.get(position));
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvUsername;
        private TextView tvContent;
        private TextView tvTime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tv_user);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvTime = itemView.findViewById(R.id.tv_time);
        }
        public void setItem(Chat chat){
            tvUsername.setText(chat.getUser());
            tvContent.setText(chat.getContent());
            tvTime.setText(chat.getTime());
        }
    }


}
