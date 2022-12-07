<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="assets/veterinario.png">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/update.css">
    <link rel="stylesheet" href="css/read.css">
    <title>MiauAu - Consultar</title>
</head>
<body>
    <header>
        <nav>
            <ul>
                <li>
                    <a href="index.html">
                        <ion-icon name="duplicate-outline"></ion-icon>
                        <span class="menu-option">Cadastrar</span>
                    </a>
                </li>
                <li>
                    <a href="read.html">
                        <ion-icon name="search-outline"></ion-icon>
                        <span class="menu-option">Consultar</span>
                    </a>
                </li>
                <li>
                    <a href="update.html">
                        <ion-icon name="create-outline"></ion-icon>
                        <span class="menu-option">Atualizar</span>
                    </a>
                </li>
                <li>
                    <a href="delete.html">
                        <ion-icon name="trash-outline"></ion-icon>
                        <span class="menu-option">Excluir</span>
                    </a>
                </li>
                <li>
                    <a href="login.html">
                        <ion-icon name="log-out-outline"></ion-icon>
                        <span class="menu-option">Sair</span>
                    </a>
                </li>
            </ul>
        </nav>
    </header>

    <script>
        function showOption(element) {

            var linha = element.parentNode.parentNode.rowIndex

            // código que pega o indice da lista e ajustas os valores nos campos da sobreposição

            var dados = [] //Tabela com dados dos pacientes
            <c:forEach items="${pacienteList}" var="paciente">
                var arr = [];
                arr.push("<c:out value="${paciente.getNome()}" />");
                arr.push("<c:out value="${paciente.getPeso()}" />");
                arr.push("<c:out value="${paciente.getResponsavel().getEndereco().getCidade().getEstado().getNome()}" />");
                arr.push("<c:out value="${paciente.getRaca().getAnimal().toString()}" />");
                arr.push("<c:out value="${paciente.getRaca().getPorte().toString()}" />");
                arr.push("<c:out value="${paciente.getRaca().getNome()}" />");
                list.push(arr);
            </c:forEach>

            dados[1] = ["gato","medio","Jorge"]
            dados[2] = ["gato","medio","Amanda"]
            dados[3] = ["gato","medio","Emily"]

            //Alterar valor dos campos na sobreposição
            document.getElementById("idPaciente").value             = dados[linha][0];
            document.getElementById("tipoPaciente").value           = dados[linha][1];
            document.getElementById("portePaciente").value          = dados[linha][2];
            document.getElementById("nomePaciente").value           = dados[linha][3];
            document.getElementById("idadePaciente").value          = dados[linha][4];
            document.getElementById("peso").value                   = dados[linha][5];
            document.getElementById("racaPaciente").value           = dados[linha][6];
            document.getElementById("pedigriePaciente").value       = dados[linha][7];
            document.getElementById("nomeResonsavel").value         = dados[linha][8];
            document.getElementById("cpfResponsavel").value         = dados[linha][9];
            document.getElementById("dddTelefone").value            = dados[linha][10];
            document.getElementById("numeroTelefone").value         = dados[linha][11];
            document.getElementById("temWhatsapp").value            = dados[linha][12];
            document.getElementById("CEPEndereco").value            = dados[linha][13];
            document.getElementById("logradouroEndereco").value     = dados[linha][14];
            document.getElementById("comlementoEndereco	").value    = dados[linha][15];
            document.getElementById("bairroEndereco").value         = dados[linha][16];
            document.getElementById("numeroEndereco").value         = dados[linha][17];
            document.getElementById("cidade").value                 = dados[linha][18];
            document.getElementById("estado").value                 = dados[linha][19];


        }
    </script>

    <div class="fornecedores-container">
        <div class="cadastro-user"><h2>Consultar Pets</h2></div>
        <div class="fornecedores-table">
            <table>
                <tr>
                    <th>Nome</th>
                    <th>Raça</th>    
                    <th>Peso</th>
                    <th>Responsável</th>
                    <th>Cidade</th>
                    <th>Contato WhatsApp</th>
                    <th></th>
                </tr>

                <tr class="fornecedor">
                    <td>Jorge</td>
                    <td>Vira lata</td>
                    <td>20,00 kg</td>
                    <td>Beatriz</td>
                    <td>Mogi das Cruzes</td>
                    <td>11 965764649</td>
                    <td><input type="button" value="" onclick="showOption(this)"></td>
                </tr>

                <tr class="fornecedor">
                    <td>Lidinha</td>
                    <td>Vira lata caramelo</td>
                    <td>22,00 kg</td>
                    <td>Beatriz</td>
                    <td>Mogi das Cruzes</td>
                    <td>11 965764649</td>
                    <td><input type="button" value="" onclick="showOption(this)"></td>
                </tr>

                <tr class="fornecedor">
                    <td>Johnny</td>
                    <td>Golden Retriever</td>
                    <td>45,00 kg</td>
                    <td>Fernando</td>
                    <td>Poá</td>
                    <td>11 940028922</td>
                    <td><input type="button" value="" onclick="showOption(this)"></td>
                </tr>

            </table>
        </div>
    </div>

    <div class="modal" id="modal">
        <div class="form-container">
            <form action="">
                <div class="form-sections">
                    <input type="hidden" id="idPaciente">  
                    <section>
                        <div class="close-button">
                            <h2>Consultar Pet</h2>
                            <ion-icon name="close-circle"></ion-icon>
                        </div>
                        
                        <div><label style="
                            width: 420px;" for="">Tipo do Animal</label>
                            <select style="
                            width: 678px;
                            height: 30px;
                            border-radius: 5px;
                            font-size: 14px;
                            padding: 5px;" id="tipoPaciente" name="tipoPaciente">
                                <option value="cachorro">Cachorro</option>
                                <option value="gato">Gato</option>
                            </select><br>
                        </div>    
                        <div><label style="
                            width: 420px;" for="">Porte</label>
                            <se lect style="
                            width: 678px;
                            height: 30px;
                            border-radius: 5px;
                            font-size: 14px;
                            padding: 5px;" id="portePaciente" name="portePaciente">
                                <option value="pequeno">Pequeno</option>
                                <option value="medio">Médio</option>
                                <option value="grande">Grande</option>
                            </select><br>
                        </div>    
                        <div><label for="">Nome</label><input type="text" placeholder="" id="nomePaciente" name="nomePaciente"></div>   
                        <div><label for="">Idade</label><input type="number" placeholder="" id="idadePaciente" name="idadePaciente"></div> 
                        <div><label for="">Peso</label><input type="number" placeholder="" id="peso" name="peso"><br></div>
                        <div><label for="">Raça</label><input type="text" placeholder="" id="racaPaciente" name="racaPaciente"><br></div>                    
                        <div><label for="">Pedigrie</label><input type="number" placeholder="" id="pedigriePaciente" name="pedigriePaciente"></div>
                        
                                     
                                           
                    </section>
                    
                    <section>
                        <h2>Responsável</h2>
                        <div><label for="">Nome</label><input type="text" placeholder="" id="nomeResonsavel" name="nomeResonsavel"><br></div>              
                        <div><label for="">CPF</label><input type="number" placeholder="" id="cpfResponsavel" name="cpfResponsavel"><br></div>              
                    </section>
            
                    <section>
                        <h2>Contato</h2>
                        <div><label for="">DDD</label><input id="dddTelefone" type="number" placeholder="011" name="dddTelefone"><br></div>
                        <div><label for="">Número</label><input id="numeroTelefone" type="number" placeholder="" name="numeroTelefone"><br></div>
                        <div style="display: flex"><input type="checkbox"  id="temWhatsapp" name="temWhatsapp" style="width: 25px;"><label for="" style="
                            width: 240px;">É WhatsApp?</label></div>   
                    </section>

                    
                    <section> 
                        <h2>Endereço</h2>
                        <div><label for="">CEP</label><input type="number" placeholder="0000-000" id="CEPEndereco" name="CEPEndereco"></div>
                        <div><label for="">Logradouro</label><input type="text" placeholder="Rua, Avenida" id="logradouroEndereco" name="logradouroEndereco"></div>
                        <div><label for="">Complemento</label><input type="text" placeholder="De frente para o Makro" id="comlementoEndereco" name="comlementoEndereco"><br></div>
                        <div><label for="">Bairro</label><input type="text" placeholder="Centro, Jardim Santista" id="bairroEndereco" name="bairroEndereco"></div>
                        <div><label for="">Número</label><input type="text" placeholder="161, S/N" id="numeroEndereco" name="numeroEndereco"><br></div>
                        <div><label for="">Cidade</label><input type="text" placeholder="Mogi das cruzes, Poá" id="cidade" name="cidade"><br></div>
                        <div><label for="">Estado</label><input type="text" placeholder="UF" id="estado" itemid="estado" name="estado"></div>
                    </section>
                </div>
                <!-- <input type="button" value="Editar Fornecedor"> -->
            </form>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

    <script>
        $(".fornecedor").click(function(){
            let modal = document.getElementById('modal');
            modal.style.display = "block";
        });
        $(".close-button").click(function(){
            let modal = document.getElementById('modal');
            modal.style.display = "none";
        })

    </script> 

    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>