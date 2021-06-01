package com.gsntec.testapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder> {
    List<Users> itemList;

    public CustomAdapter(List<Users> item) {
        this.itemList = item;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.Holder holder, int position) {
        Users usr = itemList.get(position);
        holder.textView.setText(usr.getEmail());
        holder.textView1.setText(usr.getNumber());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        TextView textView,textView1;

        public Holder(View view) {
            super(view);
            textView = view.findViewById(R.id.text_view);
            textView1=view.findViewById(R.id.text_view1);
        }
    }
}
