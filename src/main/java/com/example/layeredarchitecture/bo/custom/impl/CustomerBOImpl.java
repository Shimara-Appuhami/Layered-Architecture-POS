package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.CustomerBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.entity.Customer;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
//    CustomerDAO customerDAO = new CustomerDAOImpl();
    CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> customers=customerDAO.getAll();
        ArrayList<CustomerDTO> customerDTOS=new ArrayList<>();
        for (Customer c:customers){
            CustomerDTO customerDTO=new CustomerDTO(c.getId(),c.getName(),c.getAddress());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
//        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.add(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
//        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.update(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
//        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.exist(id);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
//        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.delete(id);
    }

    @Override
    public String generateNewCustomerID() throws SQLException, ClassNotFoundException {
//        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.generateNewID();
    }

}
