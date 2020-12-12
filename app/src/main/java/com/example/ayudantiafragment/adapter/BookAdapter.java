package com.example.ayudantiafragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ayudantiafragment.R;
import com.example.ayudantiafragment.model.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    private List<Book> bookList;
    private Context context;
    private OnItemClickListener listener;

    public BookAdapter(List<Book> bookList, Context context) {
        this.bookList = bookList;
        this.context = context;

    }

    @NonNull
    @Override
    public BookAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
        return new MyViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.MyViewHolder holder, int position) {
            holder.name.setText(bookList.get(position).getName());
            Glide.with(context).load(bookList.get(position).getImage()).override(500, 500).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener
                                               listener) {
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView, final BookAdapter.OnItemClickListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            imageView = itemView.findViewById(R.id.ivBook);
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                listener.onItemClick(position);
            });
        }
    }
}
