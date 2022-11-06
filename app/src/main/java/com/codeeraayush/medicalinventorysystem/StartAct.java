package com.codeeraayush.medicalinventorysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.codeeraayush.medicalinventorysystem.databinding.ActivityStartBinding;

public class StartAct extends AppCompatActivity {
ActivityStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.startId.setWebViewClient(new WebViewClient()
        {
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                String url2="https://joyful-sorbet-2c79ad.netlify.app/";
                // all links  with in ur site will be open inside the webview
                //links that start ur domain example(http://www.example.com/)
                if (url != null && url.equals(url2)){
                    return false;
                }
                // all links that points outside the site will be open in a normal android browser
                else
                {
                    startActivity(new Intent(StartAct.this, ChooserPage.class));
                    finish();
                    return true;
                }
            }
        });
binding.startId.loadUrl("https://joyful-sorbet-2c79ad.netlify.app/");
        WebSettings webSettings =binding.startId.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
//        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setUseWideViewPort(true);
//        webView.setInitialScale(1);

    }
}