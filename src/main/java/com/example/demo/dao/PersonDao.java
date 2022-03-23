package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    //SE DEFINES LAS APLICACIONES QUE PERMITEN ESPECIFICAR LAS POERACIONES QUE DEBE AHCER QUIEN LAS UTILICE
    int insertPerson (UUID id, Person person);
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);

    }

    List<Object> selectAllPeople();

    Optional <Person> selectPersonById (UUID id);

    int deletePersonById (UUID id);

    int updatePersonById (UUID id, Person person);

}
