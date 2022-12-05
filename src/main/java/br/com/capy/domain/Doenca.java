package br.com.capy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doenca extends EntidadeDominio{
    private String nome;
    private String descricao;

    public Doenca(int id,String nome, String descricao) {
        super(id);
        this.nome = nome;
        this.descricao = descricao;
    }

}
