package by.zercomp.application;

import by.zercomp.application.model.exception.DaoException;
import by.zercomp.application.model.service.UserService;
import by.zercomp.application.model.service.impl.UserServiceImpl;

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
        UserService service = new UserServiceImpl();
        System.out.println(service.signIn("varapay", "IvanVorobey"));
    }
}
