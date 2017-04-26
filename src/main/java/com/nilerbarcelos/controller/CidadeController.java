package com.nilerbarcelos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nilerbarcelos.model.Cidade;
import com.nilerbarcelos.model.Previsao;
import com.nilerbarcelos.service.CidadeService;

@Controller
public class CidadeController {

	@Autowired
	CidadeService cidadeService;

	@RequestMapping(method = RequestMethod.POST, value = "/cidades", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cidade> cadastrarCidade(@RequestBody Cidade cidade) {
		boolean cidadeExiste = cidadeService.isCidadeExistente(cidade);
		if (cidadeExiste) {
			Cidade cidadeCadastrada = cidadeService.cadastrar(cidade);
			return new ResponseEntity<Cidade>(cidadeCadastrada, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/cidades", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cidade>> buscarTodasCidades() {
		Collection<Cidade> cidadesBuscadas = cidadeService.buscarTodas();
		return new ResponseEntity<Collection<Cidade>>(cidadesBuscadas, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/cidades/{id}")
	public ResponseEntity<Cidade> excluirCidade(@PathVariable Integer id) {
		Cidade cidadeEncontrada = cidadeService.buscarPorId(id);
		if (cidadeEncontrada == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		cidadeService.excluir(cidadeEncontrada);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/cidades/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Previsao> buscarPrevisoes(@PathVariable Integer id) {
		Previsao previsao = cidadeService.buscarPrevisoes(id);
		return new ResponseEntity<>(previsao, HttpStatus.OK);
	}
}
