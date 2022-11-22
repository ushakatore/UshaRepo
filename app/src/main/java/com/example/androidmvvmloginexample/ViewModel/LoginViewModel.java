package com.example.androidmvvmloginexample.ViewModel;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.androidmvvmloginexample.Interface.LoginResultCallbacks;
import com.example.androidmvvmloginexample.Model.User;

public class LoginViewModel extends ViewModel
{
    private User user;
    private LoginResultCallbacks loginResultCallbacks;

    public LoginViewModel(LoginResultCallbacks loginResultCallbacks)
    {
        this.loginResultCallbacks = loginResultCallbacks;
        this.user =new User();

    }

    public TextWatcher getEmailTextWatcher()
    {
        return  new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setEmail(s.toString());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher()
    {
        return  new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setPassword(s.toString());
            }
        };
    }


    // Writeprocess to Login
    public void onLoginClicked(View view)
    {

        if (user.isValidData())
        {
            loginResultCallbacks.onSuccess("Login Success");
        }
        else
        {
            loginResultCallbacks.onError("Login error");
        }
    }
}
