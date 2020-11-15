package by.zercomp.application.model.dao.builder.impl;

import by.zercomp.application.model.dao.ColumnName;
import by.zercomp.application.model.dao.builder.GeneralBuilder;
import by.zercomp.application.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder implements GeneralBuilder<User> {
    @Override
    public User build(ResultSet resultSet) throws SQLException {
        User user = new User();
        Long id = resultSet.getLong(ColumnName.USER_ID);

    }
}
