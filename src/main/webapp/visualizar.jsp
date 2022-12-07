<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="pt-br">
  <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Ficha Pet</title>
  </head>
<body>
 <%@page import="java.util.List" %>
 <%@page import="br.com.capy.domain.EntidadeDominio" %>
 <%@page import="br.com.capy.domain.Paciente" %>

 <%
 List<EntidadeDominio> pacienteList = (List<EntidadeDominio>) request.getAttribute("pacienteList");
  Paciente p = null;
  if(pacienteList != null || pacienteList.size() > 0){
    p = (Paciente) pacienteList.get(0);
 %>
 <script>
  function salvarEdicao(id){
    location.href="/miauau/paciente?operacao=ALTERAR&id="+id;
  }
  function excluir(id){
    location.href="/miauau/paciente?operacao=EXCLUIR&id="+id;
  }
  function editar(){
    document.getElementById("btSalvar").style.display = "block";
    document.getElementById("btCancelar").style.display = "block";

    document.getElementById("nomePaciente").disabled            = false;
    document.getElementById("idadePaciente").disabled           = false;
    document.getElementById("pedigriePaciente").disabled        = false;
    document.getElementById("pesoPaciente").disabled            = false;
    document.getElementById("racaPaciente").disabled            = false;
    document.getElementById("tipoPaciente").disabled            = false;
    document.getElementById("portePaciente").disabled           = false;
    document.getElementById("nomeResponsavel").disabled         = false;
    document.getElementById("cpfResponsavel").disabled          = false;
    document.getElementById("logradouroEndereco").disabled      = false;
    document.getElementById("bairroEndereco").disabled          = false;
    document.getElementById("cepEndereco").disabled             = false;
    document.getElementById("complementoEndereco").disabled     = false;
    document.getElementById("numeroEndereco").disabled          = false;
    document.getElementById("cidadeEndereco").disabled          = false;
    document.getElementById("estadoEndereco").disabled          = false;
    document.getElementById("numeroTelefone").disabled          = false;
    document.getElementById("dddTelefone").disabled             = false;
    document.getElementById("temWhatsappTelefone").disabled     = false;

  }
  function travarEdicao(){
    document.getElementById('formDadosPaciente').reset();
    document.getElementById("estadoEndereco").value = "<%=p.getResponsavel().getEndereco().getCidade().getEstado().getNome()%>"
    document.getElementById("tipoPaciente").value = "<%=p.getRaca().getAnimal().toString()%>"
    document.getElementById("portePaciente").value = "<%=p.getRaca().getPorte().toString()%>"
    document.getElementById("temWhatsappTelefone").checked = <%=p.getResponsavel().getTelefone().isWhatsappp()%>;

    document.getElementById("btSalvar").style.display = "none";
    document.getElementById("btCancelar").style.display = "none";

    document.getElementById("nomePaciente").disabled            = true;
    document.getElementById("idadePaciente").disabled           = true;
    document.getElementById("pedigriePaciente").disabled        = true;
    document.getElementById("pesoPaciente").disabled            = true;
    document.getElementById("racaPaciente").disabled            = true;
    document.getElementById("tipoPaciente").disabled            = true;
    document.getElementById("portePaciente").disabled           = true;
    document.getElementById("nomeResponsavel").disabled         = true;
    document.getElementById("cpfResponsavel").disabled          = true;
    document.getElementById("logradouroEndereco").disabled      = true;
    document.getElementById("bairroEndereco").disabled          = true;
    document.getElementById("cepEndereco").disabled             = true;
    document.getElementById("complementoEndereco").disabled     = true;
    document.getElementById("numeroEndereco").disabled          = true;
    document.getElementById("cidadeEndereco").disabled          = true;
    document.getElementById("estadoEndereco").disabled          = true;
    document.getElementById("numeroTelefone").disabled          = true;
    document.getElementById("dddTelefone").disabled             = true;
    document.getElementById("temWhatsappTelefone").disabled     = true;


  }

</script>

<form action="/miauau/paciente?operacao=ALTERAR" method="post" id="formDadosPaciente">
  <input type="hidden" name="id" id="id" value="<%=p.getId()%>" readonly>
  <section>
    <h2>Paciente</h2>

    <label for="nomePaciente">nome</label>
    <input type="text" name="nomePaciente" id="nomePaciente" value="<%=p.getNome()%>">
    <br>
    <label for="idadePaciente">idade</label>
    <input type="text" name="idadePaciente" id="idadePaciente" value="<%=p.getIdade()%>">
    <br>
    <label for="pedigriePaciente">pedigrie</label>
    <input type="text" name="pedigriePaciente" id="pedigriePaciente" value="<%=p.getPedigrie()%>">
    <br>
    <label for="pesoPaciente">peso</label>
    <input type="text" name="pesoPaciente" id="pesoPaciente" value="<%=p.getPeso()%>">
    <br>
    <label for="tipoPaciente">Tipo Animal</label>
    <select name="tipoPaciente" id="tipoPaciente">
      <option value="CACHORRO">Cachorro</option>
      <option value="GATO">Gato</option>
    </select> 
    <br>
    <label for="racaPaciente">raca</label>
    <input type="text" name="racaPaciente" id="racaPaciente" value="<%=p.getRaca().getNome()%>">
    <br>
    <label for="portePaciente">porte</label>
    <select name="portePaciente" id="portePaciente">
      <option value="PEQUENO">Pequeno</option>
      <option value="MEDIO">Médio</option>
      <option value="GRANDE">Grande</option>
    </select>
  </section>
  <section>
    <h2>Responsavel</h2>
    <label for="nomeResponsavel">Nome</label>
    <input type="text" name="nomeResponsavel" id="nomeResponsavel" value="<%=p.getResponsavel().getNome()%>">
    <br>
    <label for="cpfResponsavel">CPF</label>
    <input type="text" name="cpfResponsavel" id="cpfResponsavel" value="<%=p.getResponsavel().getCpf()%>">
  </section>
  <section>
    <h2>Endereco</h2>
    <label for="logradouroEndereco">logradouro</label>
    <input type="text" name="logradouroEndereco" id="logradouroEndereco" value="<%=p.getResponsavel().getEndereco().getLogradouro()%>">
    <br>
    <label for="bairroEndereco">bairro</label>
    <input type="text" name="bairroEndereco" id="bairroEndereco" value="<%=p.getResponsavel().getEndereco().getBairro()%>">
    <br>
    <label for="cepEndereco">cep</label>
    <input type="text" name="cepEndereco" id="cepEndereco" value="<%=p.getResponsavel().getEndereco().getCep()%>">
    <br>
    <label for="complementoEndereco">complemento</label>
    <input type="text" name="complementoEndereco" id="complementoEndereco" value="<%=p.getResponsavel().getEndereco().getComplemento()%>">
    <br>
    <label for="numeroEndereco">numero</label>
    <input type="text" name="numeroEndereco" id="numeroEndereco" value="<%=p.getResponsavel().getEndereco().getNumero()%>">
    <br>
    <label for="cidadeEndereco">cidade</label>
    <input type="text" name="cidadeEndereco" id="cidadeEndereco" value="<%=p.getResponsavel().getEndereco().getCidade().getNome()%>">
    <br>
    <label for="estadoEndereco">estado</label>
    
    <select style="width: 100px;" name="estadoEndereco" id="estadoEndereco">
      <br>
      <option value="AC">AC</option>
      <option value="AL">AL</option>
      <option value="AP">AP</option>
      <option value="AM">AM</option>
      <option value="BA">BA</option>
      <option value="CE">CE</option>
      <option value="DF">DF</option>
      <option value="ES">ES</option>
      <option value="GO">GO</option>
      <option value="MA">MA</option>
      <option value="MT">MT</option>
      <option value="MS">MS</option>
      <option value="MG">MG</option>
      <option value="PA">PA</option>
      <option value="PB">PB</option>
      <option value="PR">PR</option>
      <option value="PE">PE</option>
      <option value="PI">PI</option>
      <option value="RJ">RJ</option>
      <option value="RN">RN</option>
      <option value="RS">RS</option>
      <option value="RO">RO</option>
      <option value="RR">RR</option>
      <option value="SC">SC</option>
      <option value="SP">SP</option>
      <option value="SE">SE</option>
      <option value="TO">TO</option>
    </select>

  </section>
  <section>
    <h2>Telefone</h2>
    <label for="numeroTelefone">Numero</label>
    <input type="text" name="numeroTelefone" id="numeroTelefone" value="<%=p.getResponsavel().getTelefone().getNumero()%>">
    <br>
    <label for="dddTelefone">DDD</label>
    <input type="text" name="dddTelefone" id="dddTelefone" value="<%=p.getResponsavel().getTelefone().getDdd()%>">
    <br>
    <label for="temWhatsappTelefone">WhatsApp?</label>
    <input id="temWhatsappTelefone" type="checkbox" name="temWhatsappTelefone" value="true">
  </section>
  <section>
    <button id="btSalvar" style="display: none;" type="submit" form="formDadosPaciente" >Salvar Edição</button>
    <button id="btCancelar" type="button" onclick="travarEdicao()">Cancelar</button>
  </section>
</form>
<br>
<section>
  <button onclick="editar()">Editar</button>
  <button onclick="excluir(<%=p.getId()%>)">Excluir</button>
  <button onclick="location.href='/miauau/paciente';">Voltar</button>
</section>
<script>
  travarEdicao()
</script>


<%
}else{
%>
<p>Aparentemente houve um erro de carregamento <a href="/miauau/paciente?operacao=CONSULTAR">clique aqui</a> para voltar a pagina inicial</p>
<%
  }
%>

</body>
</html>
