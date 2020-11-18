package by.zercomp.application.model.dao.impl;

import by.zercomp.application.model.dao.GenericDao;
import by.zercomp.application.model.dao.ProductDao;
import by.zercomp.application.model.dao.builder.impl.ProductBuilder;
import by.zercomp.application.model.entity.Brand;
import by.zercomp.application.model.entity.Category;
import by.zercomp.application.model.entity.Product;
import by.zercomp.application.model.exception.DaoException;

import java.util.List;
import java.util.Optional;

public class ProductDaoImpl extends GenericDao<Product> implements ProductDao {

    private static final String ADD_PRODUCT = "INSERT INTO products(product_id, name, category_id, " +
            "description, price, brand_id, quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String FIND_BY_ID = "SELECT product_id, products.name, products.category_id, " +
            "products.description, price, products.brand_id, quantity, " +
            "brands.brand_name, category_name, category_desc FROM products " +
            "JOIN brands ON products.brand_id = brands.brand_id " +
            "JOIN categories ON products.category_id = categories.category_id WHERE product_id = ?";
    private static final String FIND_BY_CATEGORY = "SELECT product_id, products.name, products.category_id, " +
            "products.description, price, products.brand_id, quantity, " +
            "brands.brand_name, category_name, category_desc FROM products " +
            "JOIN brands ON products.brand_id = brands.brand_id " +
            "JOIN categories ON products.category_id = categories.category_id WHERE products.category_id = ?";
    private static final String FIND_BY_BRAND = "SELECT product_id, products.name, products.category_id, " +
            "products.description, price, products.brand_id, quantity, " +
            "brands.brand_name, category_name, category_desc FROM products " +
            "JOIN brands ON products.brand_id = brands.brand_id " +
            "JOIN categories ON products.category_id = categories.category_id WHERE products.brand_id = ?";

    public ProductDaoImpl() {
        super(new ProductBuilder());
    }

    @Override
    public void addProduct(Product product) throws DaoException {
        executeUpdate(ADD_PRODUCT, product.getId(), product.getName(), product.getCategory().getId(),
                product.getDescription(), product.getPrice(), product.getBrand().getId(), product.getQuantity());
    }

    @Override
    public Product removeProduct(long id) throws DaoException {
        return null;
    }

    @Override
    public void updateProduct(Product product) throws DaoException {

    }

    @Override
    public Optional<Product> findById(long id) throws DaoException {
        return executeForSingle(FIND_BY_ID, id);
    }

    @Override
    public List<Product> findByCategory(Category category) throws DaoException {
        return executeQuery(FIND_BY_CATEGORY, category.getId());
    }

    @Override
    public List<Product> findByBrand(Brand brand) throws DaoException {
        return executeQuery(FIND_BY_BRAND, brand.getId());
    }

    @Override
    public List<Product> findInPriceRange(int minPrice, int maxPrice) throws DaoException {
        return null;
    }

    @Override
    public void addProductQuantity(long id, int quantity) throws DaoException {

    }

    @Override
    public void subProductQuantity(long id, int quantity) throws DaoException {

    }
}
