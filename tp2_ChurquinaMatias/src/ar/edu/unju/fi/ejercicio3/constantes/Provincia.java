package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY( 811611, 53219 ), SALTA( 1441351, 22524 ),
	TUCUMAN(1703186, 22524), CATARMACA(429562, 102602 ), 
	LA_RIOJA(384607, 89680),
	SANTIAGO_DEL_ESTERO( 1054028, 136351);
	
	private Integer CantPoblacion;
	private Integer Superficie;
	
	private Provincia (Integer CantPoblacion, Integer Superficie) {
		this.CantPoblacion = CantPoblacion;
		this.Superficie = Superficie;
	}

	public Integer getCantPoblacion() {
		return CantPoblacion;
	}

	public void setCantPoblacion(Integer cantPoblacion) {
		CantPoblacion = cantPoblacion;
	}

	public Integer getSuperficie() {
		return Superficie;
	}

	public void setSuperficie(Integer superficie) {
		Superficie = superficie;
	}
	public double densidadPob() {
		return (double)CantPoblacion/(double)Superficie;
	}
	
}
