package com.victor.sneakpeek2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * The type Adapter shoes.
 */
public class AdapterShoes extends RecyclerView.Adapter<AdapterShoes.ViewHolder> {
    /**
     * The Inflater.
     */
    LayoutInflater inflater;
    /**
     * The Shoes.
     */
    List<Shoe> shoes;

    /**
     * Instantiates a new Adapter shoes.
     *
     * @param context the context
     * @param shoes   the shoes
     */
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

    /**
     * The type View holder.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * The V name.
         */
        TextView vName,
        /**
         * The V sku.
         */
        vSku;

        /**
         * Instantiates a new View holder.
         *
         * @param itemView the item view
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vName = itemView.findViewById(R.id.shoeName);
            vSku = itemView.findViewById(R.id.shoeSku);

            // handle onClick() when an item in the collection list is pressed.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // intent redirect to EditShoe
                    Intent i = new Intent (v.getContext(), EditShoe.class);
                    i.putExtra("ID", shoes.get(getAdapterPosition()).getID());
                    v.getContext().startActivity(i);
                }
            });
        }
    }
}
