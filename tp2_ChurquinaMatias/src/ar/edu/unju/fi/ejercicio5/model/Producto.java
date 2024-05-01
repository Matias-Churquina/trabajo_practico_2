package ar.edu.unju.fi.ejercicio5.model;


public class Producto {
	private Integer codigo;
	private String descripcion;
	private double precioUnit;
	private OrigenFab origenFab;
	private Categoria categoria;
	private boolean stock;
	
	public enum OrigenFab{
		ARGENTINA, CHINA, BRASIL, URUGUAY;
	}
	public enum Categoria{
		TELEFONIA, INFORMATIVA, ELECTROHOGAR, HERRAMIENTAS;
	}
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUnit=" + precioUnit
				+ ", origenFab=" + origenFab + ", categoria=" + categoria + ", stock=" + stock + "]";
	}


	public Producto(Integer codigo, String descripcion, double precioUnit, OrigenFab origenFab, Categoria categoria,
			boolean stock) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnit = precioUnit;
		this.origenFab = origenFab;
		this.categoria = categoria;
		this.stock = stock;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnit() {
		return precioUnit;
	}

	public void setPrecioUnit(double precioUnit) {
		this.precioUnit = precioUnit;
	}

	public OrigenFab getOrigenFab() {
		return origenFab;
	}

	public void setOrigenFab(OrigenFab origenFab) {
		this.origenFab = origenFab;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}
	
	
	
}
