package com.codeeraayush.medicalinventorysystem.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.codeeraayush.medicalinventorysystem.R;

public class getBill extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView=inflater.inflate(R.layout.get_bill,container,false);
        WebView myWebView=myView.findViewById(R.id.webViewGetBill);

        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("https://youtube.com");



        WebSettings webSettings=myWebView.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);
//        webSettings.setPluginState(WebSettings.PluginState.ON);


        return myView;
    }
}
