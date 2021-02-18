package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvNoteList;
    //    private UserAdapter userAdapter;
    private NoteAdapter noteAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Note> notes = new ArrayList<>();
        for (int i=1; i<10; i++){
            notes.add(new Note(i,"All Connors","I`ll be in your neightborhood doing errands",15));
            notes.add(new Note(i,"Me,Scott,Jennifer","Aw dang Wish I could but I`m outta town",2));
            notes.add(new Note(i,"Sandra Adams","Do you have Paris recommendation?",6));
            notes.add(new Note(i,"All Connors","I`ll be in your neightborhood doing errands",15));
            notes.add(new Note(i,"All Connors","I`ll be in your neightborhood doing errands",15));
            notes.add(new Note(i,"All Connors","I`ll be in your neightborhood doing errands",15));
        }

        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rvNoteList = findViewById(R.id.rv_note_list);
        rvNoteList.setLayoutManager(manager);

        noteAdapter = new NoteAdapter(notes);

        rvNoteList.setAdapter(noteAdapter);
    }
}