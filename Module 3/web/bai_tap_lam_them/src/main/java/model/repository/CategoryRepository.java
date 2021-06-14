package model.repository;

import model.bean.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private static final String SELECT_ALL_CATEGORY = "select * from category;";
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_CATEGORY_BY_ID = "select * from category where category_Id=?;";
    public Category selectCategoryByID(int id) {
        Category category = null;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String categoryName = rs.getString("category_name");
                category =new Category(id,categoryName);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return category;
    }
    public List<Category> selectAllCategorys() {
        Connection connection = baseRepository.connectDataBase();
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int categoryId=rs.getInt("category_Id");
                String categoryName = rs.getString("category_name");
                categories.add(new Category(categoryId,categoryName));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categories;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
