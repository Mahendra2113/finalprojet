<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.highcourt.model.User" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #444;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<%
    List<User> userList = (List<User>) session.getAttribute("suserList");
    if (userList != null && !userList.isEmpty()) {
%>
    <h2 align="center">User Details</h2>
    <table>
        <thead>
            <tr>
                
                <th>Username</th>
                <th>Mobile No</th>
                <th>Email</th>
                <th>Section</th>
                <th>State</th>
                <th>District</th>
                <th>Taluka</th>
            </tr>
        </thead>
        <tbody>
        <%
            for (User x : userList) {
        %>
            <tr>
                <td><%= x.getUsername() %></td>
                
                <td><%= x.getMobileno() %></td>
                <td><%= x.getEmail() %></td>
                <td><%= x.getSectioncode() %></td>
                <td><%= x.getStatecode() %></td>
                <td><%= x.getDistrictcode() %></td>
                <td><%= x.getTalukacode() %></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
<%
    } else {
%>
    <h3 align="center">No user records found.</h3>
<%
    }
%>

</body>
</html>
