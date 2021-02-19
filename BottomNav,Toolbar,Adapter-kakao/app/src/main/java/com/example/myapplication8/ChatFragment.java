package com.example.myapplication8;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {
    private RecyclerView rvList;
    private ChatAdapter chatAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        rvList = view.findViewById(R.id.rv_chat_list);

        List<Chat> chats = new ArrayList<>();

        for (int i=0; i<10; i++){
            chats.add(new Chat(i,"user"+i,"content"+i,i+"시간전"));

        }
        LinearLayoutManager manager = new LinearLayoutManager(container.getContext(),RecyclerView.VERTICAL,false);
        rvList.setLayoutManager(manager);
        chatAdapter = new ChatAdapter(chats);
        rvList.setAdapter(chatAdapter);
        return view;
    }
}
