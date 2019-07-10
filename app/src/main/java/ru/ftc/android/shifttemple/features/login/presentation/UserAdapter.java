package ru.ftc.android.shifttemple.features.login.presentation;

import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.ftc.android.shifttemple.R;
import ru.ftc.android.shifttemple.features.login.domain.model.User;

public final class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    private final List<User> userList = new ArrayList<>();
    private final LayoutInflater inflater;
    private User selectedUser;

    UserAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = inflater.inflate(R.layout.user_item, parent, false);
        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        holder.bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    void setUserList(List<User> userList) {
        this.userList.clear();
        this.userList.addAll(userList);
        notifyDataSetChanged();
    }

    User getSelectedUser() {
        return selectedUser;
    }

    class UserHolder extends RecyclerView.ViewHolder {

        private final TextView userNameView;
        private final RadioButton radioButton;

        UserHolder(View view) {
            super(view);

            userNameView = view.findViewById(R.id.user_item_name);
            radioButton = view.findViewById(R.id.user_item_radio_button);
        }

        void bind(final User user) {
            userNameView.setText(user.getFirstName());
            radioButton.setChecked(user == selectedUser);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    selectedUser = user;
                    notifyDataSetChanged();
                }
            });
        }
    }
}