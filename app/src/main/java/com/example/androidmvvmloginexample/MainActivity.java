package com.example.androidmvvmloginexample;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.androidmvvmloginexample.Interface.LoginResultCallbacks;
import com.example.androidmvvmloginexample.ViewModel.LoginViewModel;
import com.example.androidmvvmloginexample.ViewModel.LoginViewModelFactory;
import com.example.androidmvvmloginexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements LoginResultCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(this, new LoginViewModelFactory(this)).get(LoginViewModel.class));
    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this,"Login success",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onError(String message) {
        Toast.makeText(this,"Login error",Toast.LENGTH_LONG).show();

    }
}
