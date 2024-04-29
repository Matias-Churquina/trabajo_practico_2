package ar.edu.unju.fi.ejercicio5.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFab;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;

public class Main {
	private static Scanner sc;
	private static List<Producto> productos;
	private static List<Producto> prodCompra;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		precargaProducto();
		int op = 0;
		do {
			System.out.println();
			System.out.println("========= COMPRAS ========");
			System.out.println("1 - Mostrar productos.");
			System.out.println("2 - Realizar compra.");
			System.out.println("3 - Salir.");
			System.out.print("  Ingrese una opción: ");
			System.out.println();
			System.out.println("============================");
			op = sc.nextInt();
			sc.nextLine();
		    switch (op) {
		     	case 1:
		     		mostrarProductos();
		     		break;
		     	case 2:
		     		realizarCompra();
		     		break;
		     	case 3:
		     		System.out.println(" --- FIN DEL PROGRAMA  ---");
	     			break;
	     		default: System.out.println("Opción incorrecta.");
		    }
		
		}while( op != 3 );
				
	}
	/**
	 * Propósito: Este módulo muestra un menú por consola para que el
	 * usuario pueda elegir un pais de acuerdo a su número asignado.
	 * 
	 */
	public static int opPais() {
		int op = 0;
		System.out.println("    Elija su origen de fabricación ");
		System.out.println("1 - Argentina");
		System.out.println("2 - China");
		System.out.println("3 - Brasil ");
		System.out.println("4 - Uruguay");;
		System.out.print("  Ingrese una opción: ");
		System.out.println();
		System.out.println("=================================");
		op = sc.nextInt();
		return op;
	}
	/**
	 * Propósito: Este módulo muestra un menú por consola para que el
	 * usuario pueda elegir una categoria de acuerdo a su número asignado.
	 * 
	 */
	public static int opCategoria() {
		int op = 0;
		System.out.println("    Elija su categoría =====");
		System.out.println("1 - Telefonía");
		System.out.println("2 - Informática");
		System.out.println("3 - Electro hogar ");
		System.out.println("4 - Herramientas");;
		System.out.print("  Ingrese una opción: ");
		System.out.println();
		System.out.println("======================");
		op = sc.nextInt();
		return op;
	}
	/**
	 * Propósito: Este módulo crea un nuevo objeto Producto solicitando
	 * por consola al usuario los datos del producto.
	 * También agrega un objeto Producto a un array 'productos'.
	 * 
	 */
	public static void precargaProducto() {
		if(productos == null) {
			productos = new ArrayList<>();
		}
		for(int i=1; i<=15; i++) {
			Producto p = new Producto();
			System.out.println("===== Nuevo Producto =====");
			System.out.print("Ingrese código del producto: ");
			p.setCodigo(sc.nextInt());
			sc.nextLine();
			System.out.print("Ingrese descripción: ");
			p.setDescripcion(sc.nextLine());
			while(true) {
				try {
					System.out.print("Ingrese precio unitario: ");
					p.setPrecioUnit(sc.nextDouble());
					break;
				}catch(Exception e) {
					System.out.println("Debe usar coma ',' como separador decimal.");
					sc.nextLine();
				}
			}
			while(true) {
			try {
				int o = opPais();
				OrigenFab[] valPais = OrigenFab.values();
				OrigenFab pais = valPais[o-1];
				p.setOrigenFab(pais);
				break;
			}catch(Exception e) {
					System.out.println("ERROR. Debe ingresar una opción de acuerdo al país.");
			}
			}
			while(true) {
			try {
			 	int c = opCategoria();
			    Categoria[] valCat = Categoria.values();
			    Categoria categ = valCat[c-1];
			    p.setCategoria(categ);
			    break;
			}catch(Exception e) {
					System.out.println("ERROR. Debe ingresar una opción de acuerdo a la categoria.");
			}
			}
			System.out.print("Ingrese si hay stock (true) o no (false): ");
			p.setStock(sc.nextBoolean());
		    productos.add(p);
		    System.out.println("Producto agregado correctamente.");
		}
	}
	/**
	 * Propósito: Este módulo muestra de forma iterativa los datos 
	 * de cada objeto producto agragado a el array productos.
	 * 
	 */
	public static void mostrarProductos() {
		if(productos != null) {
			System.out.println("===== Lista de Productos =====");
			productos.forEach(p->System.out.println(p));
		}else {
			System.out.println("ERROR. La lista está vacía.");
		}
	}
	public static Producto  buscarProducto(String nombre) {
		Producto Encontrado = null;
		for(Producto nombre1: productos) {
			if(nombre1.getDescripcion().equals(nombre)) {
				Encontrado = nombre1;
				break;
			}
		}
		return Encontrado;
	}
	public static void pagar(double monto) {
		System.out.println("1 - Pago en efectivo");
		System.out.println("2 - Pago con tarjeta");
		System.out.print("    Elija una opción de pago. ");
		int pago = sc.nextInt();
		if(pago == 1) {
			PagoEfectivo efectivo = new PagoEfectivo();
			efectivo.realizarPago(monto);
			
		}
	}
	public static void realizarCompra(){
		System.out.println("===== Realizar compra =====");
		System.out.println("Ingrese la cantidad de productos que decea comprar: ");
		int cant = sc.nextInt();
		int i = 1;
		double monto = 0;
		do {
			System.out.println("   Producto " + i );
			System.out.print("Ingrese nombre del producto: ");
			Producto prod = buscarProducto(sc.next());
			if(prod != null) {
				monto = monto + prod.getPrecioUnit();
				prodCompra.add(prod);
				System.out.println("El producto se agrego al carro.");
			}else {
				System.out.println("ERROR. No se encontró el producto."); //crear Exception
			}
		}while(i<=cant);
		pagar(monto);
	}
}
