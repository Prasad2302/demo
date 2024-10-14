package com.hexaware.carrental.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.carrental.entity.Customer;
import com.hexaware.carrental.entity.Lease;
import com.hexaware.carrental.entity.Vehicle;
import com.hexaware.carrental.entity.Payment;
import com.hexaware.carrental.dao.DBUtil;

public class ICarLeaseRepositoryImpl implements ICarLeaseRepository{
	private Connection conn;

	public ICarLeaseRepositoryImpl() {

		conn = DBUtil.getDBConnection();
}


	@Override
	public int addCar(Vehicle vehicle) {
		int count=0;
		String insert="insert into Vehicle(vehicleId,make,model,year,dailyRate,status,passengerCapacity,engineCapacity) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
			pstmt.setInt(1, vehicle.getVehicleId());
			pstmt.setString(2, vehicle.getMake());
			pstmt.setString(3, vehicle.getModel());
			pstmt.setInt(4, vehicle.getYear());
			pstmt.setDouble(5, vehicle.getDailyRate());
			pstmt.setString(6, vehicle.getStatus());
			pstmt.setInt(7, vehicle.getPassengerCapacity());
			pstmt.setInt(6, vehicle.getEngineCapacity());
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}

	@Override
	public int removeCar(int vehicleID) {
		 int count=0;
			
			String delete="delete from Vehicle where vehicleID=?";
			
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(delete);
				pstmt.setInt(1,vehicleID);
				
				count=pstmt.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		
			return count;
		
	}

	@Override
	public List<Vehicle> listAvailableCars() {
		// TODO Auto-generated method stub
       List<Vehicle> list=new ArrayList<Vehicle>();
		
		String selectAll="select * from vehicle where status='available' ";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int vehicleId=rs.getInt("vehicleID");
				String make=rs.getString("Make");
				String model=rs.getString("model");
				int year=rs.getInt("year");
				Double dailyRate=rs.getDouble("DailyRate");
				String Status=rs.getString("Status");
				int passengerCapacity=rs.getInt("PassengerCapacity");
				int EngineCapacity=rs.getInt("EngineCapacity");
				
				Vehicle vehicle=new Vehicle(vehicleId,make,model,year,dailyRate,Status,passengerCapacity,EngineCapacity);
				list.add(vehicle);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	

	@Override
	public List<Vehicle> listRentedCars() {
		// TODO Auto-generated method stub
		 List<Vehicle> list=new ArrayList<Vehicle>();
			
			String selectAll="select * from vehicle where status='not available' ";
			try {
				PreparedStatement pstmt=conn.prepareStatement(selectAll);
				
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					int vehicleId=rs.getInt("vehicleID");
					String make=rs.getString("Make");
					String model=rs.getString("model");
					int year=rs.getInt("year");
					Double dailyRate=rs.getDouble("DailyRate");
					String Status=rs.getString("Status");
					int passengerCapacity=rs.getInt("PassengerCapacity");
					int EngineCapacity=rs.getInt("EngineCapacity");
					
					Vehicle vehicle=new Vehicle(vehicleId,make,model,year,dailyRate,Status,passengerCapacity,EngineCapacity);
					list.add(vehicle);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
	}

	@Override
	public Vehicle findCarbyId(int vehicleID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCustomer(int customerID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> listofAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomerbyId(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lease createLease(int customerID, int carID, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lease returnCar(int leaseID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lease> listActiveLeases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lease> listLeaseHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void recordPayment(Lease lease, double amount) {
		// TODO Auto-generated method stub
		
	}
	

}
