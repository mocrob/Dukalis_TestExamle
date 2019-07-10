package ru.ftc.android.shifttemple.features.login.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ru.ftc.android.shifttemple.R;
import ru.ftc.android.shifttemple.features.BaseActivity;
import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.MvpView;
import ru.ftc.android.shifttemple.features.login.domain.model.User;

public final class CreateUserActivity extends BaseActivity implements LoginView{

    public static void start(final Context context){
        Intent intent = new Intent(context, CreateUserActivity.class);
        context.startActivity(intent);
    }

    private EditText ageText;
    private EditText cityText;
    private EditText contactsText;
    private EditText emailText;
    private EditText firstnameText;
    private EditText lastnameText;
    private EditText usernameText;
    private Button createUserButton;

    private LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user_activity);
        initView();
    }
    private void initView() {
        ageText = findViewById(R.id.agePlaceText);
        cityText = findViewById(R.id.cityPlaceText);
        contactsText = findViewById(R.id.contactsPlaceText);
        emailText = findViewById(R.id.emailPlaceText);
        firstnameText = findViewById(R.id.firstnamePlaceText);
        lastnameText = findViewById(R.id.lastnamePlaceText);
        usernameText = findViewById(R.id.usernamePlaceText);
        createUserButton = findViewById(R.id.createNewUserButton);

        createUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(Integer.valueOf(String.valueOf(ageText.getText())),String.valueOf(cityText.getText()),
                        String.valueOf(contactsText.getText()),String.valueOf(emailText.getText()),String.valueOf(firstnameText.getText()),
                        String.valueOf(lastnameText.getText()),String.valueOf(usernameText.getText()));
                presenter.createUser(user);
                ageText.setText("");
                cityText.setText("");
                contactsText.setText("");
                emailText.setText("");
                firstnameText.setText("");
                lastnameText.setText("");
                usernameText.setText("");
            }
        });
    }
    @Override
    protected  MvpPresenter<LoginView> getPresenter() {
        presenter = PresenterFactory.createPresenter(this);
        return presenter;
    }

    @Override
    protected MvpView  getMvpView() {
        return this;
    }


    @Override
    public void showUserList(List<User> userList) {

    }

    @Override
    public void openBookListScreen() {

    }

    @Override
    public void openTaskListScreen(User user) {

    }

    @Override
    public void showNotSelectedUserError() {

    }

    @Override
    public void openCreateUserScreen() {

    }

    @Override
    public void showError() {

    }
}
