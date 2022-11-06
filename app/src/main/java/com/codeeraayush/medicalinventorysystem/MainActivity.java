package com.codeeraayush.medicalinventorysystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.codeeraayush.medicalinventorysystem.databinding.ActivityMainBinding;
import com.codeeraayush.medicalinventorysystem.fragments.AddMed;
import com.codeeraayush.medicalinventorysystem.fragments.AddVen;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.navView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.add_medicine:
                    replaceFrag(new AddMed());
                    break;
                case R.id.add_vendor:
                    replaceFrag(new AddVen());
                    break;
                case R.id.generateBill:
//                    replaceFrag(new AddMed());
                    Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        });



    }
    private void replaceFrag(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}