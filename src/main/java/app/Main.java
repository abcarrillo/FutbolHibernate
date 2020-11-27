package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void procedimientoInsercionContrato() {

	}

	public static boolean mostrarMenu() throws ParseException {
		boolean resultado = true;
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		System.out.println("");
		System.out.println("Bienvenido/a");
		System.out.println("APP de base de datos de futbol (Hibernate)");
		System.out.println("¿Qué quiere hacer? \n");

		System.out.println("1) Insercion en una tabla");
		System.out.println("2) Modificación de un equipo");
		System.out.println("3) Eliminación de un equipo");
		System.out.println("4) Listar datos de un equipo (liga, contratos, observaciones y futbolistas del contrato)");
		System.out.println("0) Cerrar aplicación");
		Scanner sc = new Scanner(System.in);

		String eleccion = sc.nextLine();

		switch (eleccion) {
			case "1": {
				System.out.println("¿En qué tabla quieres insertar?");
	
				System.out.println("1) Contratos");
				System.out.println("2) Equipos");
				System.out.println("3) EquiposObservaciones");
				System.out.println("4) Futbolistas");
				System.out.println("5) Ligas");
				System.out.println("0) Cancelar");
	
				String subeleccion = sc.nextLine();
				switch (subeleccion) {
					case "1": {
						System.out.println("DNI del futbolista contratado:");
						String dni = sc.nextLine();
						System.out.println("Codigo del equipo elegido:");
						String codEquipo = sc.nextLine();
						System.out.println("Fecha de inicio del contrato:");
						String fechaComienzo = sc.nextLine();
						System.out.println("Fecha de final del contrato:");
						String fechaFinal = sc.nextLine();
						System.out.println("Precio anual del contrato:");
						String precioAnualString = sc.nextLine();
						System.out.println("Precio recision del contrato: ");
						String precioRecisionString = sc.nextLine();
		
						Date fechaFin = simpleDateFormat.parse(fechaFinal);
						Date fechaInicio = simpleDateFormat.parse(fechaComienzo);
						Equipo equipoXXX = AccesoBD.getEquipoHQLInteger(Integer.parseInt(codEquipo));
						Futbolista futbolistaXXX = AccesoBD.getFutbolistaPorDNI(dni);
		
						Contrato contrato = new Contrato(futbolistaXXX, equipoXXX, fechaInicio, fechaFin,
								Integer.parseInt(precioAnualString), Integer.parseInt(precioRecisionString));
		
						AccesoBD.insertarContrato(contrato);
						break;
					}
					case "2": {
						System.out.println("Nombre del equipo:");
						String nomEquipo = sc.nextLine();
						System.out.println("Código de liga del equipo:");
						String codLiga = sc.nextLine();
						System.out.println("Localidad del equipo:");
						String localidad = sc.nextLine();
						System.out.println("¿El equipo es internacional? (si o no)");
						String internacionalString = sc.nextLine();
		
						boolean internacional = false;
						if (internacionalString.toLowerCase().equals("si")) {
							internacional = true;
						}
						Liga ligaXXX = AccesoBD.getLigaPorID(codLiga);
		
						Equipo equipo = new Equipo(nomEquipo, ligaXXX, null, localidad, internacional);
		
						AccesoBD.insertarEquipo(equipo);
		
						System.out.println("¿Quieres hacer algun contrato para este equipo? (si o no)");
						String contratosEleccion = sc.nextLine();
						if (contratosEleccion.toLowerCase().equals("si")) {
							String mantenerContrato = "";
							do {
								System.out.println("DNI del futbolista contratado:");
								String dni = sc.nextLine();
								System.out.println("Fecha de inicio del contrato:");
								String fechaComienzo = sc.nextLine();
								System.out.println("Fecha de final del contrato:");
								String fechaFinal = sc.nextLine();
								System.out.println("Precio anual del contrato:");
								String precioAnualString = sc.nextLine();
								System.out.println("Precio recision del contrato: ");
								String precioRecisionString = sc.nextLine();
		
								Date fechaFin = simpleDateFormat.parse(fechaFinal);
								Date fechaInicio = simpleDateFormat.parse(fechaComienzo);
								Futbolista futbolistaXXX = AccesoBD.getFutbolistaPorDNI(dni);
		
								Contrato contrato = new Contrato(futbolistaXXX, equipo, fechaInicio, fechaFin,
										Integer.parseInt(precioAnualString), Integer.parseInt(precioRecisionString));
		
								AccesoBD.insertarContrato(contrato);
								System.out.println("¿Quiere hacer otro? (si o no)");
								mantenerContrato = sc.nextLine();
							} while (mantenerContrato.toLowerCase().equals("si"));
		
						}
		
						System.out.println("¿Quiere además hacer una observación de equipo? (si o no)");
						String observacionEleccion = sc.nextLine();
						if (observacionEleccion.toLowerCase().equals("si")) {
							System.out.println("Observacion para el equipo:");
							String observaciones = sc.nextLine();
							EquipoObservacion observacion = new EquipoObservacion(equipo.getCodEquipo(), observaciones, equipo);
							AccesoBD.insertarObservacionEquipo(observacion);
						}
		
					}
					
					case "3":{
						System.out.println("Codigo de equipo para la observacion:");
						String codEquipo = sc.nextLine();
						System.out.println("Observacion para el equipo:");
						String observaciones = sc.nextLine();
						
						Equipo equipo = AccesoBD.getEquipoHQLInteger(Integer.parseInt(codEquipo));
						
						EquipoObservacion observacion = new EquipoObservacion(equipo.getCodEquipo(), observaciones, equipo);
						AccesoBD.insertarObservacionEquipo(observacion);
					}
					
					case "4":{
						System.out.println("DNI del jugador: ");
						String codDNIoNIE = sc.nextLine();
						System.out.println("Nombre del jugador:");
						String nombre = sc.nextLine();
						System.out.println("Nacionalidad del jugador: ");
						String nacionalidad = sc.nextLine();
						
						Futbolista futbolista = new Futbolista(codDNIoNIE, nombre, nacionalidad);
						
						AccesoBD.insertarFutbolista(futbolista);
					}
					
					case "5":{
						System.out.println("Codigo de la liga: (abreviatura)");
						String codLiga = sc.nextLine();
						System.out.println("Nombre de liga:");
						String nomLiga = sc.nextLine();
						Liga liga = new Liga(codLiga, nomLiga);
						
						AccesoBD.insertarLiga(liga);
					}
					
					case "0": {
						break;
					}
					
					default:
						resultado = false;
						break;
				}
			}
			
			
			case "2":{
				AccesoBD.listarEquipos();
				System.out.println("\n ¿Que equipo quieres modificar? (inserta su codigo de equipo)");
				String codEquipo = sc.nextLine();
				
				Equipo equipo = AccesoBD.getEquipoHQLInteger(Integer.parseInt(codEquipo));
				
				System.out.println("Nombre del equipo: (Actual " + equipo.getNomEquipo() + ")");
				String nomEquipo = sc.nextLine();
				System.out.println("Código de liga del equipo: (Actual " + equipo.getLigaXXX().getCodLiga() + ")");
				String codLiga = sc.nextLine();
				System.out.println("Localidad del equipo: (Actual " + equipo.getLocalidad() + ")");
				String localidad = sc.nextLine();
				System.out.println("¿El equipo es internacional? (si o no)  (Actual " + equipo.isInternacional() + ")");
				String internacionalString = sc.nextLine();

				boolean internacional = false;
				if (internacionalString.toLowerCase().equals("si")) {
					internacional = true;
				}
				
				equipo.setNomEquipo(nomEquipo);
				equipo.setLigaXXX(AccesoBD.getLigaPorID(codLiga));
				equipo.setInternacional(internacional);
				equipo.setLocalidad(localidad);
				
				AccesoBD.modificarEquipo(equipo);
				break;
			}
			
			case "3":{
				AccesoBD.listarEquipos();
				System.out.println("\n ¿Que equipo quieres eliminar? (inserta su codigo de equipo)");
				String codEquipo = sc.nextLine();
				
				AccesoBD.eliminarEquipo(codEquipo);
				break;
			}
			
			case "4":{
				AccesoBD.listarEquiposExtended();
				break;
			}
			
			case "0": {
				resultado = false;
				break;
			}
			default: {
				resultado = false;
				break;
			}
				
		}
		
		return resultado;
	}

	public static void main(String[] args) throws ParseException {

		boolean mantenerBucle = false;
		do {
			mantenerBucle = mostrarMenu();
		} while (mantenerBucle);

	}
}
