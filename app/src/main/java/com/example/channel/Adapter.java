package com.example.channel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<Chaine> chaines;

    public Adapter(Context ctx, List<Chaine> chaines){
        this.inflater = LayoutInflater.from(ctx);
        this.chaines = chaines;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // bind the data
        holder.title.setText(chaines.get(position).getTitle());
        holder.chaine.setText(chaines.get(position).getChaine());
        Picasso.get().load(chaines.get(position).getCoverImage()).into(holder.chaineCoverImage);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, chaine;
        ImageView chaineCoverImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            chaine = itemView.findViewById(R.id.chaine);
            chaineCoverImage = itemView.findViewById(R.id.coverImage);
        }
    }
}
