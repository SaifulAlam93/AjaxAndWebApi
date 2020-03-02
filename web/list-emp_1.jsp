<%@ page import="java.util.List,com.idb.emp.model.Employee,com.idb.emp.service.EmpService" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        
      

        <a href="index.html" > home </a>

        <br/><br/>
        <a href="add-emp-form.html" >Add Employee</a>

        <h1>Employee List</h1>

        <c:set var="Income"   value="${4000*4}"/>  
<c:out value="${Income}"/> 


<c:remove var="Income"/>


<jsp:expression>
pageContext.getAttribute("Income")
</jsp:expression>


        <table border="2" width="4" cellspacing="4" cellpadding="4">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>ADDRESS</th>
                    <th>AGE</th>
                </tr>
            </thead>
            <tbody>

                
                 <c:forEach var="emp" items="${empList}">
      <tr><td><c:out value="${emp.name}"/></td></tr>
    </c:forEach> 
                

                
                

                <%
                    List<Employee> empList = (List<Employee>) request.getAttribute("empList");
                    for (Employee emp : empList) {
                        out.println("   <tr>"
                                + "<td>" + emp.getId() + "</td>"
                                + "<td>" + emp.getName() + "</td>"
                                + "<td>" + emp.getAddress() + "</td>"
                                + "<td>" + emp.getAge() + "</td>"
                                + "</tr>");

                    }

                %>

            </tbody>
        </table>


    </body>
</html>
