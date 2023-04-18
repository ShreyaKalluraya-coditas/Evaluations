import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SaveProduct")
public class SaveProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String qty = req.getParameter("qty");
        Session session = FactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();




        HttpSession se = req.getSession();
        Customer customer = (Customer) se.getAttribute("customer");
        Product product = new Product(name, price, qty, customer);
        customer.getProduct().add(product);
        product.setCustomer(customer);
        session.saveOrUpdate(customer);
        tx.commit();
        session.close();
        out.println("Product added successfully!");
    }
}



