package by.zercomp.application;

import by.zercomp.application.model.dao.DaoFactory;
import by.zercomp.application.model.dao.UserDao;
import by.zercomp.application.model.entity.Role;
import by.zercomp.application.model.entity.User;
import by.zercomp.application.model.exception.DaoException;

import java.time.LocalDate;

public class MainController {
    public static void main(String[] args) throws DaoException {
        UserDao dao = DaoFactory.getInstance().getUserDao();
        User user = new User();
        user.setId(2L);
        user.setRole(Role.VIP);
        user.setLogin("login");
        user.setEmail("email@maul");
        user.setFirstName("XER");
        user.setLastName("S_GORY");
        user.setBirth(LocalDate.now());
        dao.updatePassword("varapay@gmail.com", "IvanVorobey");
    }
}
