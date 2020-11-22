package app;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

public class AccesoBD {

	public static void listarFutbolistas() {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Query q = sesion.createQuery("from Futbolista");
		try {
			List<Futbolista> listaFutbolistas = q.getResultList();
			for (Futbolista futbolista : listaFutbolistas) {
				
				System.out.println(futbolista.getCodDNIoNIE() + " | " + futbolista.getNombre() + " | "
						+ futbolista.getNacionalidad());
				List<Contrato> contratos = futbolista.getContratos();
				System.out.println("- CONTRATOS DE ESTE FUTBOLISTA: ");
				
				for (Contrato contrato : contratos) {
					System.out.println(contrato.getCodContrato() + " | " + contrato.getFechaInicio() + " | "
							+ contrato.getFechaFin() + " | " + contrato.getPrecioAnual() + " | "
							+ contrato.getPrecioRecision());
				}
				
				System.out.println();
			}
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}

	public static void listarEquipos() {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Query q = sesion.createQuery("from Equipo");
		try {
			List<Equipo> listaEquipos = q.getResultList();
			for (Equipo equipo : listaEquipos) {
				System.out.println(
						equipo.getCodEquipo() + " | " + equipo.getNomEquipo() + " | " + equipo.getLigaXXX().getNomLiga()
								+ " | " + equipo.getLocalidad() + " | " + equipo.isInternacional());
			}
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}

	public static void listarLigas() {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Query q = sesion.createQuery("from Liga");
		try {
			List<Liga> listaLigas = q.getResultList();
			for (Liga liga : listaLigas) {
				System.out.println(liga.getCodLiga() + " | " + liga.getNomLiga());
				System.out.println(" - EQUIPOS DE ESTA LIGA: ");
				List<Equipo> equipos = liga.getEquipos();
				for (Equipo equipo : equipos) {
					System.out.println(equipo.getCodEquipo() + " | " + equipo.getNomEquipo() + " | "
							+ equipo.getLigaXXX().getNomLiga() + " | " + equipo.getLocalidad() + " | "
							+ equipo.isInternacional());
				}
				System.out.println("\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}

	public static void insertarLiga(String codLiga, String nomLiga) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		sesion.beginTransaction();
		try {
			Liga liga = new Liga();
			liga.setCodLiga(codLiga);
			liga.setNomLiga(nomLiga);

			sesion.save(liga);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}

	public static void insertarEquipo(String nomEquipo, boolean internacional, String localidad, Liga ligaXXX) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		sesion.beginTransaction();
		try {
			Equipo equipo = new Equipo();

			equipo.setInternacional(internacional);
			equipo.setLocalidad(localidad);
			equipo.setNomEquipo(nomEquipo);
			equipo.setLigaXXX(ligaXXX);

			sesion.save(equipo);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}

	public static void insertarFutbolista(String codDNIoNIE, String nombre, String nacionalidad) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		sesion.beginTransaction();
		try {
			Futbolista futbolista = new Futbolista();
			futbolista.setCodDNIoNIE(codDNIoNIE);
			futbolista.setNombre(nombre);
			futbolista.setNacionalidad(nacionalidad);

			sesion.save(futbolista);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}
}
