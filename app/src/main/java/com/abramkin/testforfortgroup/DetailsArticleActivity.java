package com.abramkin.testforfortgroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class DetailsArticleActivity extends AppCompatActivity {
  private static final String EXTRA_ARTICLE = "article";

  public static void launch(Context context, Article article) {
    Intent i = new Intent(context, DetailsArticleActivity.class);
    i.putExtra(EXTRA_ARTICLE, article);
    context.startActivity(i);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_article_info);

    Article article = (Article) getIntent().getSerializableExtra(EXTRA_ARTICLE);
    DetailsArticleFragment articleFragment =
        (DetailsArticleFragment) getSupportFragmentManager().findFragmentById(R.id.articleInfoFragment);
    articleFragment.setArticle(article);
  }
}