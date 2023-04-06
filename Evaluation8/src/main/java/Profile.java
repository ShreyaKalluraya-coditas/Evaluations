import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Profile")
public class Profile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("Text/HTML");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");



        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","Star@123");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users where email = '"+email+"'");

            out.println("<table border=2px;><tr><th>ID</th><th>NAME</th><th>EMAIL</th><th>COUNTRY</th></tr>");

            while(rs.next()){

                out.println("<tr><td>");
                out.println(rs.getInt(1));
                out.println("</td><td>");
                out.println(rs.getString(2));
                out.println("</td><td>");
                out.println(rs.getString(3));
                out.println("</td><td>");
                out.println(rs.getString(4));
                out.println("</td></tr>");

            }
            out.println("</table>");



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }


    }

