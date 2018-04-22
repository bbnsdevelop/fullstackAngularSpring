package br.com.fullstackAngularSpring.service.cep.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.fullstackAngularSpring.rest.response.CepEnderecoResponse;
import br.com.fullstackAngularSpring.service.cep.CepService;

@Service
public class CepServiceImpl implements CepService{
//	private static final Logger logger = LogManager.getLogger(CepServiceImpl.class);
	@Override
	public CepEnderecoResponse getCep(String buscarCep) {
		Gson gson = new Gson();
		CepEnderecoResponse cep = gson.fromJson(getJsonCep(buscarCep), CepEnderecoResponse.class);
		return cep;
	}	
	private String getJsonCep(String cep) {
        try {
            //log.debug("REST request to get Endereco on viacep.com.br: {}", cep);
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));

            return jsonSb.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
}
