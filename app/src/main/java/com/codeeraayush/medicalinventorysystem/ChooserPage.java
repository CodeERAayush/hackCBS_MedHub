package com.codeeraayush.medicalinventorysystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.codeeraayush.medicalinventorysystem.databinding.ActivityChooserPageBinding;
import com.codeeraayush.medicalinventorysystem.fragments.AddMed;
import com.codeeraayush.medicalinventorysystem.fragments.AddVen;

public class ChooserPage extends AppCompatActivity {
ActivityChooserPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityChooserPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFrag(new AddMed());

//getSupportActionBar().hide();
        binding.bottomChooser.setOnItemSelectedListener(item->
        {
            switch (item.getItemId()) {
                case R.id.userSec:
//                    replaceFrag(new AddMed());
                    replaceFrag(new AddMed());
                    break;
                case R.id.admSec:
//                    Toast.makeText(this, "Admin Section...", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ChooserPage.this,LoginActivity.class));
                    break;
            }
            return true;
        });


    }

    private void replaceFrag(AddMed addMed) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, addMed);
        fragmentTransaction.commit();
    }
}