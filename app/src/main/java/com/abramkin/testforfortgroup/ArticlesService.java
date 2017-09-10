package com.abramkin.testforfortgroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ArticlesService {

  @GET("{page}")
  Call<List<Article>> articles(@Path("page") String page);

}