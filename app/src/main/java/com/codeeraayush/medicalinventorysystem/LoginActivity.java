package com.codeeraayush.medicalinventorysystem;

//import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.codeeraayush.medicalinventorysystem.R;
import com.codeeraayush.medicalinventorysystem.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    WebView webViewPopUp;
    private AlertDialog builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
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

        binding.loginAct.loadUrl("https://medhubs.netlify.app");
        WebSettings webSettings = binding.loginAct.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        binding.loginAct.setWebChromeClient(new CustomChromeClient());
        webSettings.setDomStorageEnabled(true);
        webSettings.setSupportMultipleWindows(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setUserAgentString("MedHub");
        binding.loginAct.setInitialScale(1);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.setAcceptThirdPartyCookies(binding.loginAct,true);
        }


    }


    class CustomChromeClient extends WebChromeClient {


        @Override
        public boolean onCreateWindow(WebView view, boolean isDialog,
                                      boolean isUserGesture, Message resultMsg) {
            webViewPopUp = new WebView(LoginActivity.this);
            webViewPopUp.setVerticalScrollBarEnabled(false);
            webViewPopUp.setHorizontalScrollBarEnabled(false);
            webViewPopUp.setWebChromeClient(new CustomChromeClient());
            webViewPopUp.getSettings().setJavaScriptEnabled(true);
            webViewPopUp.getSettings().setSaveFormData(true);
            webViewPopUp.getSettings().setEnableSmoothTransition(true);

            // pop the  webview with alert dialog
            builder = new AlertDialog.Builder(LoginActivity.this).create();
            builder.setTitle("");
            builder.setView(webViewPopUp);

            builder.setButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    webViewPopUp.destroy();
                    dialog.dismiss();
                }
            });

            builder.show();
            builder.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);

            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                cookieManager.setAcceptThirdPartyCookies(webViewPopUp, true);
            }

            WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
            transport.setWebView(webViewPopUp);
            resultMsg.sendToTarget();

            return true;
        }

    }
}