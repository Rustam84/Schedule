<%--
  Created by IntelliJ IDEA.
  User: rshaghivaliev
  Date: 6/14/2018
  Time: 9:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        form {
            border: 3px solid #f1f1f1;
        }

        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            opacity: 0.8;
        }

        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            background-color: #f44336;
        }

        .imgcontainer {
            text-align: center;
            margin: 24px 0 12px 0;
        }

        img.avatar {
            width: 40%;
            border-radius: 50%;
        }

        .container {
            padding: 16px;
        }

        span.psw {
            float: right;
            padding-top: 16px;
        }
        .mainContainer{
            width: 50%;
            margin-right: auto;
            margin-left: auto;
            margin-top: 150px;
        }
    </style>
</head>
<body>
<div class="mainContainer">
    <h2>Форма входа</h2>
    <form method="POST" action="/login" autocomplete="off">
        <div class="container">
            <label for="uname"><b>Логин</b></label>
            <input type="text" placeholder="Введите логин" name="username" id="uname" required>

            <label for="psw"><b>Пароль</b></label>
            <input type="password" placeholder="Введите пароль" name="password" id="psw" required>

            <button type="submit">Войти</button>
        </div>
    </form>
</div>
</body>
</html>
