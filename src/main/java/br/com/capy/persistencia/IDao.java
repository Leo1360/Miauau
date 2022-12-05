package br.com.capy.persistencia;

import br.com.capy.domain.EntidadeDominio;

import java.sql.SQLException;
import java.util.List;

public interface IDao {
    public EntidadeDominio save(EntidadeDominio entidadeDominio) throws SQLException;
    public EntidadeDominio update(EntidadeDominio entidadeDominio)throws SQLException;
    public void delete(int id)throws SQLException;
    public List<EntidadeDominio> findAll(EntidadeDominio entidadeDominio)throws SQLException;
    public EntidadeDominio findById(EntidadeDominio entidadeDominio)throws SQLException;
}
