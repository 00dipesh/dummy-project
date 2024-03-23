package com.example.demopro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegDataActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RegDataListAdapter regDataListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_data);

        recyclerView=findViewById(R.id.recyler_data);




        DataListuser();
    }

    private void DataListuser(){

       // Call<RegisterModel> modelCall = WebServices.
        Call<List<RegNewModel>> listCall =Constant.getWebService().GetRegisterUser();
        listCall.enqueue(new Callback<List<RegNewModel>>() {
            @Override
            public void onResponse(Call<List<RegNewModel>> call, Response<List<RegNewModel>> response) {

                if (response.isSuccessful()) {
                    List<RegNewModel> model = response.body();
                    if (model != null) {
                        regDataListAdapter = new RegDataListAdapter(RegDataActivity.this, model);
                        recyclerView.setAdapter(regDataListAdapter);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(RegDataActivity.this));
                    }
                }


            }

            @Override
            public void onFailure(Call<List<RegNewModel>> call, Throwable t) {

            }
        });
//        registerModelCall.enqueue(new Callback<RegNewModel>() {
//            @Override
//            public void onResponse(Call<RegNewModel> call, Response<RegNewModel> response) {
//                if (response.isSuccessful()){
//                    RegNewModel data = response.body();
//                    if (data != null) {
//                        List<RegNewModel> dataList = new ArrayList<>();
//                        dataList.add(data);
//                    }
//                    Toast.makeText(RegDataActivity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
//
//                }
//                else {
//                    Toast.makeText(RegDataActivity.this, "Error", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RegNewModel> call, Throwable t) {
//                Toast.makeText(RegDataActivity.this, "Internet Error", Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }
}