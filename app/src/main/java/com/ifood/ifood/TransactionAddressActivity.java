package com.ifood.ifood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ifood.ifood.data.DeleveryInfo;
import com.ifood.ifood.data.Dish;
import com.ifood.ifood.data.Transaction;
import com.ifood.ifood.ultil.SessionLoginController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TransactionAddressActivity extends AppCompatActivity {
    TextView txtName;
    TextView txtPhone;
    TextView txtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_address);

        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        txtAddress = findViewById(R.id.txtAddress);

//        SessionLoginController session = new SessionLoginController(this);
//        txtName.setText(session.getUsername());


    }

    public void onCLick(View view) {
        if(txtName.getText().toString().equals("")){
            Toast.makeText(this, "Name must be fill", Toast.LENGTH_SHORT).show();
            return;
        }
        if(txtPhone.getText().toString().equals("")){
            Toast.makeText(this, "Phone must be fill", Toast.LENGTH_SHORT).show();
            return;
        }
        if(txtAddress.getText().toString().equals("")){
            Toast.makeText(this, "Address must be fill", Toast.LENGTH_SHORT).show();
            return;
        }

        Transaction transaction = new Transaction();
        transaction.setName(txtName.getText().toString());
        transaction.setPhone(txtPhone.getText().toString());
        transaction.setAddress(txtAddress.getText().toString());


        Intent intent = getIntent();
        List<Dish> listDishOrder = (List<Dish>)intent.getSerializableExtra("LISTDISHORDER");
        intent = new Intent(this, TransactionConfirmActivity.class);
        intent.putExtra("LISTORDERS" , (Serializable) listDishOrder);
        intent.putExtra("TRANSACTION", (Serializable) transaction);
        startActivity(intent);
    }
}