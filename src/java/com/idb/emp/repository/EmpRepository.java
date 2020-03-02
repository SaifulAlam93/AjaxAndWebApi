/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idb.emp.repository;

import com.idb.emp.jdbcutill.DBConnection;
import com.idb.emp.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bilt
 */
public class EmpRepository {

    private static EmpRepository instance = new EmpRepository();

    public static EmpRepository getInstance() {
        return instance;
    }

    public boolean addEmp(Employee emp) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = DBConnection.getConnection();
            stmt = con.prepareStatement("insert into emp (name,address,age) values (?,?,?)");
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getAddress());
            stmt.setInt(3, emp.getAge());
            int noOfefectedRows = stmt.executeUpdate();
            System.out.println("noOfefectedRows : " + noOfefectedRows);

            if (noOfefectedRows > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(con, stmt, null);
        }

        return false;
    }

    public List<Employee> getEmployees() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Employee> empList = null;
        try {
            con = DBConnection.getConnection();
            stmt = con.prepareStatement("select * from emp");
            rs = stmt.executeQuery();
            empList = getEmpListFromResultSet(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(con, stmt, null);
        }
        return empList;
    }

    private List<Employee> getEmpListFromResultSet(ResultSet rs) throws Exception {
        List<Employee> empList = new ArrayList<>();
        while (rs.next()) {
            Employee emp = getEmployeeFromResultSet(rs);
            empList.add(emp);
        }
        return empList;
    }

    private Employee getEmployeeFromResultSet(ResultSet rs) throws Exception {
        Employee emp = new Employee();
        emp.setId(rs.getInt("id"));
        emp.setName(rs.getString("name"));
        emp.setAddress(rs.getString("address"));
        emp.setAge(rs.getInt("age"));
        return emp;
    }
}
