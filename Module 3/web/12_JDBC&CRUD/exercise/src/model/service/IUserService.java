package model.service;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public void insertUser(User user) throws SQLException;

    public User selectUserByID(int id);

    public List<User> selectAllUsers();
    public List<User> selectAllUsersOrDerByName();
    public List<User> searchUserByCountry(String country);

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;
}
