package com.hexaware.carrental.dao;

import java.sql.Date;
import java.util.List;

import com.hexaware.carrental.entity.Customer;
import com.hexaware.carrental.entity.Lease;
import com.hexaware.carrental.entity.Vehicle;

public interface ICarLeaseRepository {
       int addCar(Vehicle vehicle);
       int removeCar(int vehicleID);
       List<Vehicle> listAvailableCars();
       List<Vehicle> listRentedCars();
       Vehicle findCarbyId(int vehicleID);
       void addCustomer(Customer customer);
       void removeCustomer(int customerID);
       List<Customer> listofAllCustomers();
       Customer findCustomerbyId(int customerID);
       Lease createLease(int customerID, int carID,Date startDate, Date endDate);
       Lease returnCar(int leaseID);
       List<Lease> listActiveLeases();
       List<Lease> listLeaseHistory();
       void recordPayment( Lease lease, double amount);
       
       
}
