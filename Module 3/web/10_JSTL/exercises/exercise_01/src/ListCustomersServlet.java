import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListCustomersServlet", urlPatterns = "")
public class ListCustomersServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customers> listOfCustomer=new ArrayList<>();
        listOfCustomer.add(new Customers("Tuấn","21/10/1990","Đà Nẵng","pictures/cd-vietnam-1-15784677914401959656399.jpg"));
        listOfCustomer.add(new Customers("Toàn","28/11/1997","Đà Nẵng", "pictures/cd-vietnam-3-15784677914421267248297.jpg"));
        listOfCustomer.add(new Customers("Thảo","15/7/1993","Đà Nẵng","pictures/cd-vietnam-11-1578467791452186328547.jpg"));

        request.setAttribute("customers",listOfCustomer);
        request.getRequestDispatcher("list_customers.jsp").forward(request,response);
    }
}
