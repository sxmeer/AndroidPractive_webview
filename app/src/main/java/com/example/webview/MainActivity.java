package com.example.webview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: called");
        setContentView(R.layout.activity_main);
        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},101);
        webView = findViewById(R.id.webview);
        setWebViewSettings(webView);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                //view.loadUrl(request.getUrl()+"?endpoint=https%3A%2F%2Fcloud.scorm.com%2FScormEngineInterface%2FTCAPI%2Fpublic%2F&auth=Basic%20VGVzdFVzZXI6cGFzc3dvcmQ%3D&actor=%7B%22mbox%22%3A%22mailto%3Atest%40beta.projecttincan.com%22%2C%22name%22%3A%22Test%20User%22%7D&registration=e168d6a3-46b2-4233-82e7-66b73a179727");
                return false;
            }

            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return super.shouldInterceptRequest(view, request);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }

            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
            }
        });
        webView.loadUrl("file:///"+Environment.getExternalStorageDirectory().getPath()+"/tincan/GolfExample_TCAPI/index.html" +
                "?endpoint=https%3A%2F%2Fcloud.scorm.com%2FScormEngineInterface%2FTCAPI%2Fpublic%2F&" +
                "auth=Basic%20VGVzdFVzZXI6cGFzc3dvcmQ%3D&" +
                "actor=%7B%22mbox%22%3A%22mailto%3Atest%40beta.projecttincan.com%22%2C%22name%22%3A%22Test%20User%22%7D&" +
                "registration=e168d6a3-46b2-4233-82e7-66b73a179727");
    }

    private void setWebViewSettings(WebView myWebView){
        myWebView.clearCache(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.setInitialScale(1);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.clearHistory();
        myWebView.getSettings().setAppCacheEnabled(true);
        myWebView.getSettings().setAllowFileAccess(true);
        myWebView.getSettings().setDomStorageEnabled(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setAllowFileAccessFromFileURLs(true);
        myWebView.getSettings().setSupportMultipleWindows(true);

        myWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.setWebContentsDebuggingEnabled(true);

        myWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        myWebView.getSettings().setAllowContentAccess(true);
        myWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
    }
}
