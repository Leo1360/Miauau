package br.com.capy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemReceita extends EntidadeDominio{
    private float dose;
    private String frequencia;
    private String observacao;
    private Medicamento medicamento;

}
