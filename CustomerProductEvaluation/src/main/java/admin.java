import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin")
public class admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Hello from Admin Servlet");
        resp.setContentType("Text/HTML");
        out.println("<a href='Register.jsp'>Add a User</a>");
        out.println("<a href='AllCustomer'>Show All Customer</a>");
        out.println("<a href='AllProduct'>Show All Products</a>");


    }
}
