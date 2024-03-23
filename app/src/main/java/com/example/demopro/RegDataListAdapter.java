package com.example.demopro;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RegDataListAdapter extends RecyclerView.Adapter<RegDataListAdapter.ViewHolder>  {

    Context context;
    List<RegNewModel> registerList;

    public RegDataListAdapter(Context context, List<RegNewModel> registerList) {
        this.context = context;
        this.registerList = registerList;
    }


    @NonNull
    @Override
    public RegDataListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RegDataListAdapter.ViewHolder holder, int position) {
        if (registerList != null && position < registerList.size()) {
            RegNewModel registerModel = registerList.get(position);

            holder.username.setText(registerModel.getName());
            holder.contact.setText(registerModel.getMobileno());
            holder.gender.setText(registerModel.getGender());
            holder.email.setText(registerModel.getEmailid());
            holder.address.setText(registerModel.getAddress());
            holder.dob.setText(registerModel.getDob());
            holder.reg_fee.setText(String.valueOf(registerModel.getRegistrationfee()));

            holder.update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UpdateScreen(registerModel);

                }
            });

        }


    }

    @Override
    public int getItemCount() {
        return registerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView username,contact,gender,email,address,dob,reg_fee;
        Button update;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.reg_user);
            contact = itemView.findViewById(R.id.reg_Contact);
            gender = itemView.findViewById(R.id.reg_gender);
            email = itemView.findViewById(R.id.reg_email);
            address = itemView.findViewById(R.id.reg_address);
            dob = itemView.findViewById(R.id.reg_dob);
            reg_fee = itemView.findViewById(R.id.reg_Regfee);

            update = itemView.findViewById(R.id.update_button);

        }
    }

    private void UpdateScreen(RegNewModel registerModel) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("USER_DATA", String.valueOf(registerModel));
        context.startActivity(intent);
    }
}
