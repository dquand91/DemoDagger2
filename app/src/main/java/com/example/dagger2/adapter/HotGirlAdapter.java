package com.example.dagger2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dagger2.R;
import com.example.dagger2.data.model.Hotgirl;
import com.example.dagger2.data.model.ScreenData;

import java.util.List;

public class HotGirlAdapter extends RecyclerView.Adapter<HotGirlAdapter.HotGirlViewHolder> {

    List<Hotgirl> listGirls;
    ScreenData screenData;

    public HotGirlAdapter(List<Hotgirl> listGirls, ScreenData screenData) {
        this.listGirls = listGirls;
        this.screenData = screenData;
    }

    @NonNull
    @Override
    public HotGirlViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new HotGirlViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_girls, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HotGirlViewHolder hotGirlViewHolder, int position) {
        hotGirlViewHolder.setData(listGirls.get(position));
    }

    @Override
    public int getItemCount() {
        return listGirls.size();
    }

    class HotGirlViewHolder extends RecyclerView.ViewHolder {

        ImageView ivAvatar;
        TextView tvName;

        public HotGirlViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            tvName = itemView.findViewById(R.id.tvName);
        }

        public void setData(Hotgirl hotgirl) {
            itemView.getLayoutParams().width = screenData.getWidth() / 2;
            itemView.getLayoutParams().height = screenData.getWidth() / 2;
            tvName.setText(hotgirl.getName());
            Glide.with(itemView.getContext()).load(hotgirl.getAvatar()).into(ivAvatar);
        }
    }
}