package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFab;

public class Main {
	private static Scanner sc;
	private static List<Producto> productos;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		precargaProducto();
		int op = 0;
		do {
			System.out.println();
			System.out.println("========= COMPRAS ========");
			System.out.println("1 - Mostrar productos.");
			System.out.println("2 - Mostrar procustos faltantes.");
			System.out.println("3 - Incrementar los precios de los productos en 20%.");
			System.out.println("4 - Mostar productos de Electrohogar y tengan stock.");
			System.out.println("5 - Ordenar productos por precios en forma descendente.");
			System.out.println("6 - Mostar productos con los nombres en mayúsculas.");
			System.out.println("7 - Salir.");
			System.out.print("  Ingrese una opción: ");
			System.out.println();
			System.out.println("============================");
			op = sc.nextInt();
			sc.nextLine();
		    switch (op) {
		     	case 1:
		     		mostrarProdStock();
		     		break;
		     	case 2:
		     		mostrarProdSinStock();
		     		break;
		     	case 3:
		     		incrementar();
		     		break;
		     	case 4:
		     		mostrarProdElectroHogar();
		     		break;
		     	case 5:
		     		ordenarProd();
		     		break;
		     	case 6:
		     		mostarNombresMayus();
		     		break;
		     	case 7:
		     		System.out.println(" --- FIN DEL PROGRAMA  ---");
	     			break;
	     		default: System.out.println("Opción incorrecta.");
		    }
		
		}while( op != 7 );
				
	}
	
	/**
	 * Propósito: Este módulo crea un nuevo objeto Producto solicitando
	 * por consola al usuario los datos del producto.
	 * También agrega un objeto Producto a un array 'productos'.
	 * 
	 */
	public static void precargaProducto() {
		productos = new ArrayList<>();
		if(productos.isEmpty()) {
			productos.add(new Producto(101, "Monitor Asus 24'", 150000, OrigenFab.CHINA, Categoria.INFORMATICA, true));
			productos.add(new Producto(102, "Notebook Noblex 15'", 660000, OrigenFab.ARGENTINA, Categoria.INFORMATICA, true));
			productos.add(new Producto(103, "Teclado Gammer Soul", 57999, OrigenFab.CHINA, Categoria.INFORMATICA, true));
			productos.add(new Producto(104, "Procesador Intel i7", 405222, OrigenFab.BRASIL, Categoria.INFORMATICA, false));
			productos.add(new Producto(105, "Lavarropa Dream Next", 506000, OrigenFab.CHINA, Categoria.ELECTROHOGAR, true));
			productos.add(new Producto(106, "Heladera Samsung Inverter", 150000, OrigenFab.URUGUAY, Categoria.ELECTROHOGAR, true));
			productos.add(new Producto(107, "Aire Acondicionado Philco", 456519, OrigenFab.ARGENTINA, Categoria.ELECTROHOGAR, false));
			productos.add(new Producto(108, "Smart Tv LG 65'", 999999, OrigenFab.BRASIL, Categoria.ELECTROHOGAR, true));
			productos.add(new Producto(109, "Celular Samsung A23", 430000, OrigenFab.URUGUAY, Categoria.TELEFONIA, true));
			productos.add(new Producto(110, "Celular Xiaomi Redmi 12c", 299999, OrigenFab.CHINA, Categoria.TELEFONIA, true));
			productos.add(new Producto(111, "Celular LG K52  ", 169500, OrigenFab.ARGENTINA, Categoria.TELEFONIA, false));
			productos.add(new Producto(112, "Celular Iphone 11 ", 783990, OrigenFab.CHINA, Categoria.TELEFONIA, true));
			productos.add(new Producto(113, "Taladro Einhell", 417953, OrigenFab.CHINA, Categoria.HERRAMIENTAS, true));
			productos.add(new Producto(114, "Amoladora Philco ", 47999, OrigenFab.URUGUAY, Categoria.HERRAMIENTAS, true));
			productos.add(new Producto(115, "Soldadora Sincrolamp", 150000, OrigenFab.BRASIL, Categoria.HERRAMIENTAS, false));
		}
	}

	
	public static void mostrarProdStock() {
		Consumer<Producto> mostrarProd = (p) -> System.out.println(p);
		System.out.println("====== Productos con stock =======");
		productos.forEach(p -> {
			if (p.isStock() == true) {
				mostrarProd.accept(p);
			}
		});
	}
	public static void mostrarProdSinStock() {
		Consumer<Producto> mostrarProd = (p) -> System.out.println(p);
		Predicate<Producto> sinStock = stock -> stock.isStock() == false;
		List<Producto> prod = new ArrayList<>();
		System.out.println("====== Productos sin stock =======");
		prod = productos.stream().filter(sinStock).collect(Collectors.toList());
		prod.forEach(mostrarProd);
	}
	public static void incrementar() {
		List<Producto> productosIncrementados = new ArrayList<>();
		Consumer<Producto> mostrarProd = (Producto p) -> System.out.println(p);
		Function<Producto, Producto> increment20 = (prod) -> { 
				double p = prod.getPrecioUnit()*1.2;
				prod.setPrecioUnit(p);
				return prod;};
		productosIncrementados = productos.stream().map(increment20).collect(Collectors.toList());
		productosIncrementados.forEach(mostrarProd);
	}
	public static void mostrarProdElectroHogar() {
		Consumer<Producto> mostrarProd = (p) -> System.out.println(p);
		Predicate<Producto> StockElecHogar = stock -> stock.isStock() == true && stock.getCategoria().equals(Categoria.ELECTROHOGAR);
		List<Producto> prod = new ArrayList<>();
		System.out.println("====== Productos ElectroHogar con stock =======");
		prod = productos.stream().filter(StockElecHogar).collect(Collectors.toList());
		prod.forEach(mostrarProd);
	}
	public static void ordenarProd() {
		System.out.println("====== Productos ordenados por precio =======");
		productos.sort(Comparator.comparing(Producto::getPrecioUnit).reversed());
		Consumer<Producto> mostrarProd = (p) -> System.out.println(p);
		productos.forEach(mostrarProd);
	}
	public static void mostarNombresMayus() {
		List<Producto> productosMayus = new ArrayList<>();
		Consumer<Producto> mostrarProd = (Producto p) -> System.out.println(p);
		Function<Producto, Producto> mayuscula = (prod) -> { 
				prod.setDescripcion(prod.getDescripcion().toUpperCase());
				return prod;};
		productosMayus = productos.stream().map(mayuscula).collect(Collectors.toList());
		productosMayus.forEach(mostrarProd);
	}
}
