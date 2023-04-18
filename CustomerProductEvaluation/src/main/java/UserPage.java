import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/UserPage")
public class UserPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Hello from Servlet");
        resp.setContentType("Text/HTML");
        out.println("user page ");
        Session session = FactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        HttpSession se = req.getSession();
       String email = (String) se.getAttribute("email");
      //  List<Customer> customer;
            Query query = session.createQuery("from Customer where email =: email");
            query.setParameter("email",email);
            //customer = query.getResultList();
           Customer customer = (Customer) query.uniqueResult();
            se.setAttribute("customer",customer);
           session.close();





        out.println("<a href='Product.jsp'>Add a Product</a>");
    }
}
