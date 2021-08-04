package com.example.post_request;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTvEmail;
    private TextView mTvPassword;
    private TextView mTvTitle;
    private TextView mTvRequestType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();

        mTvEmail.setText(getIntent().getStringExtra("Email"));
        mTvPassword.setText(getIntent().getStringExtra("Id"));
        mTvTitle.setText(getIntent().getStringExtra("Title"));
        mTvRequestType.setText(getIntent().getStringExtra("RequestType"));
    }

    private void initViews() {
        mTvEmail = findViewById(R.id.tvEmail);
        mTvPassword = findViewById(R.id.tvPassword);
        mTvTitle = findViewById(R.id.tvTitle);
        mTvRequestType = findViewById(R.id.tvRequestType);

    }
}