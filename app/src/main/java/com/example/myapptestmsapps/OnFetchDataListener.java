package com.example.myapptestmsapps;

import com.example.myapptestmsapps.Models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener {
    void onFetchData(List<NewsHeadlines> list, String message);
    void onError(String message);

}
