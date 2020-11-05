package by.zercomp.application.model.entity;

public class Category extends Identifiable {

    private String name;
    private String description;

    public Category() {
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Category category = (Category) o;

        if (getName() != null ? !getName().equals(category.getName()) : category.getName() != null) {
            return false;
        }
        return getDescription() != null ? getDescription().equals(category.getDescription()) : category.getDescription() == null;
    }

    @Override
    public int hashCode() {
        final int prime = 113;
        int result = super.hashCode();
        result = prime * result + (getName() != null ? getName().hashCode() : 0);
        result = prime * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("Category{");
        builder.append("name='").append(name).append("\'");
        builder.append(", description='").append(description).append("\'");
        return builder.append('}').toString();
    }
}
