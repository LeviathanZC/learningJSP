package by.zercomp.application.model.dao.builder.impl;

import by.zercomp.application.model.dao.ColumnName;
import by.zercomp.application.model.dao.builder.CommonBuilder;
import by.zercomp.application.model.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductBuilder implements CommonBuilder<Product> {
    @Override
    public Product build(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getLong(ColumnName.PRODUCT_ID));
        product.setName(resultSet.getString(ColumnName.PRODUCT_NAME));
        product.setDescription(resultSet.getString(ColumnName.DESCRIPTION));
        product.setPrice(resultSet.getLong(ColumnName.PRICE));
        product.setCategory(new CategoryBuilder().build(resultSet));
        product.setQuantity(resultSet.getInt(ColumnName.QUANTITY));
        product.setBrand(new BrandBuilder().build(resultSet));
        return product;
    }
}
