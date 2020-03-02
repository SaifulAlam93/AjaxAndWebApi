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
        <jsp:useBean scope="session" id = "empBean" type="com.idb.emp.model.Employee" beanName= "com.idb.emp.model.Employee" />
            <jsp:setProperty name="empBean" property="*" />  
        <%--<jsp:setProperty name = "empBean"  property = "name"   value = "jamal" />--%>
         ----
         <br/>
         <jsp:getProperty name = "empBean" property = "name" />
         <br/>
         <jsp:getProperty name = "empBean" property = "address" />
    <br/>
    
      <jsp:getProperty name = "empBean" property = "age" />
    <br/>
    
    
    </body>
</html>
