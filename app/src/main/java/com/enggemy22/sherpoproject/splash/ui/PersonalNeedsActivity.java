package com.enggemy22.sherpoproject.splash.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.enggemy22.sherpoproject.R;
import com.enggemy22.sherpoproject.splash.authuntication.LogInActivity;
import com.enggemy22.sherpoproject.splash.model.PersonalModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonalNeedsActivity extends AppCompatActivity implements PersonalAdapter.OnItemClick {
    private static final String TAG = "error";
    @BindView(R.id.PersnalRecycler)
    RecyclerView PersnalRecycler;
    private FirebaseFirestore mFirestore;
    private Task<QuerySnapshot> mQuery;
    private ArrayList<PersonalModel> mList;
   private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_needs);
        ButterKnife.bind(this);
        mFirestore = FirebaseFirestore.getInstance();
        iniate();
        getData();

    }


    private void iniate() {
        PersnalRecycler.setLayoutManager(new LinearLayoutManager(this));
        PersnalRecycler.setHasFixedSize(true);
        mList = new ArrayList<>();
        progressBar=findViewById(R.id.progress_circular);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getData();

    }

    private void getData() {
       progressBar.setVisibility(View.VISIBLE);
        mQuery = mFirestore.collection("مستلزمات شخصية/")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (DocumentSnapshot snapshot : queryDocumentSnapshots) {
                            progressBar.setVisibility(View.GONE);
                            PersonalModel personalModel = snapshot.toObject(PersonalModel.class);
                            mList.add(personalModel);
                            progressBar.setVisibility(View.GONE);
                        }
                        PersonalAdapter adapter = new PersonalAdapter(mList, PersonalNeedsActivity.this,PersonalNeedsActivity.this::OnButtonClick);
                        PersnalRecycler.setAdapter(adapter);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PersonalNeedsActivity.this, "Fail !", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void OnButtonClick(int posistion) {
        startActivity(new Intent(PersonalNeedsActivity.this, LogInActivity.class));
    }
}
