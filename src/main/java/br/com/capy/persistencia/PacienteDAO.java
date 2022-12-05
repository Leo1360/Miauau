package br.com.capy.persistencia;

import br.com.capy.domain.EntidadeDominio;
import br.com.capy.domain.Paciente;

import java.util.List;

public class PacienteDAO implements IDao{
    @Override
    public EntidadeDominio save(EntidadeDominio entidadeDominio) {
        return null;
    }

    @Override
    public EntidadeDominio update(EntidadeDominio entidadeDominio) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<EntidadeDominio> findAll(EntidadeDominio entidadeDominio) {
        return null;
    }

    @Override
    public EntidadeDominio findById(EntidadeDominio entidadeDominio) {
        return null;
    }

    public List<Paciente> findByPedigrie(String pedigrie){
        return null;
    }

}
