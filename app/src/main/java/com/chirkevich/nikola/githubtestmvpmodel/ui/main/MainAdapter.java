package com.chirkevich.nikola.githubtestmvpmodel.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chirkevich.nikola.githubtestmvpmodel.R;
import com.chirkevich.nikola.githubtestmvpmodel.data.test.db.model.User;
import com.chirkevich.nikola.githubtestmvpmodel.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Колян on 03.12.2017.
 */

public class MainAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback callback;
    private List<User> userList;


    public MainAdapter(List<User> userList) {
        this.userList = userList;
    }

    public void setCallback(Callback callback)
    {
        this.callback = callback;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blog_view, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (userList != null && userList.size() > 0) {
            return userList.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (userList != null && userList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    public void addItems(List<User> users)
    {
        userList.addAll(users);
        notifyDataSetChanged();
    }

    public interface Callback
    {
        void onUsersEmptyViewRetryClick();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.cover_image_view)
        ImageView coverImageView;

        @BindView(R.id.title_text_view)
        TextView titleTextView;

        @BindView(R.id.author_text_view)
        TextView authorTextView;

        @BindView(R.id.date_text_view)
        TextView dateTextView;

        @BindView(R.id.content_text_view)
        TextView contentTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            coverImageView.setImageDrawable(null);
            titleTextView.setText("");
            contentTextView.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);
            final User user = userList.get(position);
            titleTextView.setText(String.valueOf(user.getId()));
            if (user.getName() != null) {
                authorTextView.setText(user.getName());
            }
        }
    }

    public class EmptyViewHolder extends BaseViewHolder {

        @BindView(R.id.btn_retry)
        Button retryButton;

        @BindView(R.id.tv_message)
        TextView messageTextView;

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }

        @OnClick(R.id.btn_retry)
        void onRetryClick() {
            if (callback != null)
                callback.onUsersEmptyViewRetryClick();
        }
    }
}
