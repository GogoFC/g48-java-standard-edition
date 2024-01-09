package se.lexicon.stream.service;

import se.lexicon.stream.model.Person;

import java.util.List;

public interface People {

    People INSTANCE = PeopleImpl.getInstance();

    List<Person> getPeople();
}
