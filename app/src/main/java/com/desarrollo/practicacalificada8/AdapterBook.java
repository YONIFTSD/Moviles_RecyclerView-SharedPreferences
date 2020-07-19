package com.desarrollo.practicacalificada8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.desarrollo.practicacalificada8.Models.Book;

import java.util.ArrayList;

public class AdapterBook extends RecyclerView.Adapter<AdapterBook.ViewHolderBooks> {

    private ArrayList<Book> listBooks;
    private OnItemClickListener mListener;

    public AdapterBook(ArrayList<Book> listBooks) {
        this.listBooks = listBooks;
    }

    @NonNull
    @Override
    public ViewHolderBooks onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book, parent, false);
        return new ViewHolderBooks(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderBooks holder, int position) {
        holder.assignData(listBooks.get(position));
    }

    @Override
    public int getItemCount() {
        return listBooks.size();
    }

    public interface OnItemClickListener {
        void onFavoriteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    static class ViewHolderBooks extends RecyclerView.ViewHolder {

        ImageView item_thumbnail;
        TextView item_title;
        TextView item_publisher;
        TextView item_authors;
        ImageView item_favorite;

        ViewHolderBooks(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            item_thumbnail = itemView.findViewById(R.id.item_thumbnail);
            item_title = itemView.findViewById(R.id.item_title);
            item_publisher = itemView.findViewById(R.id.item_publisher);
            item_authors = itemView.findViewById(R.id.item_authors);
        }

        void assignData(Book book) {
            item_title.setText(book.getTitle());
            item_publisher.setText(book.getPublisher());
            item_authors.setText(book.getAuthors());
            Glide.with(item_thumbnail.getContext()).load(book.getThumbnail()).into(item_thumbnail);
        }
    }
}
