package com.example.rv_v2_;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ChatListVieHolder> {

    Context context;
    ArrayList<Contact> contacts;
    public ChatListAdapter(Context c, ArrayList<Contact> data)
    {
        context = c;
        contacts = data;
    }

    @NonNull
    @Override
    public ChatListVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(context)
                .inflate(R.layout.single_chat_list_design, parent, false);
        return new ChatListVieHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListVieHolder holder, int position) {
        Contact c = contacts.get(position);
        holder.tvMsg.setText(c.getMsg());
        holder.tvName.setText(c.getName());
        holder.tvTime.setText(c.getTime());

        if(c.getNotifications()==0)
        {
            holder.tvNotificaiton.setVisibility(GONE);
        }
        else {
            holder.tvNotificaiton.setVisibility(VISIBLE);
            holder.tvNotificaiton.setText(c.getNotifications() + "");
        }
        if(c.getProfileUrl().equals("cat"))
        {
            holder.ivProfilePic.setImageResource(R.drawable.cat);
        }
        else
        {
            holder.ivProfilePic.setImageResource(R.drawable.lion);
        }

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ChatListVieHolder extends RecyclerView.ViewHolder {
        // hooks
        ImageView ivProfilePic;
        TextView tvName, tvMsg, tvTime, tvNotificaiton;
        public ChatListVieHolder(@NonNull View itemView) {
            super(itemView);
            ivProfilePic= itemView.findViewById(R.id.ivProfilePic);
            tvName= itemView.findViewById(R.id.tvName);
            tvMsg= itemView.findViewById(R.id.tvMsg);
            tvTime= itemView.findViewById(R.id.tvTime);
            tvNotificaiton= itemView.findViewById(R.id.tvNotification);

        }
    }
}
