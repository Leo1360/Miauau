package br.com.capy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exame extends EntidadeDominio{
    private String nome;
    private Date data;
    private String linkSrquivo;
}
