package by.zercomp.application;

import by.zercomp.application.model.dao.impl.ProductDaoImpl;
import by.zercomp.application.model.entity.Brand;
import by.zercomp.application.model.entity.Category;
import by.zercomp.application.model.entity.Product;
import by.zercomp.application.model.exception.DaoException;

public class MainController {
    public static void main(String[] args) throws DaoException {
        /*UserDao dao = DaoFactory.getInstance().getUserDao();
        User user = new User();
        user.setId(2L);
        user.setRole(Role.VIP);
        user.setLogin("login");
        user.setEmail("email@maul");
        user.setFirstName("XER");
        user.setLastName("S_GORY");
        user.setBirth(LocalDate.now());
        dao.updatePassword("varapay@gmail.com", "IvanVorobey");
        System.out.println(new ProductDaoImpl().findById(1l));*/
        /*UserService service = new UserServiceImpl();
        System.out.println(service.signIn("varapay", "IvanVorobey"));*/
        Brand brand = new Brand();
        brand.setId(1l);
        Category category = new Category();
        category.setId(1l);
        Product product = new Product();
        product.setId(3l);
        product.setName("test");
        product.setQuantity(1);
        product.setPrice(1);
        product.setDescription("testDescription");
        product.setBrand(brand);
        product.setCategory(category);
        new ProductDaoImpl().addProduct(product);
    }
}
