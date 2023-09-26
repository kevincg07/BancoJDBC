package com.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.ClientesDAO;
import com.dto.ClientePorCuenta;
import com.dto.DescripcionCuenta;
import com.dto.PrestamosPorCliente;
import com.entity.Clientes;
import com.general.Status;

// http://localhost:8090/webBancojdbc/webBancojdbc/clientes/mostrar
@Path("clientes/")
public class ClientesService {

	Clientes clientes = null;
	ClientesDAO dao = null;
	
	
	@Path("guardar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Status guardar(Clientes cliente) {
		Status status = new Status();
		status.setObject(cliente);
		dao = new ClientesDAO();
		String respuesta = dao.guardar(cliente);
		
		boolean esUno = respuesta.equals("1");
		if(esUno) {
			status.setMensaje("servive ok");
			status.setRespuesta(respuesta);
		}else {
			status.setMensaje("service errro");
			status.setRespuesta(respuesta);
		}
		
		return status;
	}
	
	
	@Path("actualizar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Status editar(Clientes cliente) {
		Status status = new Status();
		status.setObject(cliente);
		dao = new ClientesDAO();
		String respuesta = dao.editar(cliente);
		boolean esUno = respuesta.equals("1");
		if(esUno) {
			status.setMensaje("servive ok");
			status.setRespuesta(respuesta);
		}else {
			status.setMensaje("service errror");
			status.setRespuesta(respuesta);
		}
		return status;
	}
	
	@Path("eliminar/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Status eliminar(@PathParam("id")int id) {
		Status status = new Status();
		dao = new ClientesDAO();
		String respuesta = dao.eliminar(id);
		boolean esUno = respuesta.equals("1");
		if(esUno) {
			status.setMensaje("service ok");
			status.setRespuesta(respuesta);
		}else {
			status.setMensaje("service error");
			status.setRespuesta(respuesta);
		}
		
		return status;
	}
	
	@Path("mostrar-por-id/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Clientes buscar(@PathParam("id")int id) {
		dao = new ClientesDAO();
		clientes = (Clientes)dao.buscar(id);
		
		return clientes;
	}
	
	@Path("mostrar")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Clientes>mostrar(){
		dao = new ClientesDAO();
		List<Clientes> listClientes = new ArrayList<Clientes>();
		listClientes = dao.mostrar();
		return listClientes;
	}
	
//	@Path("mostrar-all-cuentas")
//	@GET
//	@Produces({MediaType.APPLICATION_JSON})
//	public List<DescripcionCuenta> mostrarCC() {
//		dao = new ClientesDAO();
//		List<DescripcionCuenta> clientesPorCuenta = dao.getClientes();
//		return clientesPorCuenta;
//	}
	
	@Path("cuentas-por-cliente/{nombre}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public ClientePorCuenta mostrarCuentas(@PathParam("nombre") String nombre) {
		dao = new ClientesDAO();
		ClientePorCuenta des = dao.getCuentasCliente(nombre);
		return des;
	}
	
	@Path("prestamos-por-cliente/{nombre}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public PrestamosPorCliente mostrarPrestamos(@PathParam("nombre") String nombre) {
		dao = new ClientesDAO();
		PrestamosPorCliente des = dao.getPrestamos(nombre);
		return des;
	}
}
