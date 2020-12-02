package by.zercomp.application.model.service;

import by.zercomp.application.model.entity.Brand;
import by.zercomp.application.model.entity.Category;
import by.zercomp.application.model.entity.Product;
import by.zercomp.application.model.exception.ServiceException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(long id) throws ServiceException;

    List<Product> findByBrand(Brand brand) throws ServiceException;

    List<Product> findByCategory(Category category) throws ServiceException;

    void add(Map<String, String> productParams) throws ServiceException;

    void update(Product product, int id) throws ServiceException;

    List<Product> findProductInRangeOfPrice(int min, int max) throws ServiceException;



}
