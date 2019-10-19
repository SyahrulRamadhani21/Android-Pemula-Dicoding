package com.example.submisionnganu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridmouseAdapter extends RecyclerView.Adapter<GridmouseAdapter.GridViewHolder>{

    private ArrayList<Mouse> listMouse;
//    private Context context;

    public GridmouseAdapter(ArrayList<Mouse> listProvince) {
        this.listMouse = listProvince;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_mouse, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, final int position) {
        final Mouse mouse = listMouse.get(position);
        Context context;

        Glide.with(holder.itemView.getContext())
                .load(mouse.getPhoto())
                .apply(new RequestOptions().override(500,500))
                .into(holder.imgPhoto);

        holder.tvName.setText(mouse.getName());
        holder.tvPrice.setText(mouse.getPrice());
        holder.btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MouseDetailActivity.class);
                intent.putExtra(MouseDetailActivity.MOUSENAME,mouse.getName());
                intent.putExtra(MouseDetailActivity.PRICE,mouse.getPrice());
                intent.putExtra(MouseDetailActivity.DESKRIPSI,mouse.getDescription());
                intent.putExtra("Image",mouse.getPhoto());
                view.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listMouse.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder{

        ImageView imgPhoto;
        TextView tvName;
        TextView tvPrice;
        Button btnRead;

        GridViewHolder(@NonNull View view) {
            super(view);
            imgPhoto = view.findViewById(R.id.img_item_photo);
            tvName = view.findViewById(R.id.tv_province_name);
            btnRead = view.findViewById(R.id.btn_read);

//            btnRead.setOnClickListener(this);


        }

//        @Override
//        public void onClick(View view) {
//            Intent intent = new Intent(view.getContext(),ProvinceDetailActivity.class);
//            view.getContext().startActivity(intent);
//        }
    }

}
