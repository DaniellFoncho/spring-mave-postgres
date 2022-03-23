package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// PARA UTRILIZAR LOS SERVICIOS REST ES NECESARIO AGREGAR LA SIGUIENTE ANOTACION:
@RestController

// para el request de postman
@RequestMapping ("api/v1/person")


public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(  PersonService personService) {
        this.personService = personService;
    }

    // para indicarle a spring que esta sera una solicitud post debemos agregar:

    @PostMapping
    public void addPerson( @Valid @NotNull @RequestBody Person person)
    {
        personService.addPerson(person);
    }

    // aqui ahcemos la llamada a la capa de servicio que asu vez hizo la llamada a la interfaz  DAO
    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson (@PathVariable ("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping (path = "{id}")
    public void updatePerson (@PathVariable ("id") UUID id, @Valid @NotNull @RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }


}
