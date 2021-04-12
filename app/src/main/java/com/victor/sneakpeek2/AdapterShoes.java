package com.victor.sneakpeek2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterShoes extends RecyclerView.Adapter<AdapterShoes.ViewHolder> {
    LayoutInflater inflater;
    List<Shoe> shoes;

    AdapterShoes(Context context, List<Shoe> shoes) {
        this.inflater = LayoutInflater.from(context);
        this.shoes = shoes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = shoes.get(position).getName();
        String sku = shoes.get(position).getSku();
        holder.vName.setText(name);
        holder.vSku.setText(sku);
    }

    @Override
    public int getItemCount() {
        return shoes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView vName, vSku;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vName = itemView.findViewById(R.id.shoeName);
            vSku = itemView.findViewById(R.id.shoeSku);
        }
    }
}
