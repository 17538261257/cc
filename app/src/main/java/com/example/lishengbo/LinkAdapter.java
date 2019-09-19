package com.example.lishengbo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.lishengbo.Bean.Linkman;

import java.util.ArrayList;

public class LinkAdapter extends RecyclerView.Adapter<LinkAdapter.ViewHolder> {
    Context context;
    private ArrayList<Linkman> linkmen;

    public ArrayList<Linkman> getLinkmen() {
        return linkmen;
    }

    public LinkAdapter(Context context, ArrayList<Linkman> linkmen) {
        this.context = context;
        this.linkmen = linkmen;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        viewHolder.tv1.setText(linkmen.get(i).getName());
        viewHolder.tv2.setText(linkmen.get(i).getHao());
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemClickListener.itemClick(i);
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return linkmen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1, tv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);

        }
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    interface OnItemClickListener{
        void itemClick(int i);
    }
}
