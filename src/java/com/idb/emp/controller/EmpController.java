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
@WebServlet(urlPatterns = {"/add-emp"})
public class EmpController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee emp = getEmpInfoFromRequest(req);
        boolean status = EmpService.getInstance().addEmp(emp);
        if (status) {
            resp.sendRedirect("list-emp");
        } else {
            resp.sendRedirect("error.html");
        }
        // TODO LSDFLSDJFLKDJS

    }

    private Employee getEmpInfoFromRequest(HttpServletRequest req) {

        String name = req.getParameter("name");
        String address = req.getParameter("add");
        int age = Integer.parseInt(req.getParameter("age"));

        Employee emp = new Employee();

        emp.setName(name);
        emp.setAddress(address);
        emp.setAge(age);

        return emp;
    }

}
