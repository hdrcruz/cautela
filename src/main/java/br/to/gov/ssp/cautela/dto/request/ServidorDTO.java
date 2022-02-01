package br.to.gov.ssp.cautela.dto.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class ServidorDTO {
	
	private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String nome;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String sobrenome;

    @NotEmpty
    @CPF
    private String cpf;

    @Valid
    @NotEmpty
    private List<ArmaDTO> armas;

}
