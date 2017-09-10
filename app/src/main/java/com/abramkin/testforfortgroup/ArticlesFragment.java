package com.abramkin.testforfortgroup;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ArticlesFragment extends Fragment implements ArticlesAdapter.ArticleClickListener {
  private static final String TAG = ArticlesFragment.class.getSimpleName();

  private RecyclerView recyclerView;

  String[] pages = {"file_1.json","file_2.json","file_3.json","file_4.json","file_5.json","file_6.json","file_7.json","file_8.json","file_9.json" };

  public ArticlesFragment() {}

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_articles, container, false);

  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    recyclerView = (RecyclerView) view;
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

      loadArticles();


  }

  private void loadArticles() {
    ArticlesApplication app = (ArticlesApplication) getContext().getApplicationContext();
    ArticlesService articlesService = app.getArticlesService();
    articlesService.articles("file_1.json").enqueue(new Callback<List<Article>>() {
      @Override
      public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
        if (response.isSuccessful()) {
          List<Article> articles = response.body();
          ArticlesAdapter ra = new ArticlesAdapter(articles, ArticlesFragment.this,Glide.with(ArticlesFragment.this));
          recyclerView.setAdapter(ra);

        } else {
          Toast.makeText(getContext(), "Failed to load articles", Toast.LENGTH_LONG).show();
        }
      }

      @Override
      public void onFailure(Call<List<Article>> call, Throwable t) {
        Log.e(TAG, "Failed to load articles", t);
        Toast.makeText(getContext(), "Failed to load articles", Toast.LENGTH_LONG).show();
      }
    });
  }
  @Override
  public void onArticleClick(Article article) {
    DetailsArticleActivity.launch(getContext(), article);
  }
}
