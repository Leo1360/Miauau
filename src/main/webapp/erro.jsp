<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Erro</title>
    </head>
<body>
    <h1>Miauau Petshop Home!</h1>
    
    <p>Erro</p>
    <%=(String) request.getAttribute("msg")%>
    <a href="/miauau/paciente">Volatr a Pagina inicial</a>
</body>
</html>