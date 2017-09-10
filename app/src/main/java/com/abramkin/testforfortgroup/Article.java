package com.abramkin.testforfortgroup;

import java.io.Serializable;

public class Article implements Serializable {
  private String image_url;
  private String title;
  private String date;
  private String last_update;
  private Integer version;
  private String rubric;
  private String type;


  public Article(String image_url, String title, String date, String last_update, Integer version, String rubric, String type) {
    this.image_url = image_url;
    this.title = title;
    this.date = date;
    this.last_update = last_update;
    this.version = version;
    this.rubric = rubric;
    this.type = type;
  }

  public String getImage_url() {
    return image_url;
  }

  public String getTitle() {
    return title;
  }

  public String getDate() {
    return date;
  }

  public String getLast_update() {
    return last_update;
  }

  public Integer getVersion() {
    return version;
  }

  public String getRubric() {
    return rubric;
  }

  public String getType() {
    return type;
  }
}