package com.abramkin.testforfortgroup;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;

import java.util.List;

import static com.abramkin.testforfortgroup.R.id.imageView;


public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {
  private final List<Article> mArticles;
  private final ArticleClickListener mArticleClickListener;
    private final RequestManager imageRequestManager;

  public ArticlesAdapter(List<Article> articles, ArticleClickListener articleClickListener, RequestManager imageRequestManager) {
    this.mArticles = articles;
    this.mArticleClickListener = articleClickListener;
      this.imageRequestManager = imageRequestManager;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.item_article, parent, false);
    return new ViewHolder(view, mArticleClickListener);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    Article article = mArticles.get(position);
    holder.bindTo(article);
  }

  @Override
  public int getItemCount() {
    return mArticles.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView nameView;
    private final TextView dateView;
    private final ImageView imView;

    private Article article;


      ViewHolder(View itemView, final ArticleClickListener articleClickListener) {
      super(itemView);
      nameView = (TextView) itemView.findViewById(R.id.textView);
      dateView = (TextView) itemView.findViewById(R.id.textView2);
      imView = (ImageView) itemView.findViewById(imageView);
      itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          articleClickListener.onArticleClick(article);
        }
      });
    }

    void bindTo(Article article) {
      this.article = article;
        imageRequestManager.load(article.getImage_url()).into(imView);

      dateView.setText(article.getTitle().toString());
      nameView.setText(article.getDate().toString());
    }
  }

  public interface ArticleClickListener {
    void onArticleClick(Article article);
  }
}