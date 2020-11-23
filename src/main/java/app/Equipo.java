package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="equipos")
public class Equipo implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column ( columnDefinition= "int(11)")
	int codEquipo;
	
	@Column ( columnDefinition= "varchar(40)")
	String nomEquipo;
	
	@ManyToOne
	@JoinColumn(name="codLiga")
	private Liga ligaXXX;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="equipoXXX")
	private List<Contrato> contratos = new ArrayList<Contrato>();
	
	@Column ( columnDefinition= "varchar(60)")
	String localidad;
	
	@Column ( columnDefinition= "BIT")
	boolean internacional;
	

	public int getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(int codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getNomEquipo() {
		return nomEquipo;
	}

	public void setNomEquipo(String nomEquipo) {
		this.nomEquipo = nomEquipo;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public boolean isInternacional() {
		return internacional;
	}

	public void setInternacional(boolean internacional) {
		this.internacional = internacional;
	}

	public Liga getLigaXXX() {
		return ligaXXX;
	}

	public void setLigaXXX(Liga ligaXXX) {
		this.ligaXXX = ligaXXX;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	@Override
	public String toString() {
		return getCodEquipo() + " | " + getNomEquipo() + " | " + getLigaXXX().getNomLiga() + " | " + getLocalidad() + " | " + isInternacional();
	}
	
	
	
}
