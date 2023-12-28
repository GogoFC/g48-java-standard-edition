package se.lexicon;

import se.lexicon.data.CustomerDao;
import se.lexicon.data.impl.CustomerDaoImpl;
import se.lexicon.model.Customer;

public class Main {
    public static void main(String[] args)
    {
        CustomerDao customerDao = CustomerDaoImpl.getInstance();

        customerDao.create(new Customer("Simon","123456789"));
        customerDao.create(new Customer("Mehrdad","987654321"));

        System.out.println(customerDao.findAll().size()); // 2


        customerDao = CustomerDaoImpl.getInstance();
        customerDao = CustomerDaoImpl.getInstance();
        customerDao = CustomerDaoImpl.getInstance();
        customerDao = CustomerDaoImpl.getInstance();
        customerDao = CustomerDaoImpl.getInstance();
        customerDao = CustomerDaoImpl.getInstance();

        System.out.println(customerDao.findAll().size()); //2

    }
}