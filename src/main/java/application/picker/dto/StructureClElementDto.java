package application.picker.dto;

public class StructureClElementDto {

  private boolean selected;
  private boolean id;
  private String name;
  private int order;
  private int level;

  public boolean isSelected() {
    return selected;
  }

  public void setSelected(boolean selected) {
    this.selected = selected;
  }

  public boolean isId() {
    return id;
  }

  public void setId(boolean id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }
}
