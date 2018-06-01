package br.com.fullstackAngularSpring.cep.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.fullstackAngularSpring.cep.CepService;
import br.com.fullstackAngularSpring.rest.response.CepEnderecoResponse;

@Service
public class CepServiceImpl implements CepService {
	private static final Logger log = LoggerFactory.getLogger(CepServiceImpl.class);

	@Override
	public CepEnderecoResponse getCep(String buscarCep) {
		log.info("preparando GSON para busca de cep");
		Gson gson = new Gson();
		CepEnderecoResponse cep = gson.fromJson(getJsonCep(buscarCep), CepEnderecoResponse.class);
		return cep;
	}

	private String getJsonCep(String cep) {
		log.info("Buscando cep: " + cep);
		try {
			log.info("REST request to get Endereco on viacep.com.br: {}", cep);
			URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			StringBuilder jsonSb = new StringBuilder();

			br.lines().forEach(l -> jsonSb.append(l.trim()));

			return jsonSb.toString();

		} catch (Exception e) {
			log.error("Erro ao buscar cep: "+ e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
