package com.abramkin.testforfortgroup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsArticleFragment extends Fragment {

  private TextView nameView;
  private TextView dateView;
  private TextView lastUpdateView;
  private TextView versionView;
  private TextView rubricView;
  private TextView typeView;


  public DetailsArticleFragment() {}

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_article_info, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    nameView = (TextView) view.findViewById(R.id.txView1);
    dateView = (TextView) view.findViewById(R.id.txView2);
    lastUpdateView = (TextView) view.findViewById(R.id.txView3);
    versionView = (TextView) view.findViewById(R.id.txView4);
    rubricView = (TextView) view.findViewById(R.id.txView5);
    typeView = (TextView) view.findViewById(R.id.txView6);

  }

  public void setArticle(final Article article) {
    nameView.setText("Заголовок: "+article.getTitle());
    dateView.setText("Дата: "+article.getDate());
    lastUpdateView.setText("Обновление: "+article.getLast_update());
    versionView.setText("Версия: "+article.getVersion());
    rubricView.setText("Рубрика: "+article.getRubric());
    typeView.setText("Тип: "+article.getType());

  }
}