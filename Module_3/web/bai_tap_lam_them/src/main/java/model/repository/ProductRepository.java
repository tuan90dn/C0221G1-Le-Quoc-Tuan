package model.repository;

import model.bean.Category;
import model.bean.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final String SELECT_ALL_PRODUCT = "select * from product order by product_name;";
    private static final String SELECT_PRODUCT_BY_ID = "select * from product where product_ID=?;";
    private static final String INSERT_PRODUCT_SQL = "insert into product (product_name,product_price,product_quantity,product_color,product_description,category_Id) values (?,?,?,?,?,?);";
    private static final String UPDATE_PRODUCT_SQL = "update product set product_name=?,product_price=?,product_quantity=?,product_color=?,product_description=?,category_Id=? where product_ID=?;";
    private static final String DELETE_PRODUCT_SQL = "delete from product where product_ID = ?;";
    private static final String SELECT_PRODUCT_BY_NAME = "select * from product where product_name like ?;";
    BaseRepository baseRepository = new BaseRepository();
    CategoryRepository categoryRepository =new CategoryRepository();
    public List<Product> selectAllProducts() {
        Connection connection = baseRepository.connectDataBase();
        List<Product> products = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productId=rs.getInt("product_ID");
                String productName = rs.getString("product_name");
                String productPrice = rs.getString("product_price");
                int productQuantity = rs.getInt("product_quantity");
                String productColor = rs.getString("product_color");
                String productDescription = rs.getString("product_description");
                Category category =categoryRepository.selectCategoryByID(rs.getInt("category_Id"));
                products.add(new Product(productId,productName,productPrice,productQuantity,productColor,productDescription,category));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }
    public Product selectProductByID(int productId) {
        Product product = null;

        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1,productId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String productName = rs.getString("product_name");
                String productPrice = rs.getString("product_price");
                int productQuantity = rs.getInt("product_quantity");
                String productColor = rs.getString("product_color");
                String productDescription = rs.getString("product_description");
                Category category =categoryRepository.selectCategoryByID(rs.getInt("category_Id"));
                product =new Product(productId,productName,productPrice,productQuantity,productColor,productDescription,category);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }
    public List<Product> selectProductByName(String name) {
        List<Product> listProduct =new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME);
            preparedStatement.setString(1, "%"+name+"%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productId=rs.getInt("product_ID");
                String productName = rs.getString("product_name");
                String productPrice = rs.getString("product_price");
                int productQuantity = rs.getInt("product_quantity");
                String productColor = rs.getString("product_color");
                String productDescription = rs.getString("product_description");
                Category category =categoryRepository.selectCategoryByID(rs.getInt("category_Id"));
                listProduct.add(new Product(productId,productName,productPrice,productQuantity,productColor,productDescription,category));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return listProduct;
    }
    public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCT_SQL);
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getProductPrice());
            preparedStatement.setInt(3, product.getProductQuantity());
            preparedStatement.setString(4, product.getProductColor());
            preparedStatement.setString(5, product.getProductDescription());
            preparedStatement.setInt(6, product.getCategoryID().categoryID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    public boolean updateProduct (Product product) throws SQLException {
        boolean rowUpdated;
        Connection connection = baseRepository.connectDataBase();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getProductPrice());
            preparedStatement.setInt(3, product.getProductQuantity());
            preparedStatement.setString(4, product.getProductColor());
            preparedStatement.setString(5, product.getProductDescription());
            preparedStatement.setInt(6, product.getCategoryID().categoryID);
            preparedStatement.setInt(7, product.getProductID());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted;
        Connection connection = baseRepository.connectDataBase();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);)
        {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
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
