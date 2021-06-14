package controller;

import model.bean.Category;
import model.bean.Product;
import model.repository.CategoryRepository;
import model.service.ProductServicesImpl;
import model.service.IProductServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductServlet",urlPatterns = {"","/products"})
public class ProductServlet extends HttpServlet {
    IProductServices productServices;
    CategoryRepository categoryRepository =new CategoryRepository();
    public void init(){
        productServices =new ProductServicesImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertProduct(request, response);
                    break;
                case "delete":
                    deleteProduct(request, response);
                    break;
                case "edit":
                    updateProduct(request, response);
                    break;
                case "search":
                    searchProductByName(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "view":
//                    showInformationOfProduct(request, response);
                    break;
                default:
                    listProductOrderByName(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

//    private void showInformationOfProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id=Integer.parseInt(request.getParameter("id"));
//        Product product = productServices.selectProductByID(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/show_information.jsp");
//        request.setAttribute("employee", product);
//        dispatcher.forward(request, response);
//    }

    private void searchProductByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        List<Product> listProduct = productServices.selectProductByName(name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/list_product.jsp");
        request.setAttribute("listProduct", listProduct);
        dispatcher.forward(request, response);
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("delete"));
        productServices.deleteProduct(id);
        response.sendRedirect("/products");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingUser = productServices.selectProductByID(id);
        request.setAttribute("product", existingUser);
        List<Category> categoryList =categoryRepository.selectAllCategorys();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/edit_product.jsp");
        dispatcher.forward(request, response);
    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        Category category =categoryRepository.selectCategoryByID(Integer.parseInt(request.getParameter("category")));

        Product newProduct = new Product(id,name,price,quantity,color,description, category);
        productServices.updateProduct(newProduct);
        response.sendRedirect("/products");
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");

        Category category =categoryRepository.selectCategoryByID(Integer.parseInt(request.getParameter("category")));

        Product newProduct = new Product(name,price,quantity,color,description, category);
        productServices.insertProduct(newProduct);
        response.sendRedirect("/products");
    }
//
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Category> categoryList =categoryRepository.selectAllCategorys();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/create_product.jsp");
        dispatcher.forward(request, response);
    }

    private void listProductOrderByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
        List<Product> listProduct = productServices.selectAllProducts();
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/list_product.jsp");
        dispatcher.forward(request, response);
    }
}
