<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addProduct" method="post">
ProductId : <input type="text" name="productid" readonly="readonly" value="${prods.productid }")><br><br>

ProductName : <input type="text" name="productname" value="${prods.pname }"><br><br>
Cost : <input type="number" name="cost" value="${prods.cost }"><br><br>
Quantity : <input type="number" name="quantity" value="${prods.qty }"><br><br>
<input type="submit" value="addproduct">
 </form></body>
</html>