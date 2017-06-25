<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <style>
        .starter-template {
            padding: 40px 15px;
            width: 300px;
            margin-left: 41%;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="starter-template">
    <h1>Welcome</h1>
    <form role="form" action="/getPath" method="post">
        <div class="form-group">
        <label for="userPath">Write path there: </label>
        <input type="text" id="userPath" name="userPath" class="form-control" placeholder="C:\\Users\\User_name\\Desktop\\example.txt"/>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Send</button>
    </form>
</div>
</body>
</html>
