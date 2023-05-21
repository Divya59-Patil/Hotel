<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login here</h1>

    <div class="container">
        <div style="color: red; ">${errorMessage}</div>
        <form method="post" action="/login">
        Username : <label>
            <input type="text" name="username" />
        </label><br>
        Password : <label>
            <input type="password" name="password" />
        </label>
            <br>
        <input type="submit" />
       </form>
</body>
</html>