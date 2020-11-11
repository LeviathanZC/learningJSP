package by.zercomp.application.model.dao;

import by.zercomp.application.model.entity.Identifiable;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IdentifiableBuilder<T extends Identifiable> {
    T build(ResultSet resultSet) throws SQLException;
}
