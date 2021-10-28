package com.companyname.springapp.web.controllers;


import java.sql.SQLException;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.springapp.business.Conexion;
import com.companyname.springapp.business.entities.Empleado;
import com.companyname.springapp.business.entities.Nomina;

@Controller
public class EmpleadoController {
	
	Nomina n=new Nomina();
	
    protected final Log logger = LogFactory.getLog(getClass());
    private Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate=new JdbcTemplate(con.Conectar());
    ModelAndView mav= new ModelAndView();
    private String dni;
    
    
    
    
  
    
    @RequestMapping(value="/mostrar.htm", method =RequestMethod.GET)
    public ModelAndView mostrar() {
        
    	String sql="select * from empleados";
    	List datos=this.jdbcTemplate.queryForList(sql);
    	mav.addObject("lista",datos);
    	mav.setViewName("mostrar");
    	return mav;
    	
    }
    
    
    @RequestMapping(value="/mostrarSalario.htm")
    public ModelAndView mostrarSalario() {

    	mav.setViewName("mostrarSalario");
		return mav;
    }
    
    @RequestMapping(value="/buscarEmpleado.htm")
    public ModelAndView buscarEmpleado() {

    	mav.setViewName("buscarEmpleado");
		return mav;
    }
    
    @RequestMapping(value="/buscarDni.htm")
    public ModelAndView buscarDni() {

    	mav.setViewName("buscarDni");
		return mav;
    }
    
    @RequestMapping(value="/buscarDni.htm", method =RequestMethod.POST)
    public ModelAndView buscarDni(HttpServletRequest request) {
    	dni=request.getParameter("dni");
    	String sql="select * from nominas where dni='"+dni+"'";
    	List datos=this.jdbcTemplate.queryForList(sql);
    	mav.addObject("lista",datos);
    	mav.setViewName("mostrarSalario");
    	return mav;
    	
    }
    
    @RequestMapping(value="/buscarEmpleado.htm", method =RequestMethod.POST)
    public ModelAndView buscarEmpleado(@RequestParam String dni) {
    	String sql="select * from empleados where dni='"+dni+"'";
    	List datos=this.jdbcTemplate.queryForList(sql);
    	mav.addObject("lista",datos);
    	mav.setViewName("mostrarEmpleado");
    	return mav;
    	
    }
    
    @RequestMapping(value="/buscarEmpleadoNombre.htm", method =RequestMethod.POST)
    public ModelAndView buscarEmpleadoNombre(@RequestParam String nombre) {
    	String sql="select * from empleados where nombre='"+nombre+"'";
    	List datos=this.jdbcTemplate.queryForList(sql);
    	mav.addObject("lista",datos);
    	mav.setViewName("mostrarEmpleado");
    	return mav;
    	
    }
    
    @RequestMapping(value="/buscarEmpleadoCategoria.htm", method =RequestMethod.POST)
    public ModelAndView buscarEmpleadoCategoria(@RequestParam int categoria) {
    	String sql="select * from empleados where categoria="+categoria;
    	List datos=this.jdbcTemplate.queryForList(sql);
    	mav.addObject("lista",datos);
    	mav.setViewName("mostrarEmpleado");
    	return mav;
    	
    }
    
    @RequestMapping(value="/buscarEmpleadoAntiguedad.htm", method =RequestMethod.POST)
    public ModelAndView buscarEmpleadoAntiguedad(@RequestParam int antiguedad) {
    	String sql="select * from empleados where anyos="+antiguedad;
    	List datos=this.jdbcTemplate.queryForList(sql);
    	mav.addObject("lista",datos);
    	mav.setViewName("mostrarEmpleado");
    	return mav;
    	
    }
    
    @RequestMapping(value="/buscarEmpleadoSexo.htm", method =RequestMethod.POST)
    public ModelAndView buscarEmpleadoSexo(@RequestParam String sexo) {
    	String sql="select * from empleados where sexo='"+sexo+"'";
    	List datos=this.jdbcTemplate.queryForList(sql);
    	mav.addObject("lista",datos);
    	mav.setViewName("mostrarEmpleado");
    	return mav;
    	
    }
    
    
    
    @RequestMapping(value="/agregar.htm", method =RequestMethod.GET)
    public ModelAndView agregar() {
    	mav.addObject(new Empleado());
    	mav.setViewName("agregar");
		return mav;
    }
    
    @RequestMapping(value="/agregar.htm", method =RequestMethod.POST)
    public ModelAndView agregar(Empleado emp) throws SQLException {
    	String sql="insert into empleados(categoria, anyos, nombre, dni, sexo) value(?,?,?,?,?)";
    	this.jdbcTemplate.update(sql,emp.getCategoria(),emp.getAnyos(),emp.getNombre(),emp.getDni(),emp.getSexo());
    	sql="insert into nominas(dni, sueldo) value(?,?)";
    	this.jdbcTemplate.update(sql,emp.getDni(),n.sueldo(emp));
		return new ModelAndView ("redirect:/mostrar.htm");
    }
    
    @RequestMapping(value="/editar.htm", method =RequestMethod.GET)
    public ModelAndView editar(@RequestParam String dni) throws SQLException {
        String sql="select * from empleados where dni='"+dni+"'";
        List datos=this.jdbcTemplate.queryForList(sql);
		mav.addObject("lista",datos);
		mav.setViewName("editar");
		return mav;
    }
    
    @RequestMapping(value="/editar.htm", method =RequestMethod.POST)
    public ModelAndView editar(Empleado emp) {
    	String sql="UPDATE empleados SET categoria=?, anyos=?, nombre=?, sexo=? WHERE dni=?";
    	this.jdbcTemplate.update(sql, emp.getCategoria(),emp.getAnyos(),emp.getNombre(),emp.getSexo(),dni);
    	sql="UPDATE nominas SET sueldo=? WHERE dni=?";
    	this.jdbcTemplate.update(sql,n.sueldo(emp),dni);
    	return new ModelAndView ("redirect:/mostrar.htm");
    }
    
    
    
    @RequestMapping(value="/eliminar.htm",method =RequestMethod.GET)
    public ModelAndView eliminar(@RequestParam String dni) {
    	String sql="DELETE FROM empleados WHERE dni=?";
    	this.jdbcTemplate.update(sql,dni);
    	sql="DELETE FROM nominas WHERE dni=?";
    	this.jdbcTemplate.update(sql,dni);
    	return new ModelAndView ("redirect:/mostrar.htm");
    }
}
