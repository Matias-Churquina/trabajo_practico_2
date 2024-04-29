package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
	private double montoPago;
	private LocalDate fechaPago;
	
	public PagoEfectivo() {
		// TODO Auto-generated constructor stub
	}
	
	public PagoEfectivo(double montoPago, LocalDate fechaPago) {
		super();
		this.montoPago = montoPago;
		this.fechaPago = fechaPago;
	}

	public void realizarPago(double monto) {
		this.setMontoPago(monto - monto * 0.10);
	}
	public void imprimirRecibo(){
		System.out.println("Fecha de pago: " + fechaPago);
		System.out.println("Monto pagado: " + montoPago);
	}

	public double getMontoPago() {
		return montoPago;
	}

	public void setMontoPago(double montoPago) {
		this.montoPago = montoPago;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	
}
