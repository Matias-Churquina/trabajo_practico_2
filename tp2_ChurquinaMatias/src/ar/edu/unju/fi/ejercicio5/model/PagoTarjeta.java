package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private double montoPago;
	public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}
	
	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPago) {
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
		System.out.println("Fecha de pago: " + fechaPago);
		System.out.println("Monto pagado: " + montoPago);
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
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
