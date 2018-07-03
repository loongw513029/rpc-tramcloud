package com.sztvis.domain.domain;

import java.io.Serializable;

public class TramBasicInfo  implements Serializable {
  private Long id;
  private String alarmName;
  private Long level;
  private Long type;
  private boolean fixe;
  private boolean turn;
  private boolean isPush;
  private String threShold;
  private String customId;
  private boolean isEnable;
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAlarmName() {
    return alarmName;
  }

  public void setAlarmName(String alarmName) {
    this.alarmName = alarmName;
  }

  public Long getLevel() {
    return level;
  }

  public void setLevel(Long level) {
    this.level = level;
  }

  public Long getType() {
    return type;
  }

  public void setType(Long type) {
    this.type = type;
  }

  public boolean isFixe() {
    return fixe;
  }

  public void setFixe(boolean fixe) {
    this.fixe = fixe;
  }

  public boolean isTurn() {
    return turn;
  }

  public void setTurn(boolean turn) {
    this.turn = turn;
  }

  public boolean isPush() {
    return isPush;
  }

  public void setPush(boolean push) {
    isPush = push;
  }

  public String getThreShold() {
    return threShold;
  }

  public void setThreShold(String threShold) {
    this.threShold = threShold;
  }

  public String getCustomId() {
    return customId;
  }

  public void setCustomId(String customId) {
    this.customId = customId;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  private Long parentId;

  public boolean isEnable() {
    return isEnable;
  }

  public void setEnable(boolean enable) {
    isEnable = enable;
  }
}
