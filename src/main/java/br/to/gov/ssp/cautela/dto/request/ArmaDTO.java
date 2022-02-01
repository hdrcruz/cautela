package br.to.gov.ssp.cautela.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArmaDTO {
	
	private Long id;
	
	@NotEmpty
    @Size(min = 2, max = 100)
	private String serial;

}
