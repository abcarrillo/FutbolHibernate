package app;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contratos")
public class Contrato implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int(11)")
	private int codContrato;

	@ManyToOne(cascade= {CascadeType.PERSIST}, fetch=FetchType.LAZY)
	@JoinColumn(name = "codDNIoNIE")
	private Futbolista futbolistaXXX;
	
	@ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name = "codEquipo")
	private Equipo equipoXXX;

	

	@Column(columnDefinition = "date")
	private Date fechaInicio;

	@Column(columnDefinition = "date")
	private Date fechaFin;

	@Column(columnDefinition = "int(11)")
	private int precioAnual;

	@Column(columnDefinition = "int(11)")
	private int precioRecision;

	public Contrato() {
		
	}
	
	public Contrato(Futbolista futbolistaXXX, Equipo equipoXXX, Date fechaInicio, Date fechaFin, int precioAnual,
			int precioRecision) {
		this.futbolistaXXX = futbolistaXXX;
		this.equipoXXX = equipoXXX;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.precioAnual = precioAnual;
		this.precioRecision = precioRecision;
	}

	public int getCodContrato() {
		return codContrato;
	}

	public void setCodContrato(int codContrato) {
		this.codContrato = codContrato;
	}

	public Futbolista getFutbolistaXXX() {
		return futbolistaXXX;
	}

	public void setFutbolistaXXX(Futbolista futbolistaXXX) {
		this.futbolistaXXX = futbolistaXXX;
	}
	
	public Equipo getEquipoXXX() {
		return equipoXXX;
	}

	public void setEquipoXXX(Equipo equipoXXX) {
		this.equipoXXX = equipoXXX;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getPrecioAnual() {
		return precioAnual;
	}

	public void setPrecioAnual(int precioAnual) {
		this.precioAnual = precioAnual;
	}

	public int getPrecioRecision() {
		return precioRecision;
	}

	public void setPrecioRecision(int precioRecision) {
		this.precioRecision = precioRecision;
	}

	@Override
	public String toString() {
		return  codContrato + " | " + futbolistaXXX.getCodDNIoNIE() + " | " + equipoXXX.getCodEquipo()
				+ " | " + fechaInicio + " | " + fechaFin + " | " + precioAnual
				+ " | " + precioRecision;
	}
	
	

}
