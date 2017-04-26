package com.nilerbarcelos.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.nilerbarcelos.model.Cidade;
import com.nilerbarcelos.model.Previsao;
import com.nilerbarcelos.repository.CidadeRepository;

@Service
public class CidadeService {
	
	private final String APPID = "eb8b1a9405e659b2ffc78f0a520b1a46";
	private final String LANGUAGE = "pt";
	private final String UNITS = "metric";

	@Autowired
	CidadeRepository cidadeRepository;

	public Cidade cadastrar(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	public Collection<Cidade> buscarTodas() {
		return cidadeRepository.findAll();
	}

	public void excluir(Cidade cidade) {
		cidadeRepository.delete(cidade);
	}

	public Cidade buscarPorId(Integer id) {
		return cidadeRepository.findOne(id);
	}

	public boolean isCidadeExistente(Cidade cidade) {
		try {
			String nomeCidade = cidade.getNomeCidade();
			URL url = new URL(String.format("http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s&lang=%s&units=%s", nomeCidade, APPID, LANGUAGE, UNITS));

			Reader dataInput = new InputStreamReader(url.openStream());
			Previsao previsao = new Gson().fromJson(dataInput, Previsao.class);

			String codigoRetorno = previsao.getCod();
			if (codigoRetorno.equals("200")) {
				cidade.setCodigoCidade(previsao.getCity().getId());
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Previsao buscarPrevisoes(Integer id) {
		Previsao previsao = null;
		try {
			URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?id=" + id
					+ "&appid=eb8b1a9405e659b2ffc78f0a520b1a46&lang=pt&units=metric");
			Reader dataInput = null;
			dataInput = new InputStreamReader(url.openStream());
			previsao = new Gson().fromJson(dataInput, Previsao.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return previsao;
	}
}
