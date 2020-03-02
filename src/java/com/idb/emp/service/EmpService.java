/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idb.emp.service;

import com.idb.emp.model.Employee;
import com.idb.emp.repository.EmpRepository;
import java.util.List;

/**
 *
 * @author bilt
 */
public class EmpService {

    private static EmpService instance = new EmpService();

    public static EmpService getInstance() {
        return instance;
    }
    EmpRepository empRepository;

    EmpService() {
        empRepository = EmpRepository.getInstance();
    }

    public boolean addEmp(Employee emp) {

        // do data modification if needed 
        // all locical works should take palce here (if needed)
        boolean status = empRepository.addEmp(emp);
        // either 
//        boolean status=EmpRepository.getInstance().addEmp();
        return status;

    }

    public List<Employee> getEmployees() {
        List<Employee> empList = empRepository.getEmployees();
        return empList;
    }

}
