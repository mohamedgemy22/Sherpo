package com.enggemy22.sherpoproject.splash.authuntication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.enggemy22.sherpoproject.R;
import com.enggemy22.sherpoproject.splash.ui.PersonalNeedsActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RealLogInActivity extends AppCompatActivity {

    private EditText  mAdresss;
    private Spinner spinner;
    private EditText mphone;
    private Button mbutton;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_log_in);
        spinner = findViewById(R.id.spinnerCountries);

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryCode.countryNames));
        mphone = findViewById(R.id.editTextPhone);
        mAdresss = findViewById(R.id.adress);
        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendCode();
            }
        });

    }


    private void uploadData() {
        dialog.show();
        dialog.setMessage("wait please .....");
        FirebaseFirestore dp= FirebaseFirestore.getInstance();
        Map<String,String> map= new HashMap<>();
        map.put("phone","20"+ mphone.getText().toString().trim());
        map.put("adress", mAdresss.getText().toString().trim());
        dp.collection("users").document().set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dialog.dismiss();
                Toast.makeText(RealLogInActivity.this, "suceess", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RealLogInActivity.this, "failllled !..", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void sendCode() {
        String code = CountryCode.countryAreaCodes[spinner.getSelectedItemPosition()];
        String number = mphone.getText().toString().trim();
        if (number.isEmpty() || number.length() < 10) {
            mphone.setError("Valid number is required");
            mphone.requestFocus();
            return;
        }
        String phonenumber = "+" + code + number;
        Intent intent = new Intent(RealLogInActivity.this, OtpActivity.class);
        intent.putExtra("phonenumber", phonenumber);
        startActivity(intent);
    }



}
