import br.com.capy.domain.*;
import br.com.capy.persistencia.PacienteDAO;

import java.util.List;

public class TesteConceitos {
    public static void main(String[] args) {
        testeCadastroPaciente();

    }

    private static EntidadeDominio testeCadastroPaciente(){
        String nomeResonsavel = "Emily";
        String cpfResponsavel = "41036801802";
        String logradouroEndereco = "Rua Verador Almeida";
        String bairroEndereco = "Cj do bosque";
        String cepEndereco = "08743080";
        String comlementoEndereco = "Portao azul";
        String numeroEndereco = "14";
        String cidadeStr = "Mogi das Cruzes";
        String estadoStr = "SP";
        String numeroTelefone = "952223827";
        String dddTelefone = "11";
        String nomePaciente = "Jorge";
        String pedigriePaciente = "0000";
        String racaPaciente = "Vira lata";

        boolean temWhatsapp = true;
        Animal tipoPaciente = Animal.CACHORRO;
        Porte portePaciente = Porte.MEDIO;
        int idadePaciente = 12;
        float pesoPaciente = 2.5f;


        Telefone telefone = new Telefone(numeroTelefone,dddTelefone,temWhatsapp);
        Estado estado = new Estado(estadoStr);
        Cidade cidade = new Cidade(cidadeStr,estado);
        Endereco endereco = new Endereco(logradouroEndereco,bairroEndereco,cepEndereco,comlementoEndereco,numeroEndereco,cidade);
        Responsavel responsavel = new Responsavel(nomeResonsavel,cpfResponsavel,endereco,telefone);
        Raca raca = new Raca(racaPaciente,portePaciente,tipoPaciente);
        Paciente paciente = new Paciente(nomePaciente,idadePaciente,pedigriePaciente,pesoPaciente,true,responsavel,raca);

        PacienteDAO dao = new PacienteDAO();
        dao.save(paciente);
        System.out.println("Paciente cadastrado" + paciente);
        return paciente;

    }
    private static EntidadeDominio testeAlterarPaciente(){
        int id = 2;
        String nomeResonsavel = "Emily";
        String cpfResponsavel = "41036801802";
        String logradouroEndereco = "Rua Verador Almeida";
        String bairroEndereco = "Cj do bosque";
        String cepEndereco = "08743080";
        String comlementoEndereco = "Portao azul";
        String numeroEndereco = "14";
        String cidadeStr = "Mogi das Cruzes";
        String estadoStr = "SP";
        String numeroTelefone = "952223827";
        String dddTelefone = "11";
        String nomePaciente = "Niki";
        String pedigriePaciente = "1111";
        String racaPaciente = "Vira lata";

        boolean temWhatsapp = true;
        Animal tipoPaciente = Animal.CACHORRO;
        Porte portePaciente = Porte.MEDIO;
        int idadePaciente = 13;
        float pesoPaciente = 12.5f;


        Telefone telefone = new Telefone(numeroTelefone,dddTelefone,temWhatsapp);
        Estado estado = new Estado(estadoStr);
        Cidade cidade = new Cidade(cidadeStr,estado);
        Endereco endereco = new Endereco(logradouroEndereco,bairroEndereco,cepEndereco,comlementoEndereco,numeroEndereco,cidade);
        Responsavel responsavel = new Responsavel(nomeResonsavel,cpfResponsavel,endereco,telefone);
        Raca raca = new Raca(racaPaciente,portePaciente,tipoPaciente);
        Paciente paciente = new Paciente(nomePaciente,idadePaciente,pedigriePaciente,pesoPaciente,true,responsavel,raca);
        paciente.setId(id);

        PacienteDAO dao = new PacienteDAO();
        dao.update(paciente);
        System.out.println("Paciente alterado" + paciente);
        return paciente;

    }

    private static void testeDeletarPaciente(){
        int id = 4;
        PacienteDAO dao = new PacienteDAO();
        dao.delete(id);
        System.out.println("Paciente deletado: id= " + id);

    }

    private static List<EntidadeDominio> testeFindAllPaciente(){
        PacienteDAO dao = new PacienteDAO();
        return dao.findAll(null);
    }

    private static EntidadeDominio testeFindByIdPaciente(){
        int id = 2;
        PacienteDAO dao = new PacienteDAO();
        Paciente paciente = new Paciente();
        paciente.setId(id);
        paciente = (Paciente) dao.findById(paciente);
        System.out.println(paciente);
        return paciente;
    }

    private static void testeFindByPedigrie(){
        String pedigrie = "0000";
        PacienteDAO dao = new PacienteDAO();
        List<Paciente> pacienteList = dao.findByPedigrie(pedigrie);
        for(Paciente p:pacienteList){
            System.out.println(p);
        }
    }

}
