package com.example.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoticiasCovidFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoticiasCovidFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MainActivity myMainActivity;

    public NoticiasCovidFragment() {
        // Required empty public constructor
    }

    public NoticiasCovidFragment(MainActivity myMainActivity) {
        // Required empty public constructor
        this.myMainActivity = myMainActivity;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NoticiasCovidFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NoticiasCovidFragment newInstance(String param1, String param2) {
        NoticiasCovidFragment fragment = new NoticiasCovidFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_noticias_covid, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.swipeRefresh);
        WebView webView = (WebView) getView().findViewById(R.id.webView);

        webView.setWebChromeClient((WebChromeClient)(new WebChromeClient() {
        }));

        //Intrinsics.checkNotNullExpressionValue(webView, "webView");
        webView.setWebViewClient((WebViewClient)(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(@Nullable WebView view, @Nullable WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            public void onPageStarted(@Nullable WebView view, @Nullable String url, @Nullable Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.swipeRefresh);
                swipeRefreshLayout.setRefreshing(true);
            }

            public void onPageFinished(@Nullable WebView view, @Nullable String url) {
                super.onPageFinished(view, url);
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.swipeRefresh);
                swipeRefreshLayout.setRefreshing(false);
            }
        }));
        webView = (WebView) getView().findViewById(R.id.webView);

        WebSettings var3 = webView.getSettings();
        WebSettings settings = var3;
        settings.setJavaScriptEnabled(true);
        ((WebView) getView().findViewById(R.id.webView)).loadUrl("https://www.google.com/search?q=noticias+covid&rlz=1C1CHBD_esES859ES859&sxsrf=ALeKk02wZuZVQIOQ9p1z1NPVaFTxgEuIfQ:1605966711439&source=lnms&tbm=nws&sa=X&ved=2ahUKEwiNweya5JPtAhUaURUIHYGPAzoQ_AUoAXoECAgQAw&biw=1920&bih=937");

        WebView finalWebView = webView;
        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        ((WebView) getView().findViewById(R.id.webView)).loadUrl("https://www.google.com/search?q=noticias+covid&rlz=1C1CHBD_esES859ES859&sxsrf=ALeKk02wZuZVQIOQ9p1z1NPVaFTxgEuIfQ:1605966711439&source=lnms&tbm=nws&sa=X&ved=2ahUKEwiNweya5JPtAhUaURUIHYGPAzoQ_AUoAXoECAgQAw&biw=1920&bih=937");
                    }
                });
    }
}