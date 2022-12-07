<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="pt-br">
  <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Visualizar Pets</title>
  </head>
<body>
 <%@page import="java.util.List" %>
 <%@page import="br.com.capy.domain.EntidadeDominio" %>
 <%@page import="br.com.capy.domain.Paciente" %>

<table>
  <thead>
    <tr>
      <th>Nome</th>
      <th>Idade</th>
      <th>Pedigrie</th>
      <th>Peso</th>
      <th>Animal</th>
      <th>Raça</th>
      <th>Porte</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <%
      List<EntidadeDominio> pacienteList = (List<EntidadeDominio>) request.getAttribute("pacienteList");
      if(pacienteList != null){
          for(EntidadeDominio entidade : pacienteList){
              Paciente paciente = (Paciente) entidade;
    %>
    <tr>
      <td><%=paciente.getNome()%></td>
      <td><%=paciente.getIdade()%></td>
      <td><%=paciente.getPedigrie()%></td>
      <td><%=paciente.getPeso()%></td>
      <td><%=paciente.getRaca().getAnimal().toString()%></td>
      <td><%=paciente.getRaca().getNome()%></td>
      <td><%=paciente.getRaca().getPorte().toString()%></td>
      <td><input type="button" value="Vizualizar" onclick="visualizar(<%=paciente.getId()%>)"></td>
    </tr>
    <%}}%>
  </tbody>
</table>
<button onclick="irParaCadastro()">Cadastrar</button>
<script>
  function visualizar(id){
    location.href="/miauau/paciente?operacao=CONSULTAR&id="+id;
  }
  function irParaCadastro(){
    location.href="/miauau/paciente/cadastrar";
  }
</script>

</body>
</html>
