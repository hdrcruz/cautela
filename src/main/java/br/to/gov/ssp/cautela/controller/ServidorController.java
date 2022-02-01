package br.to.gov.ssp.cautela.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.to.gov.ssp.cautela.dto.request.ServidorDTO;
import br.to.gov.ssp.cautela.dto.response.MessageResponseDTO;
import br.to.gov.ssp.cautela.service.ServidorService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/servidor")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ServidorController {
	
	private final ServidorService servidorService;
	
	@PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid ServidorDTO servidorDTO) {
        return servidorService.criar(servidorDTO);
    }

}
