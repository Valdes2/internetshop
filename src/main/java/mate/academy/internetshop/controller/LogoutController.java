package mate.academy.internetshop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getSession().invalidate();

        for (Cookie cookie: req.getCookies()) {
            if (cookie.getName().equals("MATE")) {
                cookie.setMaxAge(0);
                cookie.setValue(null);
                resp.addCookie(cookie);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}