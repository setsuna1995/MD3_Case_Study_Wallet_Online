package model;

public class CategoryDetail {
    private int categoryDetailId;
    private String name;
    private Boolean status;
    private int categoryId;

    public CategoryDetail() {
    }

    public CategoryDetail(int categoryDetailId, String name, Boolean status, int categoryId) {
        this.categoryDetailId = categoryDetailId;
        this.name = name;
        this.status = status;
        this.categoryId = categoryId;
    }

    public int getCategoryDetailId() {
        return categoryDetailId;
    }

    public void setCategoryDetailId(int categoryDetailId) {
        this.categoryDetailId = categoryDetailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
