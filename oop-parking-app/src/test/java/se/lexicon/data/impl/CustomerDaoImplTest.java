package se.lexicon.data.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDaoImplTest {

    CustomerDaoImpl testObject;



    @BeforeEach
    void setUp() {

      //  testObject = new CustomerDaoImpl();
        testObject = CustomerDaoImpl.getInstance();
    }

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer(12345,"Test Testsson", "123456789");
        Customer created = testObject.create(customer);

        Assertions.assertNotNull(created);
    }
}