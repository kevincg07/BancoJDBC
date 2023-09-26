package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dto.ClientePorCuenta;
import com.dto.DescripcionCuenta;
import com.dto.DescripcionPrestamos;
import com.dto.PrestamosPorCliente;
import com.entity.Clientes;
import com.general.DataBase;
import com.general.Metodos;

public class ClientesDAO implements Metodos{

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String resultado;
	Clientes cliente = null;
	DataBase db = new DataBase();
	
	
	@Override
	public String guardar(Object ob) {
		cliente = (Clientes)ob;
		String query = "INSERT INTO CLIENTES VALUES(?,?,?,?,?)";
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(query);
			
			ps.setInt(1, 0);
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getDireccion());
			ps.setString(4, cliente.getRfc());
			ps.setString(5, cliente.getNumeroTelefono());
			
			int x = ps.executeUpdate();
			if(x > 0) {
				System.out.println("Guardado OK");
				resultado = "1";
			}else {
				System.out.println("Error al guardar");
				resultado = "0";
			}
			
		}catch(Exception ex){
			resultado = ex.getMessage();
		}
		
		return resultado;
	}

	@Override
	public String editar(Object ob) {
		cliente = (Clientes)ob;
		String update = "UPDATE CLIENTES SET NOMBRE = ?, DIRECCION = ?, NUMERO_TELEFONO = ?, RFC = ? WHERE ID_COSTUMER = ?";
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(update);
			
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getDireccion());
			ps.setString(3, cliente.getRfc());
			ps.setString(4, cliente.getNumeroTelefono());
			ps.setInt(5, cliente.getIdCostumer());
			
			int x = ps.executeUpdate();
			if(x > 0) {
				System.out.println("Editado OK");
				resultado = "1";
			}else {
				System.out.println("Error al guardar");
				resultado = "0";
			}
		} catch (Exception  e) {
			resultado = e.getMessage();
		}
		
		return resultado;
	}

	@Override
	public String eliminar(int id) {
		String delete = "DELETE FROM CLIENTES WHERE ID_COSTUMER = " + id;
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(delete);
			int x = ps.executeUpdate();
			if(x > 0 ) {
				System.out.println("Eliminado OK");
				resultado = "1";
			}else {
				System.out.println("Error al eliminar");
				resultado = "0";
			}
		}catch(Exception e) {
			resultado = e.getMessage();
		}
		return null;
	}

	@Override
	public Object buscar(int id) {
		String select = "SELECT * FROM CLIENTES WHERE ID_COSTUMER = "+ id;
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(select);
			rs = ps.executeQuery();
			while(rs.next()) {
				cliente = new Clientes(rs.getInt("ID_COSTUMER"), rs.getString("NOMBRE"), rs.getString("DIRECCION"),
						rs.getString("RFC"), rs.getString("NUMERO_TELEFONO"));
			}
		}catch(Exception e) {
			System.out.println("Error al buscar");
			resultado = e.getMessage();
		}
		
		return cliente;
	}

	@Override
	public List mostrar() {
		String select = "SELECT * FROM CLIENTES";
		List<Clientes> clientes = new ArrayList<Clientes>();
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(select);
			rs = ps.executeQuery();
			while(rs.next()) {
				cliente = new Clientes(rs.getInt("ID_COSTUMER"), rs.getString("NOMBRE"), rs.getNString("DIRECCION"),
						rs.getString("RFC"), rs.getString("NUMERO_TELEFONO"));
				
				clientes.add(cliente);
			}
		}catch(Exception e) {
			System.out.println("Error al buscar");
			e.printStackTrace();
		}
		
		return clientes;
	}
	
	public ClientePorCuenta getCuentasCliente(String costumer) {
		
		DescripcionCuenta desCuenta = null;
		ClientePorCuenta dto = null;
		List<DescripcionCuenta> descripcion = new ArrayList<DescripcionCuenta>();
		String query = "SELECT C.NOMBRE, C.RFC, C.NUMERO_TELEFONO, CU.NUM_CUENTA, CU.TIPO_CUENTA, " + 
				"CU.SALDO_MAX, CU.SALDO_MIN " + 
				"FROM CLIENTES C INNER JOIN CUENTAS CU " + 
				"ON C.ID_COSTUMER = CU.CLIENTE WHERE C.NOMBRE = '" + costumer + "'";
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			String nomCliente = "";
			String rfcCliente = "";
			String telCliente = "";
			while(rs.next()) {
				nomCliente = rs.getString("NOMBRE");
				rfcCliente = rs.getString("RFC");
				telCliente = rs.getString("NUMERO_TELEFONO");
				desCuenta = new DescripcionCuenta(rs.getInt("NUM_CUENTA"), rs.getString("TIPO_CUENTA"), 
						rs.getInt("SALDO_MAX"), rs.getInt("SALDO_MIN"));
				descripcion.add(desCuenta);
			}
			dto = new ClientePorCuenta(nomCliente, rfcCliente, telCliente, descripcion);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public PrestamosPorCliente getPrestamos(String name) {
		
		PrestamosPorCliente dto = null;
		DescripcionPrestamos prestamos =  null;
		List<DescripcionPrestamos> descripcionPrestamos = new ArrayList<DescripcionPrestamos>();
		
		String query = "SELECT C.NOMBRE, P.MONTO, P.FECHA " + 
				"FROM CLIENTES C INNER JOIN PRESTAMOS P " + 
				"ON P.CLIENTE_ID = C.ID_COSTUMER WHERE C.NOMBRE = '" + name + "'";
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			String nombre = "";
			while(rs.next()) {
				prestamos = new DescripcionPrestamos(rs.getInt("MONTO"), rs.getDate("FECHA"));
				nombre = rs.getString("NOMBRE");
				descripcionPrestamos.add(prestamos);
			}
			dto = new PrestamosPorCliente(nombre, descripcionPrestamos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
}
