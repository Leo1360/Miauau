package br.com.capy.domain;

import java.util.Date;
import lombok.Data;

@Data
public class Adoecimento extends EntidadeDominio {
    private Date data;
    private String bos;
    private String duracao;
    private Doenca doenca;

}
