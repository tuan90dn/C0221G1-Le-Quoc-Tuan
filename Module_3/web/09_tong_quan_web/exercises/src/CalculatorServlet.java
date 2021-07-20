import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet",value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double listPrice=Double.parseDouble(request.getParameter("price"));
        double discountPercent=Double.parseDouble(request.getParameter("discount"));
        double discountAmount=listPrice*discountPercent*0.01;
        double discountPrice=listPrice-discountAmount;
        request.setAttribute("amountResult",discountAmount);
        request.setAttribute("priceResult",discountPrice);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
