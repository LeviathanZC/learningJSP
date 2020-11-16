package by.zercomp.application.model.dao.builder.impl;

import by.zercomp.application.model.dao.ColumnName;
import by.zercomp.application.model.dao.builder.CommonBuilder;
import by.zercomp.application.model.entity.Brand;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandBuilder implements CommonBuilder<Brand> {

    @Override
    public Brand build(ResultSet resultSet) throws SQLException {
        Brand brand = new Brand();
        brand.setId(resultSet.getLong(ColumnName.BRAND_ID));
        brand.setName(resultSet.getString(ColumnName.BRAND_NAME));
        return brand;
    }
}
