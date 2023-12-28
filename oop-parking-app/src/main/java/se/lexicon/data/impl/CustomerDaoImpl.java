package se.lexicon.data.impl;

import se.lexicon.data.CustomerDao;
import se.lexicon.data.sequencer.CustomerIdSequencer;
import se.lexicon.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao {

    //Singleton Design Pattern
    private static CustomerDaoImpl instance;

    public static CustomerDaoImpl getInstance() {

        if (instance == null) {
            instance = new CustomerDaoImpl();
        }

            return instance;
    }

    private List<Customer> storage;

    private CustomerDaoImpl() {
        storage = new ArrayList<>();
    }

    @Override
    public Customer create(Customer customer) {
        if (customer == null) throw new IllegalArgumentException("Customer Data was null!");
        //Customer model = new Customer(CustomerIdSequencer.nextId(), customer.getName(), customer.getPhoneNumber());
        customer.setId(CustomerIdSequencer.nextId());
        storage.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> find(Integer id) {
        if (id == null) throw new IllegalArgumentException("Id was null!");

        for (Customer customer: storage){
            if (customer.getId() == id){
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(storage);
    }
}
