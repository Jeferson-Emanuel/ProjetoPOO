package br.upe.ProjetoPOO.Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String tipo_espaco;
	private LocalDate data;
	private LocalTime horaInicio;
	private LocalTime horaFim;
	private String morador;
	


	/**
	 * Constructors da classe
	 */

	public Reserva() {
	}
	public Reserva(String tipo_espaco, LocalDate data, LocalTime horaInicio, LocalTime horaFim, String morador) {
		this.tipo_espaco=tipo_espaco;
		this.data=data;
		this.horaInicio=horaInicio;
		this.horaFim=horaFim;
		this.morador=morador;
	}
	
	/**
	 * Métodos de get e set
	 *  @return Retorna nos métodos get, o valor pedido do objeto da classe
	 *  e os set definem o valor do objeto
	 */
	public int getId() {
		return id;
	}	
	public String getMorador() {
		return morador;
	}
	public void setMorador(String morador) {
		this.morador = morador;
	}
	public String getTipo_espaco() {
		return tipo_espaco;
	}	
	public LocalTime getHoraInicio() {
		return horaInicio;
	}	
	public LocalTime getHoraFim() {
		return horaFim;
	}	
	public LocalDate getData() {
		return data;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public void setTipo_espaco(String tipo_espaco) {
		this.tipo_espaco = tipo_espaco;
	}	
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio=horaInicio;
	}	
	public void setHoraFim(LocalTime horaFim) {
		this.horaFim=horaFim;
	}
	public void setData(LocalDate data) {
		this.data=data;
	}
	@Override
	public String toString() {
		return "Reserva " + tipo_espaco;
	}	
}