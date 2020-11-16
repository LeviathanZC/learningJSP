package by.zercomp.application.model.entity;

public class Product extends Identifiable {

    private String name;
    private String description;
    private long price;
    private Category category;
    private int quantity;
    private Brand brand;

    public Product() {
    }

    public Product(String name, String description, long price, Category category, int quantity, Brand brand) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.brand = brand;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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

        Product product = (Product) o;

        if (getPrice() != product.getPrice()) return false;
        if (getQuantity() != product.getQuantity()) return false;
        if (getName() != null ? !getName().equals(product.getName()) : product.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(product.getDescription()) : product.getDescription() != null)
            return false;
        if (getCategory() != null ? !getCategory().equals(product.getCategory()) : product.getCategory() != null)
            return false;
        return getBrand() != null ? getBrand().equals(product.getBrand()) : product.getBrand() == null;
    }

    @Override
    public int hashCode() {
        final int prime = 113;
        int result = super.hashCode();
        result = prime * result + (getName() != null ? getName().hashCode() : 0);
        result = prime * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = prime * result + (int) (getPrice() ^ (getPrice() >>> 32));
        result = prime * result + (getCategory() != null ? getCategory().hashCode() : 0);
        result = prime * result + getQuantity();
        result = prime * result + (getBrand() != null ? getBrand().hashCode() : 0);
        result = prime * result + prime;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("Product{");
        builder.append("name='").append(this.name).append('\'');
        builder.append(", description='").append(description).append('\'');
        builder.append(", price=").append(price).append('\'');
        builder.append(", category=").append(category).append('\'');
        builder.append(", quantity=").append(quantity).append('\'');
        builder.append(", brand=").append(brand).append('\'');
        builder.append('}');
        return builder.toString();
    }
}
