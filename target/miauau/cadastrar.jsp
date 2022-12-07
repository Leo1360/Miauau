<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar</title>
</head>
<body>
    <form action="/miauau/paciente?operacao=SALVAR" method="post" id="formDadosPaciente">
        <section>
          <h2>Paciente</h2>
      
          <label for="nomePaciente">nome</label>
          <input type="text" name="nomePaciente" id="nomePaciente">
          <br>
          <label for="idadePaciente">idade</label>
          <input type="text" name="idadePaciente" id="idadePaciente">
          <br>
          <label for="pedigriePaciente">pedigrie</label>
          <input type="text" name="pedigriePaciente" id="pedigriePaciente">
          <br>
          <label for="pesoPaciente">peso</label>
          <input type="text" name="pesoPaciente" id="pesoPaciente">
          <br>
          <label for="tipoPaciente">Tipo Animal</label>
          <select name="tipoPaciente" id="tipoPaciente">
            <option value="CACHORRO">Cachorro</option>
            <option value="GATO">Gato</option>
          </select> 
          <br>
          <label for="racaPaciente">raca</label>
          <input type="text" name="racaPaciente" id="racaPaciente">
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
          <input type="text" name="nomeResponsavel" id="nomeResponsavel">
          <br>
          <label for="cpfResponsavel">CPF</label>
          <input type="text" name="cpfResponsavel" id="cpfResponsavel">
        </section>
        <section>
          <h2>Endereco</h2>
          <label for="logradouroEndereco">logradouro</label>
          <input type="text" name="logradouroEndereco" id="logradouroEndereco">
          <br>
          <label for="bairroEndereco">bairro</label>
          <input type="text" name="bairroEndereco" id="bairroEndereco">
          <br>
          <label for="cepEndereco">cep</label>
          <input type="text" name="cepEndereco" id="cepEndereco">
          <br>
          <label for="complementoEndereco">complemento</label>
          <input type="text" name="complementoEndereco" id="complementoEndereco">
          <br>
          <label for="numeroEndereco">numero</label>
          <input type="text" name="numeroEndereco" id="numeroEndereco">
          <br>
          <label for="cidadeEndereco">cidade</label>
          <input type="text" name="cidadeEndereco" id="cidadeEndereco">
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
          <input type="text" name="numeroTelefone" id="numeroTelefone">
          <br>
          <label for="dddTelefone">DDD</label>
          <input type="text" name="dddTelefone" id="dddTelefone">
          <br>
          <label for="temWhatsappTelefone">WhatsApp?</label>
          <input id="temWhatsappTelefone" type="checkbox" name="temWhatsappTelefone" value="true">
        </section>
        <input type="submit" value="Salvar">
      </form>
      <button onclick="location.href='/miauau/paciente';">Voltar</button>
</body>
</html>