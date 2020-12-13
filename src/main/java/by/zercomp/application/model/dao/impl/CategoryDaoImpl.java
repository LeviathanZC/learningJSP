package by.zercomp.application.model.dao.impl;

import by.zercomp.application.model.dao.CategoryDao;
import by.zercomp.application.model.dao.GenericDao;
import by.zercomp.application.model.dao.builder.impl.CategoryBuilder;
import by.zercomp.application.model.entity.Category;
import by.zercomp.application.model.exception.DaoException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static by.zercomp.application.controller.RequestParam.*;

public class CategoryDaoImpl extends GenericDao<Category> implements CategoryDao {

    private static final String ADD_CATEGORY = "INSERT INTO categories(category_id, " +
            "category_name, category_desc) VALUES (?, ?, ?)";
    private static final String REMOVE_CATEGORY = "DELETE FROM categories WHERE category_id = ?";

    public CategoryDaoImpl() { super(new CategoryBuilder()); }

    @Override
    public void add(Map<String, Object> categoryParams) throws DaoException {
        executeUpdate(ADD_CATEGORY, (long)categoryParams.get(CATEGORY_ID),
                (String)categoryParams.get(CATEGORY_NAME),
                (String)categoryParams.get(CATEGORY_DESC));
    }

    @Override
    public void remove(long id) throws DaoException {
        executeUpdate(REMOVE_CATEGORY, id);
    }

    @Override
    public void update(long id, Category category) throws DaoException {

    }

    @Override
    public Optional<Category> findById(long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<Category> findAll() throws DaoException {
        return null;
    }
}
