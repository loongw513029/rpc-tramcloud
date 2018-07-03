package com.sztvis.domain.domain;

import java.io.Serializable;

public class Tramsitesettinginfo implements Serializable {
  private Long id;
  private String key;
  private String value;
  private Long type;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Long getType() {
    return type;
  }

  public void setType(Long type) {
    this.type = type;
  }
}
