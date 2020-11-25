package app;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "equiposobservaciones")
public class EquipoObservacion implements Serializable {
	
	@Id
	@GeneratedValue(generator = "myForeign")
	@GenericGenerator( name = "myForeign", strategy = "foreign",
	parameters = {@org.hibernate.annotations.Parameter(name = "property", value = "EquipoXXX")})
	Integer codEquipo;

	@Column(columnDefinition = "varchar(200)")
	String observaciones;
	
	@OneToOne (cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@PrimaryKeyJoinColumn
	private Equipo EquipoXXX;

	public int getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(Integer codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Equipo getEquipoXXX() {
		return EquipoXXX;
	}

	public void setEquipoXXX(Equipo equipoXXX) {
		EquipoXXX = equipoXXX;
	}

	@Override
	public String toString() {
		return "EquipoObservacion [codEquipo=" + codEquipo + ", observaciones=" + observaciones + ", EquipoXXX="
				+ EquipoXXX + "]";
	}

	
	
	
	
}
