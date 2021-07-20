package model.service;

import model.bean.User;
import model.repository.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements IUserService {
    UserRepository userRepository=new UserRepository();

    @Override
    public void insertUser(User user) throws SQLException {
        userRepository.insertUser(user);
    }

    @Override
    public User selectUserByID(int id) {
        return userRepository.selectUserByID(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepository.selectAllUsers();
    }

    @Override
    public List<User> selectAllUsersOrDerByName() {
        return userRepository.selectAllUsersOrderByName();
    }

    @Override
    public List<User> searchUserByCountry(String country) {
        return userRepository.selectUserByCountry(country);
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return  userRepository.updateUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        userRepository.insertUserStore(user);
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        userRepository.addUserTransaction(user,permision);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        userRepository.insertUpdateWithoutTransaction();
    }
}
