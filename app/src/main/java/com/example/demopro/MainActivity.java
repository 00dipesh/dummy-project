package com.example.demopro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

     EditText Edt_Name,Edt_Email,Edt_dob,Edt_Gender,Edt_RegFee,Edt_ClgFee,Edt_ExamFee,Edt_TotalFee,Edt_Address,
             Edt_PassYear,Edt_MobNo;

         Button btnSave,btnDelete;
     String UserName,Email,Gender,Address,MobileNo;
    String CollegeFee,ExamFee,TotalFee,PassingYear,Dob,RegFee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewById();

//        RegNewModel userData = (RegNewModel) Objects.requireNonNull(getIntent().getSerializableExtra("USER_DATA"));

        Intent intent = getIntent();
        if (intent.hasExtra("USER_DATA")) {
            Serializable userDataSerializable = intent.getSerializableExtra("USER_DATA");

            if (userDataSerializable instanceof RegNewModel) {
                RegNewModel userData = (RegNewModel) userDataSerializable;
                Edt_Name.setText(userData.getName());
                Edt_MobNo.setText(userData.getMobileno());
                Edt_Gender.setText(userData.getGender());
                Edt_Email.setText(userData.getEmailid());
                Edt_Address.setText(userData.getAddress());
                Edt_dob.setText(userData.getDob());
            } else {
                // Handle the case where the data is not of type RegNewModel
                // You can log an error or display a message to the user
            }
        }

       


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserName = Edt_Name.getText().toString();
                MobileNo = Edt_MobNo.getText().toString();
                Gender = Edt_Gender.getText().toString();
                Email = Edt_Email.getText().toString();
                Address = Edt_Address.getText().toString();
                Dob = Edt_dob.getText().toString();

                RegNewModel updatedUser = new RegNewModel();

                Intent resultIntent = new Intent(MainActivity.this,RegDataActivity.class);
                resultIntent.putExtra("UPDATED_USER_DATA", String.valueOf(updatedUser));
                setResult(RESULT_OK, resultIntent);
                finish();

            }
        });

    }
    private void ViewById() {
        Edt_Name    = findViewById(R.id.Edt_Name);
        Edt_Email   =findViewById(R.id.Edt_Email);
        Edt_dob     =findViewById(R.id.Edt_dob);
        Edt_Gender  =findViewById(R.id.Edt_Gender);
        Edt_RegFee  =findViewById(R.id.Edt_RegFee);
        Edt_ClgFee  =findViewById(R.id.Edt_ClgFee);
        Edt_ExamFee =findViewById(R.id.Edt_ExamFee);
        Edt_TotalFee=findViewById(R.id.Edt_TotalFee);
        Edt_Address =findViewById(R.id.Edt_Address);
        Edt_PassYear=findViewById(R.id.Edt_PassYear);
        Edt_MobNo   =findViewById(R.id.Edt_MobNo);

        btnSave   =findViewById(R.id.btnSave);
        btnDelete =findViewById(R.id.btnDelete);
    }


//        private void RegisterUser(String UserName,String Email,String Dob,String Gender,String RegFee,String CollegeFee,String ExamFee,String TotalFee,String Address,
//                                  String PassingYear, String MobileNo)
//    {
//        RegisterModel registerModel =new RegisterModel();
//        registerModel.setName(UserName);
//        registerModel.setEmailid(Email);
//        registerModel.setDob(Dob);
//        registerModel.setGender(Gender);
//        registerModel.setRegistrationfee(RegFee);
//        registerModel.setCollegefee(CollegeFee);
//        registerModel.setExamfee(ExamFee);
//        registerModel.setTotalfee(TotalFee);
//        registerModel.setAddress(Address);
//        registerModel.setPassingyear(PassingYear);
//        registerModel.setMobileno(MobileNo);
//
//        Call<RegisterModel> registerModelCall = webServices.RegisterUser(registerModel);
//        registerModelCall.enqueue(new Callback<RegisterModel>() {
//            @Override
//            public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
//                Log.d("TAG", "Response Code: " + response.code());
//
//                if (response.isSuccessful()) {
//                    RegisterModel registerModel1 = response.body();
//                    Log.d("TAG", "Response: " + registerModel1.toString());
//                    Toast.makeText(MainActivity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
//                } else {
//                    // Log and handle the error
//                    Log.e("TAG", "Error: " + response.code());
//                    Toast.makeText(MainActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RegisterModel> call, Throwable t) {
//
//                Toast.makeText(MainActivity.this, "Internet Not Working..!!!", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }


}