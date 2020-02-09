package com.enggemy22.sherpoproject.splash.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.enggemy22.sherpoproject.R;
import com.enggemy22.sherpoproject.splash.fragments.ChatFragment;
import com.enggemy22.sherpoproject.splash.fragments.ClosingFragment;
import com.enggemy22.sherpoproject.splash.fragments.ContactUsFragment;
import com.enggemy22.sherpoproject.splash.fragments.InformationFragment;
import com.enggemy22.sherpoproject.splash.fragments.MyAccountFragment;
import com.enggemy22.sherpoproject.splash.fragments.SignUpFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private ImageView PersonalNeeds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonalNeeds = findViewById(R.id.img_personalNeeds);
        PersonalNeeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,PersonalNeedsActivity.class));
            }
        });

    }


//    @OnClick({R.id.menueBar, R.id.img_offer, R.id.txt_offer, R.id.img_personalNeeds, R.id.txt_personalNeeds, R.id.img_medicalNeeds, R.id.txt_medicalNeeds, R.id.img_cleaning, R.id.txt_cleaning, R.id.img_mekup, R.id.txt_mekup, R.id.img_accountant, R.id.Txt_signUp, R.id.img_contactUS, R.id.txt_contactUS, R.id.img_chat, R.id.txt_chat, R.id.img_information, R.id.txt_information, R.id.img_myAccount, R.id.txt_myAccount, R.id.img_closing, R.id.txt_closing})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.menueBar:
//                if (drawer.isDrawerOpen(Gravity.LEFT)) {
//                    drawer.closeDrawers();
//                } else {
//                    drawer.openDrawer(Gravity.LEFT);
//                }
//                break;
//            case R.id.img_offer:
//                startActivity(new Intent(MainActivity.this, OfferActivity.class));
//                break;
//            case R.id.txt_offer:
//                startActivity(new Intent(MainActivity.this, OfferActivity.class));
//                break;
//            case R.id.img_personalNeeds:
//                startActivity(new Intent(MainActivity.this, PersonalNeedsActivity.class));
//                break;
//            case R.id.txt_personalNeeds:
//                startActivity(new Intent(MainActivity.this, PersonalNeedsActivity.class));
//                break;
//            case R.id.img_medicalNeeds:
//                startActivity(new Intent(MainActivity.this, MedicalNeesdActivity.class));
//
//                break;
//            case R.id.txt_medicalNeeds:
//                startActivity(new Intent(MainActivity.this, MedicalNeesdActivity.class));
//
//                break;
//            case R.id.img_cleaning:
//                startActivity(new Intent(MainActivity.this, CleaningActivity.class));
//                break;
//            case R.id.txt_cleaning:
//                startActivity(new Intent(MainActivity.this, CleaningActivity.class));
//
//                break;
//            case R.id.img_mekup:
//                startActivity(new Intent(MainActivity.this, MekupActivity.class));
//
//                break;
//            case R.id.txt_mekup:
//                startActivity(new Intent(MainActivity.this, MekupActivity.class));
//
//                break;
//            case R.id.img_accountant:
//                FragmentManager signUp = getSupportFragmentManager();
//                signUp.beginTransaction().replace(R.id.pageContainer, new SignUpFragment()).commit();
//                drawer.closeDrawers();
//                break;
//            case R.id.Txt_signUp:
//                FragmentManager accountSign = getSupportFragmentManager();
//                accountSign.beginTransaction().replace(R.id.pageContainer, new SignUpFragment()).commit();
//                drawer.closeDrawers();
//                break;
//            case R.id.img_contactUS:
//                FragmentManager contactImg = getSupportFragmentManager();
//                contactImg.beginTransaction().replace(R.id.pageContainer, new ContactUsFragment()).commit();
//                drawer.closeDrawers();
//                break;
//            case R.id.txt_contactUS:
//                FragmentManager contactTxt = getSupportFragmentManager();
//                contactTxt.beginTransaction().replace(R.id.pageContainer, new ContactUsFragment()).commit();
//                drawer.closeDrawers();
//                break;
//            case R.id.img_chat:
//                FragmentManager chatImg = getSupportFragmentManager();
//                chatImg.beginTransaction().replace(R.id.pageContainer, new ChatFragment()).commit();
//                drawer.closeDrawers();
//                break;
//            case R.id.txt_chat:
//                FragmentManager chatTxt = getSupportFragmentManager();
//                chatTxt.beginTransaction().replace(R.id.pageContainer, new ChatFragment()).commit();
//                drawer.closeDrawers();
//                break;
//            case R.id.img_information:
//                FragmentManager informationImg = getSupportFragmentManager();
//                informationImg.beginTransaction().replace(R.id.pageContainer, new InformationFragment()).commit();
//                drawer.closeDrawers();
//                break;
//            case R.id.txt_information:
//                FragmentManager informationText = getSupportFragmentManager();
//                informationText.beginTransaction().replace(R.id.pageContainer, new InformationFragment()).commit();
//                drawer.closeDrawers();
//                break;
//            case R.id.img_myAccount:
//                FragmentManager myAccountI = getSupportFragmentManager();
//                myAccountI.beginTransaction().replace(R.id.pageContainer, new MyAccountFragment()).commit();
//                drawer.closeDrawers();
//                break;
//            case R.id.txt_myAccount:
//                FragmentManager myAccountT = getSupportFragmentManager();
//                myAccountT.beginTransaction().replace(R.id.pageContainer, new MyAccountFragment()).commit();
//                drawer.closeDrawers();
//                break;
//            case R.id.img_closing:
//                FragmentManager closingI = getSupportFragmentManager();
//                closingI.beginTransaction().replace(R.id.pageContainer, new ClosingFragment()).commit();
//                drawer.closeDrawers();
//                break;
//            case R.id.txt_closing:
//                FragmentManager closingT = getSupportFragmentManager();
//                closingT.beginTransaction().replace(R.id.pageContainer, new ClosingFragment()).commit();
//                drawer.closeDrawers();
//                break;
//        }
//    }
}
