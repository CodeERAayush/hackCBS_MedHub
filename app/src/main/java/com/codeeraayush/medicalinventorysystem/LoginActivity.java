package com.codeeraayush.medicalinventorysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.codeeraayush.medicalinventorysystem.R;
import com.codeeraayush.medicalinventorysystem.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        binding.loginAct.loadUrl("https://google.com");
        getSupportActionBar().hide();


        binding.loginAct.setWebViewClient(new WebViewClient());

//        binding.loginAct.setWebViewClient(new WebViewClient()
//        {
//            public boolean shouldOverrideUrlLoading(WebView view, String url)
//            {
//                String url2="https://joyful-sorbet-2c79ad.netlify.app/";
//                // all links  with in ur site will be open inside the webview
//                //links that start ur domain example(http://www.example.com/)
//                if (url != null && url.equals(url2)){
//                    return false;
//                }
//                // all links that points outside the site will be open in a normal android browser
//                else
//                {
//                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
//                    finish();
//                    return true;
//                }
//            }
//        });
        binding.loginAct.loadUrl("https://google.com");
        WebSettings webSettings =binding.loginAct.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.getDomStorageEnabled();
        webSettings.setUseWideViewPort(true);

    }
}