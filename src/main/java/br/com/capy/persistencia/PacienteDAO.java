package br.com.capy.persistencia;

import br.com.capy.domain.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import br.com.capy.persistencia.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDAO implements IDao{
    private Connection connection;

    @Override
    public EntidadeDominio save(EntidadeDominio entidadeDominio) {
        PreparedStatement pst = null;
        Paciente paciente = (Paciente) entidadeDominio;
        String sql = "INSERT INTO pacientes (nome, idade, pedigrie, peso, status_registro, raca, porte, nome_responsavel, cpf_esponsavel, logradouro, bairro, cep, complemento, numero, cidade, estado, numeroTelefone, ddd, tem_whatsapp,tipo_animal) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            openConnection();
            //Para capturar os erro e em caso de erro dar o rollback
            this.connection.setAutoCommit(false);

            // Chamando DAOS Dependentes

            //Criando PreparedStatement
            pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //Setando variaveis do PreparedStatement
            Responsavel responsavel = paciente.getResponsavel();
            pst.setString(1, paciente.getNome());	//nome
            pst.setInt(2, paciente.getIdade());		//idade
            pst.setString(3, paciente.getPedigrie());	//pedigrie
            pst.setFloat(4, paciente.getPeso());	//peso
            pst.setBoolean(5, paciente.isAtivo());	//status_registro
            pst.setString(6, paciente.getRaca().getNome());	//raca
            pst.setString(7, paciente.getRaca().getPorte().toString());	//porte
            pst.setString(8, responsavel.getNome());	//nome_responsavel
            pst.setString(9, responsavel.getCpf());	//cpf_esponsavel
            pst.setString(10, responsavel.getEndereco().getLogradouro());	//logradouro
            pst.setString(11, responsavel.getEndereco().getBairro());	//bairro
            pst.setString(12, responsavel.getEndereco().getCep());	//cep
            pst.setString(13, responsavel.getEndereco().getComplemento());	//complemento
            pst.setString(14, responsavel.getEndereco().getNumero());	//numero
            pst.setString(15, responsavel.getEndereco().getCidade().getNome());	//cidade
            pst.setString(16, responsavel.getEndereco().getCidade().getEstado().getNome());	//estado
            pst.setString(17, responsavel.getTelefone().getNumero());	//numero
            pst.setString(18, responsavel.getTelefone().getDdd());	//ddd
            pst.setBoolean(19, responsavel.getTelefone().isWhatsappp());	//tem_whatsapp
            pst.setString(20, paciente.getRaca().getAnimal().toString()); //tipo_animal


            //Executando query
            pst.execute();

            ResultSet rs = pst.getGeneratedKeys();
            int idGerado = 0;
            if (rs.next()) {
                idGerado = rs.getInt(1);
            }
            paciente.setId(idGerado);

            connection.commit();

        } catch (Exception e) {

            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return paciente;
    }

    @Override
    public EntidadeDominio update(EntidadeDominio entidadeDominio) {
        PreparedStatement pst = null;
        Paciente paciente = (Paciente) entidadeDominio;
        String sql = "UPDATE pacientes SET nome=?, idade=?, pedigrie=?, peso=?, status_registro=?, raca=?, porte=?, nome_responsavel=?, cpf_esponsavel=?, logradouro=?, bairro=?, cep=?, complemento=?, numero=?, cidade=?, estado=?, numeroTelefone=?, ddd=?, tem_whatsapp=?, tipo_animal = ? where id=?";

        try {
            openConnection();
            //Para capturar os erro e em caso de erro dar o rollback
            this.connection.setAutoCommit(false);

            // Chamando DAOS Dependentes

            //Criando PreparedStatement
            pst = connection.prepareStatement(sql);

            //Setando variaveis do PreparedStatement
            Responsavel responsavel = paciente.getResponsavel();
            pst.setString(1, paciente.getNome());	//nome
            pst.setInt(2, paciente.getIdade());		//idade
            pst.setString(3, paciente.getPedigrie());	//pedigrie
            pst.setFloat(4, paciente.getPeso());	//peso
            pst.setBoolean(5, paciente.isAtivo());	//status_registro
            pst.setString(6, paciente.getRaca().getNome());	//raca
            pst.setString(7, paciente.getRaca().getPorte().toString());	//porte
            pst.setString(8, responsavel.getNome());	//nome_responsavel
            pst.setString(9, responsavel.getCpf());	//cpf_esponsavel
            pst.setString(10, responsavel.getEndereco().getLogradouro());	//logradouro
            pst.setString(11, responsavel.getEndereco().getBairro());	//bairro
            pst.setString(12, responsavel.getEndereco().getCep());	//cep
            pst.setString(13, responsavel.getEndereco().getComplemento());	//complemento
            pst.setString(14, responsavel.getEndereco().getNumero());	//numero
            pst.setString(15, responsavel.getEndereco().getCidade().getNome());	//cidade
            pst.setString(16, responsavel.getEndereco().getCidade().getEstado().getNome());	//estado
            pst.setString(17, responsavel.getTelefone().getNumero());	//numero
            pst.setString(18, responsavel.getTelefone().getDdd());	//ddd
            pst.setBoolean(19, responsavel.getTelefone().isWhatsappp());	//tem_whatsapp
            pst.setString(20, paciente.getRaca().getAnimal().toString()); //tipo_animal
            pst.setInt(21,paciente.getId());


            //Executando query
            pst.execute();

            this.connection.commit();

        } catch (Exception e) {

            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return paciente;
    }

    @Override
    public void delete(int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM pacientes WHERE id=?";

        try {
            openConnection();
            //Para capturar os erro e em caso de erro dar o rollback
            this.connection.setAutoCommit(false);

            // Chamando DAOS Dependentes

            //Criando PreparedStatement
            pst = connection.prepareStatement(sql);

            //Setando variaveis do PreparedStatement
            pst.setInt(1,id);

            //Executando query
            pst.execute();

            connection.commit();

        } catch (Exception e) {

            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<EntidadeDominio> findAll(EntidadeDominio entidadeDominio) {
        PreparedStatement pst = null;
        List<EntidadeDominio> pacienteList = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";

        try {
            openConnection();

            // Chamando DAOS Dependentes

            //Criando PreparedStatement
            pst = connection.prepareStatement(sql);

            //Setando variaveis do PreparedStatement

            //Executando query
            pst.execute();

            ResultSet rst = pst.getResultSet();
            while(rst.next()){
                int id = rst.getInt("id");
                String nomeResonsavel = rst.getString("nome_responsavel");
                int idadePaciente = rst.getInt("idade");
                String cpfResponsavel = rst.getString("cpf_esponsavel");
                String logradouroEndereco = rst.getString("logradouro");
                String bairroEndereco = rst.getString("bairro");
                String cepEndereco = rst.getString("cep");
                String comlementoEndereco = rst.getString("complemento");
                String numeroEndereco = rst.getString("numero");
                String cidadeStr = rst.getString("cidade");
                String estadoStr = rst.getString("estado");
                String numeroTelefone = rst.getString("numeroTelefone");
                String dddTelefone = rst.getString("ddd");
                String nomePaciente = rst.getString("nome");
                String pedigriePaciente = rst.getString("pedigrie");
                String racaPaciente = rst.getString("raca");
                boolean temWhatsapp = rst.getBoolean("tem_whatsapp");
                Animal tipoPaciente = Animal.valueOf(rst.getString("tipo_animal"));
                Porte portePaciente = Porte.valueOf(rst.getString("porte"));
                float pesoPaciente = rst.getFloat("peso");

                Telefone telefone = new Telefone(numeroTelefone,dddTelefone,temWhatsapp);
                Estado estado = new Estado(estadoStr);
                Cidade cidade = new Cidade(cidadeStr,estado);
                Endereco endereco = new Endereco(logradouroEndereco,bairroEndereco,cepEndereco,comlementoEndereco,numeroEndereco,cidade);
                Responsavel responsavel = new Responsavel(nomeResonsavel,cpfResponsavel,endereco,telefone);
                Raca raca = new Raca(racaPaciente,portePaciente,tipoPaciente);
                Paciente paciente = new Paciente(nomePaciente,idadePaciente,pedigriePaciente,pesoPaciente,true,responsavel,raca);
                paciente.setId(id);
                pacienteList.add(paciente);

            }


        } catch (Exception e) {

            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return pacienteList;
    }

    @Override
    public EntidadeDominio findById(EntidadeDominio entidadeDominio) {
        PreparedStatement pst = null;
        EntidadeDominio entidade = null;
        String sql = "SELECT * FROM pacientes WHERE id=?";
        Paciente paciente = null;

        try {
            openConnection();

            // Chamando DAOS Dependentes

            //Criando PreparedStatement
            pst = connection.prepareStatement(sql);

            //Setando variaveis do PreparedStatement
            System.out.println("Id= " + entidadeDominio.getId());
            pst.setInt(1,entidadeDominio.getId());

            //Executando query
            pst.execute();

            ResultSet rst = pst.getResultSet();
            if(rst.next()){
                int id = rst.getInt("id");
                String nomeResonsavel = rst.getString("nome_responsavel");
                int idadePaciente = rst.getInt("idade");
                String cpfResponsavel = rst.getString("cpf_esponsavel");
                String logradouroEndereco = rst.getString("logradouro");
                String bairroEndereco = rst.getString("bairro");
                String cepEndereco = rst.getString("cep");
                String comlementoEndereco = rst.getString("complemento");
                String numeroEndereco = rst.getString("numero");
                String cidadeStr = rst.getString("cidade");
                String estadoStr = rst.getString("estado");
                String numeroTelefone = rst.getString("numeroTelefone");
                String dddTelefone = rst.getString("ddd");
                String nomePaciente = rst.getString("nome");
                String pedigriePaciente = rst.getString("pedigrie");
                String racaPaciente = rst.getString("raca");
                boolean temWhatsapp = rst.getBoolean("tem_whatsapp");
                Animal tipoPaciente = Animal.valueOf(rst.getString("tipo_animal"));
                Porte portePaciente = Porte.valueOf(rst.getString("porte"));
                float pesoPaciente = rst.getFloat("peso");

                Telefone telefone = new Telefone(numeroTelefone,dddTelefone,temWhatsapp);
                Estado estado = new Estado(estadoStr);
                Cidade cidade = new Cidade(cidadeStr,estado);
                Endereco endereco = new Endereco(logradouroEndereco,bairroEndereco,cepEndereco,comlementoEndereco,numeroEndereco,cidade);
                Responsavel responsavel = new Responsavel(nomeResonsavel,cpfResponsavel,endereco,telefone);
                Raca raca = new Raca(racaPaciente,portePaciente,tipoPaciente);
                paciente = new Paciente(nomePaciente,idadePaciente,pedigriePaciente,pesoPaciente,true,responsavel,raca);
                paciente.setId(id);
            }


        } catch (Exception e) {

            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return paciente;
    }

    public List<Paciente> findByPedigrie(String pedigrie){
        PreparedStatement pst = null;
        List<Paciente> pacienteList = new ArrayList<>();
        String sql = "SELECT * FROM pacientes WHERE pedigrie=?";

        try {
            openConnection();

            // Chamando DAOS Dependentes

            //Criando PreparedStatement
            pst = connection.prepareStatement(sql);

            //Setando variaveis do PreparedStatement
            pst.setString(1,pedigrie);

            //Executando query
            pst.execute();

            ResultSet rst = pst.getResultSet();
            while(rst.next()){
                int id = rst.getInt("id");
                String nomeResonsavel = rst.getString("nome_responsavel");
                int idadePaciente = rst.getInt("idade");
                String cpfResponsavel = rst.getString("cpf_esponsavel");
                String logradouroEndereco = rst.getString("logradouro");
                String bairroEndereco = rst.getString("bairro");
                String cepEndereco = rst.getString("cep");
                String comlementoEndereco = rst.getString("complemento");
                String numeroEndereco = rst.getString("numero");
                String cidadeStr = rst.getString("cidade");
                String estadoStr = rst.getString("estado");
                String numeroTelefone = rst.getString("numeroTelefone");
                String dddTelefone = rst.getString("ddd");
                String nomePaciente = rst.getString("nome");
                String pedigriePaciente = rst.getString("pedigrie");
                String racaPaciente = rst.getString("raca");
                boolean temWhatsapp = rst.getBoolean("tem_whatsapp");
                Animal tipoPaciente = Animal.valueOf(rst.getString("tipo_animal"));
                Porte portePaciente = Porte.valueOf(rst.getString("porte"));
                float pesoPaciente = rst.getFloat("peso");

                Telefone telefone = new Telefone(numeroTelefone,dddTelefone,temWhatsapp);
                Estado estado = new Estado(estadoStr);
                Cidade cidade = new Cidade(cidadeStr,estado);
                Endereco endereco = new Endereco(logradouroEndereco,bairroEndereco,cepEndereco,comlementoEndereco,numeroEndereco,cidade);
                Responsavel responsavel = new Responsavel(nomeResonsavel,cpfResponsavel,endereco,telefone);
                Raca raca = new Raca(racaPaciente,portePaciente,tipoPaciente);
                Paciente paciente = new Paciente(nomePaciente,idadePaciente,pedigriePaciente,pesoPaciente,true,responsavel,raca);
                paciente.setId(id);
                pacienteList.add(paciente);

            }


        } catch (Exception e) {

            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return pacienteList;
    }

    private void openConnection(){
        try {
            if(this.connection == null || this.connection.isClosed()){
                this.connection = ConnectionFactory.getConnectionMySql();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
