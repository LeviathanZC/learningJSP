package by.zercomp.application.model.dao.builder.impl;

import by.zercomp.application.model.dao.ColumnName;
import by.zercomp.application.model.dao.builder.CommonBuilder;
import by.zercomp.application.model.entity.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryBuilder implements CommonBuilder<Category> {
    @Override
    public Category build(ResultSet resultSet) throws SQLException {
        Category category = new Category();
        category.setId(resultSet.getLong(ColumnName.CATEGORY_ID));
        category.setName(resultSet.getString(ColumnName.CATEGORY_NAME));
        category.setDescription(resultSet.getString(ColumnName.CATEGORY_DESCRIPTION));
        return category;
    }
}
