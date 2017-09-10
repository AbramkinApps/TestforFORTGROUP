package com.abramkin.testforfortgroup;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArticlesApplication extends Application {
  private ArticlesService mArticlesService;

  @Override
  public void onCreate() {
    super.onCreate();
    mArticlesService = createArticleService();
  }

  private ArticlesService createArticleService() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://fgsoft.ru//upload/api/materialjson/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    return retrofit.create(ArticlesService.class);
  }

  public ArticlesService getArticlesService() {
    return mArticlesService;
  }
}
