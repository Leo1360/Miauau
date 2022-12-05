package br.com.capy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento extends EntidadeDominio{
    private String nomeCientifico;
    private TipoUso tipoUso;
}
