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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewActivity extends AppCompatActivity {

    //private static final String BASE_URL = "https://65ba3bcdb4d53c0665525d04.mockapi.io/";
//    private WebServices webServices;
    EditText Edt_Name,Edt_Email,Edt_dob,Edt_Gender,Edt_RegFee,Edt_ClgFee,Edt_ExamFee,Edt_TotalFee,Edt_Address,
            Edt_PassYear,Edt_MobNo;

    Button btnSave,btnDelete;
    String UserName,Email,Gender,Address,MobileNo;
    String CollegeFee,ExamFee,TotalFee,PassingYear,Dob,RegFee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);


        ViewById();

        // Initialize Retrofit
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        // Create an instance of the ApiService
//        webServices = retrofit.create(WebServices.class);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserName    = Edt_Name.getText().toString().trim();
                Email       = Edt_Email.getText().toString().trim();
                Dob         = Edt_dob.getText().toString().trim();
                Gender      = Edt_Gender.getText().toString().trim();
                RegFee      = Edt_RegFee.getText().toString().trim();
                CollegeFee  =Edt_ClgFee.getText().toString().trim();
                ExamFee     = Edt_ExamFee.getText().toString().trim();
                TotalFee    = Edt_TotalFee.getText().toString().trim();
                Address     =Edt_Address.getText().toString().trim();
                PassingYear = Edt_PassYear.getText().toString().trim();
                MobileNo    =Edt_MobNo.getText().toString().trim();
                if (Validation()) {
                    RegisterUser(UserName,Email,Dob,Gender,RegFee,CollegeFee,ExamFee,TotalFee,Address,PassingYear,MobileNo);

                }
                else {
                    Toast.makeText(NewActivity.this, "Please Try Again  ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(NewActivity.this,RegDataActivity.class);
                startActivity(i);
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

    private boolean Validation(){

        if (UserName.isEmpty()) {
            Edt_Name.setError("Please enter your name");
            Edt_Name.requestFocus();
            return false;
        }
        else if (Email.isEmpty()){
            Edt_Email.setError("Please Enter Email-id");
            Edt_Email.requestFocus();
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            Edt_Email.setError("Please enter a valid email address");
            Edt_Email.requestFocus();
            return false;
        }
        else if (Dob.isEmpty()) {
            Edt_dob.setError("Please enter your date of birth");
            Edt_dob.requestFocus();
            return false;
        }
        /*else {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                dateFormat.setLenient(false); // Disable lenient parsing

                // Parse the date string into a Date object
                Date dobDate = dateFormat.parse(Dob);

                // Validate other conditions related to dobDate if needed

            } catch (ParseException e) {
                Edt_dob.setError("Please enter a valid date of birth (dd-MM-yyyy)");
                Edt_dob.requestFocus();
                return false;
            }
        }*/

        else if (Gender.isEmpty() || Gender.equals("Select Gender")) {
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        else  if (RegFee.isEmpty()) {
            Edt_RegFee.setError("Please enter registration fee");
            Edt_RegFee.requestFocus();
            return false;
        }
        else if (CollegeFee.isEmpty()) {
            Edt_ClgFee.setError("Please enter college fee");
            Edt_ClgFee.requestFocus();
            return false;
        }
        else  if (ExamFee.isEmpty()) {
            Edt_ExamFee.setError("Please enter exam fee");
            Edt_ExamFee.requestFocus();
            return false;
        }
        else  if (TotalFee.isEmpty()) {
            Edt_TotalFee.setError("Please enter total fee");
            Edt_TotalFee.requestFocus();
            return false;
        }
        else if (Address.isEmpty()) {
            Edt_Address.setError("Please enter your address");
            Edt_Address.requestFocus();
            return false;
        }
        else if (PassingYear.isEmpty()) {
            Edt_PassYear.setError("Please enter your passing year");
            Edt_PassYear.requestFocus();
            return false;
        }
        else if (MobileNo.isEmpty()) {
            Edt_MobNo.setError("Please enter your mobile number");
            Edt_MobNo.requestFocus();
            return false;
        }

        return true;
    }

    private void RegisterUser(String UserName,String Email,String Dob,String Gender,String RegFee,String CollegeFee,String ExamFee,String TotalFee,String Address,
                              String PassingYear, String MobileNo)
    {
        RegNewModel newModel =new RegNewModel();
        newModel.setName(UserName);
        newModel.setEmailid(Email);
        newModel.setDob(Dob);
        newModel.setGender(Gender);
        newModel.setRegistrationfee(Integer.valueOf(RegFee));
        newModel.setCollegefee(Integer.valueOf(CollegeFee));
        newModel.setExamfee(Integer.valueOf(ExamFee));
        newModel.setTotalfee(Integer.valueOf(TotalFee));
        newModel.setAddress(Address);
        newModel.setPassingyear(PassingYear);
        newModel.setMobileno(MobileNo);

        Call<RegNewModel> registerNewUser = Constant.getWebService().RegisterNewUser(newModel);
        registerNewUser.enqueue(new Callback<RegNewModel>() {
            @Override
            public void onResponse(Call<RegNewModel> call, Response<RegNewModel> response) {
                Log.d("TAG", "Response Code: " + response.code());

                if (response.isSuccessful()) {
                    RegNewModel newModel =new RegNewModel();
                    Log.d("TAG", "Response: " + newModel.toString());
                    Intent i =new Intent(NewActivity.this,RegDataActivity.class);
                    startActivity(i);
                    Toast.makeText(NewActivity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
                } else {
                    // Log and handle the error
                    Log.e("TAG", "Error: " + response.code());
                    Toast.makeText(NewActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegNewModel> call, Throwable t) {

                Toast.makeText(NewActivity.this, "Internet Not Working..!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private  void DeleteUser()
    {
        DeleteResponce responce =new DeleteResponce();

        Call<DeleteResponce>responceCall =Constant.getWebService().DELETE_RESPONCE_CALL(responce);
        responceCall.enqueue(new Callback<DeleteResponce>() {
            @Override
            public void onResponse(Call<DeleteResponce> call, Response<DeleteResponce> response) {
                if (response.isSuccessful()){

                    Toast.makeText(NewActivity.this, "Data Deleted successfully..!!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(NewActivity.this, "Error..!!!", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<DeleteResponce> call, Throwable t) {
                Toast.makeText(NewActivity.this, "Internet Not Working..!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}