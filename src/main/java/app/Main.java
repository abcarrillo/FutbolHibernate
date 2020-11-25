package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void mostrarMenu() {
		System.out.println("");
		System.out.println("Bienvenido/a");
		System.out.println("APP de base de datos de futbol (Hibernate)");
		System.out.println("¿Qué quiere hacer? \n");
		
		System.out.println("1) CRUD de Equipos");
		System.out.println("2) CRUD de EquiposObservaciones");
		System.out.println("3) CRUD de Futbolistas");
		System.out.println("4) CRUD de Ligas");
		System.out.println("5) CRUD de Contratos");
		System.out.println("0) Cerrar aplicación");
		Scanner sc = new Scanner(System.in);
		
		String eleccion = sc.nextLine();
		
		switch (eleccion) {
		case "0":{
			System.out.println("CERRANDO.....................");
			break;
		}	
		case "1":{
			System.out.println("");
			System.out.println("Ha elegido el CRUD de Equipos");
			System.out.println("1) Leer");
			System.out.println("2) Crear");
			System.out.println("3) Modificar");
			System.out.println("4) Eliminar");
			System.out.println("0) Cancelar");
			String submenu = sc.nextLine();
			break;
		}
		default:
			System.out.println("CERRANDO.....................");
			break;
		}
	}
	
	public static void main(String[] args) throws ParseException {
		//Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		/*
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date fechaInicio = simpleDateFormat.parse("2018-12-09");
		*/
		
		EquipoObservacion equipo = AccesoBD.getObservacionPorID(3);
		
		System.out.println(equipo);
		
		System.out.println(AccesoBD.getEquiporPorID(3));
		
	}
}
