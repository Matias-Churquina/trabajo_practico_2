package ar.edu.unju.fi.ejercicio1.model;

public class Producto {
	private Integer codigo;
	private String descripcion;
	private double precioUnit;
	private OrigenFab origenFab;
	private Categoria categoria;
	
	public enum OrigenFab{
		ARGENTINA, CHINA, BRASIL, URUGUAY;
	}
	public enum Categoria{
		TELEFONIA, INFORMATIVA, ELECTROHOGAR, HERRAMIENTAS;
	}
}
