package by.zercomp.application.model.dao.builder.impl;

import by.zercomp.application.model.dao.ColumnName;
import by.zercomp.application.model.dao.builder.CommonBuilder;
import by.zercomp.application.model.entity.Role;
import by.zercomp.application.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class UserBuilder implements CommonBuilder<User> {
    @Override
    public User build(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong(ColumnName.USER_ID));
        user.setRole(Role.values()[resultSet.getInt(ColumnName.ROLE)]);
        user.setLogin(resultSet.getString(ColumnName.LOGIN));
        user.setEmail(resultSet.getString(ColumnName.EMAIL));
        user.setFirstName(resultSet.getString(ColumnName.FIRST_NAME));
        user.setLastName(resultSet.getString(ColumnName.LAST_NAME));
        user.setBirth(LocalDate.parse(resultSet.getDate(ColumnName.BIRTH_DATE).toString()));
        return user;
    }
}
