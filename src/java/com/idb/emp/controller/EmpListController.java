/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idb.emp.controller;

import com.idb.emp.model.Employee;
import com.idb.emp.service.EmpService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bilt
 */
@WebServlet(urlPatterns = {"/list-emp"})
public class EmpListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> empList = EmpService.getInstance().getEmployees();
        req.setAttribute("empList", empList);
       // resp.sendRedirect("list-emp.jsp");
        req.getRequestDispatcher("list-emp.jsp").forward(req, resp);
    }
}
