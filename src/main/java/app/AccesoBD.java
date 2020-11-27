package app;

import java.util.Date;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.query.Query;

public class AccesoBD {

	public static void insertarObservacionEquipo(EquipoObservacion observacion) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();

		try {
			sesion.beginTransaction();
			sesion.save(observacion);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}

	public static EquipoObservacion getObservacionPorID(Integer id) {
		EquipoObservacion resultado = null;
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		try {
			sesion.beginTransaction();
			EquipoObservacion consulta = (EquipoObservacion) sesion.get(EquipoObservacion.class, id);
			resultado = consulta;
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
		return resultado;
	}

	public static void listarContratos() {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Query q = sesion.createQuery("from Contrato");
		try {
			List<Contrato> listaContratos = q.getResultList();
			for (Contrato contrato : listaContratos) {
				System.out.println(contrato.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}

	public static void insertarContrato(Contrato contrato) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();

		try {
			sesion.beginTransaction();
			sesion.save(contrato);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}

	public static Liga getLigaPorID(String id) {
		Liga resultado = null;
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		try {
			Liga consulta = (Liga) sesion.get(Liga.class, id);
			resultado = consulta;
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
		return resultado;
	}

	public static void insertarLiga(Liga liga) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();

		try {
			sesion.beginTransaction();
			sesion.save(liga);
			sesion.getTransaction().commit();
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
				System.out.println(liga.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}

	public static Futbolista getFutbolistaPorDNI(String dni) {
		Futbolista resultado = null;
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		try {
			Futbolista consulta = (Futbolista) sesion.get(Futbolista.class, dni);
			resultado = consulta;
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
		return resultado;
	}

	public static void listarFutbolistas() {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Query q = sesion.createQuery("from Futbolista");
		try {
			List<Futbolista> listaFutbolistas = q.getResultList();
			for (Futbolista futbolista : listaFutbolistas) {
				System.out.println(futbolista.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}

	public static void insertarFutbolista(Futbolista futbolista) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();

		try {
			sesion.beginTransaction();
			sesion.save(futbolista);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}

	public static Equipo getEquiporPorID(Integer id) {
		Equipo resultado = null;
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		try {
			sesion.beginTransaction();
			Equipo consulta = (Equipo) sesion.get(Equipo.class, id);
			resultado = consulta;
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
		return resultado;
	}

	public static Equipo getEquipoHQLInteger(int id) {
		Equipo resultado = null;
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Query q = sesion.createQuery("from Equipo where codEquipo = " + id);
		try {
			resultado = (Equipo) q.getSingleResult();

		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
		return resultado;
	}

	public static void listarEquipos() {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Query q = sesion.createQuery("from Equipo");
		try {
			List<Equipo> listaEquipos = q.getResultList();
			for (Equipo equipo : listaEquipos) {
				System.out.println(equipo.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}

	public static void listarEquiposExtended() {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Query q = sesion.createQuery("from Equipo");
		try {
			List<Equipo> listaEquipos = q.getResultList();
			for (Equipo equipo : listaEquipos) {
				System.out.println(equipo.toString());
				System.out.println(" - LIGA DE ESTE EQUIPO: ");
				System.out.println(equipo.getLigaXXX().toString());
				System.out.println(" - CONTRATOS DE ESTE EQUIPO: ");
				List<Contrato> contratos = equipo.getContratos();

				for (Contrato contrato : contratos) {
					System.out.println("* " + contrato.toString());
					Futbolista futbolista = contrato.getFutbolistaXXX();
					System.out.println(" |\\ FUTBOLISTA DEL CONTRATO: ");
					System.out.println(futbolista.toString());
				}

				EquipoObservacion ob = equipo.getEquipoObservacionXXX();
				if (ob != null) {
					System.out.println(" - OBSERVACION DEL EQUIPO: ");
					System.out.println(ob.toString());
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

	public static void insertarEquipo(Equipo equipo) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();

		try {
			sesion.beginTransaction();
			sesion.save(equipo);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}

	public static void eliminarEquipo(String id) {

		Session sesion = HibernateUtil.getSessionFactory().openSession();

		Query q = sesion.createQuery("from Equipo where codEquipo = " + id);
		try {
			sesion.beginTransaction();
			Equipo consulta = (Equipo) q.getSingleResult();
			sesion.delete(consulta);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e);
		}
		sesion.close();
	}
	
	public static void modificarEquipo(Equipo equipo) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();

		try {
			sesion.beginTransaction();
			sesion.update(equipo);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			sesion.getTransaction().rollback();
			System.out.println(e);
		}
		sesion.close();
	}

}
