package com.victor.sneakpeek2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * The type Adapter cards.
 */
public class AdapterCards extends PagerAdapter {

    private List<Model> models;
    private LayoutInflater inflater;
    private Context context;
    private String size;

    /**
     * Instantiates a new Adapter cards.
     *
     * @param models  the models
     * @param context the context
     * @param size    the size
     */
    public AdapterCards(List<Model> models, Context context, String size) {
        this.models = models;
        this.context = context;
        this.size = size;
    }

    @Override
    public int getCount() {
        return models.size();
    } // returns the size of items in the list

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        // inflate item.xml layout
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, container, false);

        // initialise views from item.xml
        ImageView imageView;
        TextView title, desc;

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);

        // set data
        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());

        // handle onClick()
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(context, SelectedCardActivity.class)
                        .putExtra("data", models.get(position))
                        .putExtra("size", size);
                context.startActivity(activity);
            }
        });

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
