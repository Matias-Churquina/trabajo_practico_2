package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	private Integer numeroTarjeta;
	private LocalDate fechaPago;
	private double montoPago;
	public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}
	
	public PagoTarjeta(Integer numeroTarjeta, LocalDate fechaPago, double montoPago) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPago = montoPago;
	}

	public void realizarPago(double monto) {
		this.setMontoPago(monto + monto * 0.15);
	}

	public void imprimirRecibo() {
		System.out.println("Número de tarjeta: " + numeroTarjeta);
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/MM/yy"); 
		System.out.println("Fecha de pago: " + fechaPago.format(fecha));
		System.out.println("Monto pagado: " + montoPago);
	}

	public Integer getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(Integer numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMontoPago() {
		return montoPago;
	}

	public void setMontoPago(double montoPago) {
		this.montoPago = montoPago;
	}
	
}
