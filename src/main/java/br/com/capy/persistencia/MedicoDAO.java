package br.com.capy.persistencia;

import br.com.capy.domain.EntidadeDominio;

import java.sql.SQLException;
import java.util.List;

public class MedicoDAO implements IDao {
    @Override
    public EntidadeDominio save(EntidadeDominio entidadeDominio) throws SQLException {
        return null;
    }

    @Override
    public EntidadeDominio update(EntidadeDominio entidadeDominio) throws SQLException {
        return null;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public List<EntidadeDominio> findAll(EntidadeDominio entidadeDominio) throws SQLException {
        return null;
    }

    @Override
    public EntidadeDominio findById(EntidadeDominio entidadeDominio) throws SQLException {
        return null;
    }
}
