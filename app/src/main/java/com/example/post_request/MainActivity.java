package com.example.post_request;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText mEtEmail;
    private EditText mEtPassword;
    private EditText mEtTitle;
    private EditText mEtRequestType;
    private Button mBtnPost;
    RequestModel requestModel = new RequestModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mEtEmail = findViewById(R.id.etEmail);
        mEtPassword = findViewById(R.id.etPassword);
        mEtTitle = findViewById(R.id.etTitle);
        mEtRequestType = findViewById(R.id.etRequestType);
        mBtnPost = findViewById(R.id.btnPost);

        mBtnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestModel.setEmail(mEtEmail.getText().toString());
                requestModel.setPassword(mEtPassword.getText().toString());
                requestModel.setTitle(mEtTitle.getText().toString());
                requestModel.setRequestType(mEtRequestType.getText().toString());
                callApi();


            }
        });
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.sendPost(requestModel).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                ResponseModel responseModel = response.body();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Email", responseModel.getEmail());
                intent.putExtra("Id", responseModel.getId()+"");
                intent.putExtra("Title", responseModel.getTitle());
                intent.putExtra("RequestType", responseModel.getRequestType());
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

    }

    private void openSecondActivity() {

    }
}