package model;

import java.math.BigDecimal;

import enums.FinalidadeEnum;
import enums.TipoImovelEnum;

public class Imovel {

	private Integer idImovel;
	private byte[] fotoImovel;
	private String titulo;
	private String cidade;
	private BigDecimal valor;
	private TipoImovelEnum tipoImovelEnum;
	private FinalidadeEnum finalidadeImovelEnum;

	public Imovel() {

	}

	public Imovel(Integer idImovel, byte[] fotoImovel, String titulo, String cidade, BigDecimal valor,
			TipoImovelEnum tipoImovelEnum, FinalidadeEnum finalidadeImovelEnum) {
		super();
		this.idImovel = idImovel;
		this.fotoImovel = fotoImovel;
		this.titulo = titulo;
		this.cidade = cidade;
		this.valor = valor;
		this.tipoImovelEnum = tipoImovelEnum;
		this.finalidadeImovelEnum = finalidadeImovelEnum;
	}

	public byte[] getFotoImovel() {
		return fotoImovel;
	}

	public void setFotoImovel(byte[] fotoImovel) {
		this.fotoImovel = fotoImovel;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}

	public TipoImovelEnum getTipoImovelEnum() {
		return tipoImovelEnum;
	}

	public void setTipoImovelEnum(TipoImovelEnum tipoImovelEnum) {
		this.tipoImovelEnum = tipoImovelEnum;
	}

	public FinalidadeEnum getFinalidadeImovelEnum() {
		return finalidadeImovelEnum;
	}

	public void setFinalidadeImovelEnum(FinalidadeEnum finalidadeImovelEnum) {
		this.finalidadeImovelEnum = finalidadeImovelEnum;
	}
}
