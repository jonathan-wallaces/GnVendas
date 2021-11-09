package com.gnvendas.gnVendas.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compras")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "comprador_id", referencedColumnName = "comprador_id")
	private Comprador comprador;
	@JoinColumn
	@OneToOne
	private Produto produto;
	private String linkPdf;
	private Long idBoleto;
	public String getLinkPdf() {
		return linkPdf;
	}
	public void setLinkPdf(String linkPdf) {
		this.linkPdf = linkPdf;
	}
	public Long getIdBoleto() {
		return idBoleto;
	}
	public void setIdBoleto(Long idBoleto) {
		this.idBoleto = idBoleto;
	}
	
	

}
