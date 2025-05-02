package com.example.rv_v2_;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatsFragment extends Fragment {

    RecyclerView rvChats;
    ChatListAdapter adapter;
    ArrayList<Contact> contacts;


    public ChatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chats, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);

    }

    private void init(View v)
    {
        rvChats = v.findViewById(R.id.rvChats);
        contacts = new ArrayList<>();
        contacts.add(new Contact(false, "Hey where are you?", "Momina", 150, "cat", "1:25 AM"));
        contacts.add(new Contact(false, "Hey you?", "Azlan", 15, "lion", "1:25 AM"));
        contacts.add(new Contact(false, "Where?", "Arslan Kashif", 10, "lion", "1:25 AM"));
        contacts.add(new Contact(false, "Bakwas band kro", "Mehwish Hayat", 0, "cat", "1:25 AM"));
        contacts.add(new Contact(false, "Quiz kr k ayin..", "Kiran", 1, "cat", "1:25 AM"));
        contacts.add(new Contact(false, "Mid kb hai?", "Aqsa", 5, "cat", "1:25 AM"));
        contacts.add(new Contact(false, "Honsla rakh", "Rabina", 0, "cat", "1:25 AM"));
        contacts.add(new Contact(false, "India ki......", "Chawal", 0, "cat", "1:25 AM"));

        adapter = new ChatListAdapter(getContext(), contacts);
        rvChats.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        //rvChats.setLayoutManager(new GridLayoutManager(this, 2));
        rvChats.setAdapter(adapter);

    }

}