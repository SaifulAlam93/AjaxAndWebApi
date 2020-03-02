<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
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
        
        
<!--        <c :set var="Amount" value="786.970" />  
  
    <fmt :parseNumber var="j" type="number" value="$ {Amount}" />  
        
        -->
        
        <jsp:useBean id = "empBean" class = "com.idb.emp.model.Employee" />
         <jsp:setProperty name = "empBean"  property = "name" 
            value = "Hello JSP..." />
            
         <p>Got message....</p>
         <jsp:getProperty name = "empBean" property = "name" />
        
        
        
        
        
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
                    <tr><td><c:out value="${emp.id}"/></td>
                        <td><c:out value="${emp.name}"/></td>
                        <td><c:out value="${emp.address}"/></td>
                        <td> 
                            <c:if test="${emp.age gt 20}">  
                                <p style="color: red">
                                    
                                    <c:out value="${emp.age}"/> 
                                
                                </p>  
                                </c:if> 
                                <c:if test="${emp.age lt 20}">  
                                <p style="color: green"> <c:out value="${emp.age}"/></p>  
                                </c:if>
                                       <c:if test="${emp.age == 20}">  
                                <p style="color: black"> <c:out value="${emp.age}"/></p>  
                                </c:if>
                        </td>
                    </tr>
                </c:forEach> 
                <%
        //                    List<Employee> empList = (List<Employee>) request.getAttribute("empList");
        //                    for (Employee emp : empList) {
        //                        out.println("   <tr>"
        //                                + "<td>" + emp.getId() + "</td>"
        //                                + "<td>" + emp.getName() + "</td>"
        //                                + "<td>" + emp.getAddress() + "</td>"
        //                                + "<td>" + emp.getAge() + "</td>"
        //                                + "</tr>");
        //
        //                    }

                %>

            </tbody>
        </table>

                
                
                
                
                  <jsp:include page="ex.jsp" />

    </body>
</html>
