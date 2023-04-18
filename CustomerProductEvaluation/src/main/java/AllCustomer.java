import org.hibernate.Session;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/AllCustomer")
public class AllCustomer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Hello from Servlet");
        Session s = FactoryProvider.getSessionFactory().openSession();
        Query q = s.createQuery("from Customer");
        List<Customer> list = q.getResultList();
        req.setAttribute("listCustomer",list);
        req.getRequestDispatcher("AllCustomer.jsp").forward(req,resp);
        s.close();
    }
}
