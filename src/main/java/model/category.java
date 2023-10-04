package model;

public class category {
    private int categoryID;
    private String name;

    public category() {
    }

    public category(int idCategory, String name) {
        this.categoryID = idCategory;
        this.name = name;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int idCategory) {
        this.categoryID = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
