package br.com.capy.controle.fachada;

import br.com.capy.util.Resultado;
import br.com.capy.controle.strategy.*;
import br.com.capy.domain.*;
import br.com.capy.persistencia.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fachada implements IFachada{
    //Operação - Entidade - Estratégia
    private HashMap<String, HashMap<String,List<IStrategy>>> startupRsnMap = new HashMap<String, HashMap<String,List<IStrategy>>>();
    private HashMap<String, HashMap<String,List<IStrategy>>> finalizationRnsMap = new HashMap<String, HashMap<String,List<IStrategy>>>();
    private HashMap<String, IDao> daoMap = new HashMap<>();

    public Fachada() {
        //Mapeando DAOs por nome de classe
        daoMap.put(Paciente.class.getSimpleName(), new PacienteDAO());
        daoMap.put(Responsavel.class.getSimpleName(), new ResponsavelDAO());
        daoMap.put(Exame.class.getSimpleName(), new ExameDAO());
        daoMap.put(Medico.class.getSimpleName(), new MedicoDAO());
        daoMap.put(Consulta.class.getSimpleName(), new ConsultaDAO());
        daoMap.put(Receita.class.getSimpleName(), new ReceitaDAO());

        //===============Mapa regras de negócio pré processamento=========================

        //Startup PACIENTE
        HashMap<String,List<IStrategy>> mapaPaciente = new HashMap<>();
            //Salvar
        List<IStrategy> listaRegrasSalvarPaciente = new ArrayList<>();
        listaRegrasSalvarPaciente.add(new ValidarPedigrie());
        listaRegrasSalvarPaciente.add(new ValidarCamposPaciente());
        listaRegrasSalvarPaciente.add(new ValidarResponsavel());
        mapaPaciente.put("SALVAR",listaRegrasSalvarPaciente);
            //Alterar
        mapaPaciente.put("ALTERAR",listaRegrasSalvarPaciente); // Alterar repete regras do salvamento
            //Consultar
            //Excluir
            //Adicionando regra de paciente para mapa de regras de startup
        startupRsnMap.put(Paciente.class.getSimpleName(),mapaPaciente);


        //Startup RESPONSAVEL
        HashMap<String,List<IStrategy>> mapaResponsavel = new HashMap<>();
            //Salvar
        List<IStrategy> listaRegrasSalvarResponsavel = new ArrayList<>();
        listaRegrasSalvarResponsavel.add(new ValidarCpf());
        listaRegrasSalvarResponsavel.add(new ValidarUnicidade());
        mapaResponsavel.put("SALVAR",listaRegrasSalvarResponsavel);
            //Alterar
        mapaResponsavel.put("ALTERAR",listaRegrasSalvarResponsavel); // Alterar repete regras do salvamento
            //Consultar
            //Excluir
            //Adicionando regra de paciente para mapa de regras de startup
        startupRsnMap.put(Responsavel.class.getSimpleName(),mapaResponsavel);

        //===============Mapa regras de negócio pró processamento=========================
        HashMap<String,List<IStrategy>> mapaPacienteFim = new HashMap<>();
        List<IStrategy> listaRegrasSalvarPacienteFim = new ArrayList<>();
        listaRegrasSalvarPacienteFim.add(new Logar());
        mapaPacienteFim.put("SALVAR",listaRegrasSalvarPacienteFim);
        mapaPacienteFim.put("ALTERAR",listaRegrasSalvarPacienteFim);
        mapaPacienteFim.put("EXCLUIR",listaRegrasSalvarPacienteFim);
        finalizationRnsMap.put(Paciente.class.getSimpleName(),mapaPacienteFim);

        HashMap<String,List<IStrategy>> mapaResponsavelFim = new HashMap<>();
        List<IStrategy> listaRegrasSalvarResponsavelFim = new ArrayList<>();
        listaRegrasSalvarPacienteFim.add(new Logar());
        mapaResponsavelFim.put("SALVAR",listaRegrasSalvarResponsavelFim);
        mapaResponsavelFim.put("ALTERAR",listaRegrasSalvarResponsavelFim);
        mapaResponsavelFim.put("EXCLUIR",listaRegrasSalvarResponsavelFim);
        finalizationRnsMap.put(Responsavel.class.getSimpleName(),mapaResponsavelFim);

    }

    @Override
    public Resultado salvar(EntidadeDominio entidade){
        String operation = "SAVE";
        StringBuilder strbErros = new StringBuilder();
        Resultado resultado = new Resultado();

        strbErros.append(executarRegras(entidade,operation,startupRsnMap));

        //Caso alguma retorne um erro o processmento n é executado e retona um resultado apenas com as msgs de erro
        if(!strbErros.isEmpty()) {
            return new Resultado(strbErros.toString());
        }

        //Executando processamento
        IDao dao = daoMap.get(entidade.getClass().getSimpleName());
        EntidadeDominio entidadeSalva = null;
        try{
            entidadeSalva = dao.save(entidade);
            List<EntidadeDominio> listEntidade = new ArrayList<>();
            listEntidade.add(entidadeSalva);
            resultado.setResultado(listEntidade);

        }catch (SQLException e){
            e.printStackTrace();
            resultado.setMsg("Não foi possivel realizar o registro no banco");
        }


        strbErros.append(executarRegras(entidade,operation,finalizationRnsMap));

        resultado.setMsg(strbErros.toString());
        return resultado;
    }

    @Override
    public Resultado alterar(EntidadeDominio entidade) {
        String operation = "ALTERAR";
        StringBuilder strbErros = new StringBuilder();
        Resultado resultado = new Resultado();

        strbErros.append(executarRegras(entidade,operation,startupRsnMap));

        //Caso alguma retorne um erro o processmento n é executado e retona um resultado apenas com as msgs de erro
        if(!strbErros.isEmpty()) {
            return new Resultado(strbErros.toString());
        }
        //Executa transacao
        IDao dao = daoMap.get(entidade.getClass().getSimpleName());
        EntidadeDominio entidadeAlterada = null;
        try{
            entidadeAlterada = dao.update(entidade);
            List<EntidadeDominio> listEntidade = new ArrayList<>();
            listEntidade.add(entidadeAlterada);
            resultado.setResultado(listEntidade);

        }catch (SQLException e){
            e.printStackTrace();
            resultado.setMsg("Não foi possivel realizar o registro no banco");
        }


        strbErros.append(executarRegras(entidade,operation,finalizationRnsMap));

        resultado.setMsg(strbErros.toString());
        return resultado;
    }

    @Override
    public Resultado excluir(EntidadeDominio entidade) {
        String operation = "EXCLUIR";
        StringBuilder strbErros = new StringBuilder();
        Resultado resultado = new Resultado();

        strbErros.append(executarRegras(entidade,operation,startupRsnMap));

        //Caso alguma retorne um erro o processmento n é executado e retona um resultado apenas com as msgs de erro
        if(!strbErros.isEmpty()) {
            return new Resultado(strbErros.toString());
        }
        //Executa transacao
        IDao dao = daoMap.get(entidade.getClass().getSimpleName());
        try{
            dao.delete(entidade.getId());
            List<EntidadeDominio> listEntidade = new ArrayList<>();
            listEntidade.add(entidade);
            resultado.setResultado(listEntidade);

        }catch (SQLException e){
            e.printStackTrace();
            resultado.setMsg("Não foi possivel realizar o registro no banco");
        }


        strbErros.append(executarRegras(entidade,operation,finalizationRnsMap));

        resultado.setMsg(strbErros.toString());
        return resultado;
    }

    @Override
    public Resultado visualizar(EntidadeDominio entidade) {
        String operation = "CONSULTAR";
        StringBuilder strbErros = new StringBuilder();
        Resultado resultado = new Resultado();

        strbErros.append(executarRegras(entidade,operation,startupRsnMap));

        //Caso alguma retorne um erro o processmento n é executado e retona um resultado apenas com as msgs de erro
        if(!strbErros.isEmpty()) {
            return new Resultado(strbErros.toString());
        }
        //Executa transacao
        IDao dao = daoMap.get(entidade.getClass().getSimpleName());
        List<EntidadeDominio> listEntidade = new ArrayList<>();
        try{
            listEntidade = dao.findAll(entidade);
            resultado.setResultado(listEntidade);

        }catch (SQLException e){
            e.printStackTrace();
            resultado.setMsg("Não foi possivel realizar o registro no banco");
        }


        strbErros.append(executarRegras(entidade,operation,finalizationRnsMap));

        resultado.setMsg(strbErros.toString());
        return resultado;
    }

    private String executarRegras(EntidadeDominio entidade,String operation,HashMap<String, HashMap<String,List<IStrategy>>> colecaoRegras){
        StringBuilder strbErros = new StringBuilder();
        //Pegando as regras de negocio pre processamento
        HashMap<String,List<IStrategy>> regrasMap = colecaoRegras.get(entidade.getClass().getSimpleName());
        if(regrasMap != null){
            //Rodando todas as regras de negocio pré processamento
            List<IStrategy> regrasList = regrasMap.get(operation);
            if(regrasList != null){
                for(IStrategy rn : regrasList){
                    strbErros.append(rn.processar(entidade));
                }
            }
        }

        return strbErros.toString();
    }

}
