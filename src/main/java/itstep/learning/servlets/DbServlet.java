package itstep.learning.servlets;
//jdbc:mysql://localhost:3308/JAVA_SPU_221

import com.google.inject.Singleton;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //підключення до БД
        //JDBC (~ADO/PDO) - уніфікована технологія доступу
        //підключення - інструкція - результат
        Connection connection = null;
        Driver mySqlDriver = null;
        try {
            mySqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mySqlDriver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/JAVA_SPU_221_LOC?useUnicode=true&characterEncoding=UTF-8", "user_221", "pass_221");
            String sql = "SHOW DATABASES";
            Statement stmt = connection.createStatement(); // analog SqlCommand
            ResultSet res = stmt.executeQuery(sql); // sqlDataReader
            List<String> dataBases = new ArrayList();
            while (res.next()) {
                dataBases.add(res.getString(1)); //!! нумерація у JDBC починається з 1
            }
            request.setAttribute("dataBases", dataBases);
            res.close();
            stmt.close();

        } catch (SQLException ex) {
            request.setAttribute("dbError", ex.getMessage());
        }
        response.setContentType("text/html; charset=UTF-8");
        request.setAttribute("fromServlet", "DbServlet");
        request.setAttribute("ContentPage", "db.jsp");
        request.getRequestDispatcher("WEB-INF/views/_layout.jsp").forward(request, response);
    }

}

