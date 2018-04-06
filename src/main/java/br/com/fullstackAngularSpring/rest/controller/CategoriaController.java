package br.com.fullstackAngularSpring.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstackAngularSpring.rest.resource.CategoriaResource;

@RestController
@RequestMapping(value ="/categoria")
public class CategoriaController implements CategoriaResource{

}
