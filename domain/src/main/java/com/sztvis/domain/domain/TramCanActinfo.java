package com.sztvis.domain.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "TramCanActInfo")
public class TramCanActinfo  implements Serializable {
  //客户端主机传上来的自类型Id
  private int customId;

  public int getCustomId() {
    return customId;
  }

  public void setCustomId(int customId) {
    this.customId = customId;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  //结果值 2：打开 1：关闭 3：传感器报警 4：无效
  private String value;

}
