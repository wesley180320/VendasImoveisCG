package dto;

import java.math.BigDecimal;

import enums.FinalidadeEnum;
import enums.TipoImovelEnum;
import model.Imovel;

public class ImovelDTO {

	private Integer idImovel;
	private byte[] fotoImovel;
	private String titulo;
	private String cidade;
	private BigDecimal valor;
	private TipoImovelEnum tipoImovel;
	private FinalidadeEnum finalidadeImovel;

	public ImovelDTO() {

	}

	public ImovelDTO(byte[] fotoImovel, String titulo, String cidade, BigDecimal valor, TipoImovelEnum tipoImovel,
			FinalidadeEnum finalidadeImovel) {
		super();
		this.fotoImovel = fotoImovel;
		this.titulo = titulo;
		this.cidade = cidade;
		this.valor = valor;
		this.tipoImovel = tipoImovel;
		this.finalidadeImovel = finalidadeImovel;
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

	public TipoImovelEnum getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(String tipoImovel) {

		if (tipoImovel != null && tipoImovel != "") {
			this.tipoImovel = TipoImovelEnum.valueOf(tipoImovel);
		}
	}

	public FinalidadeEnum getFinalidadeImovel() {
		return finalidadeImovel;
	}

	public void setFinalidadeImovel(String finalidadeImovel) {

		if (finalidadeImovel != null && finalidadeImovel != "") {
			this.finalidadeImovel = FinalidadeEnum.valueOf(finalidadeImovel);
		}
	}

	public Integer getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}
	
	public ImovelDTO from(Imovel imovel) {
		ImovelDTO dto = new ImovelDTO();
		dto.setCidade(imovel.getCidade());
		dto.setFotoImovel(imovel.getFotoImovel());
		dto.setTitulo(dto.getTitulo());
		dto.setValor(imovel.getValor());
		return dto;
	}

}
