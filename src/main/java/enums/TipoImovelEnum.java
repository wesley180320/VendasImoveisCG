package enums;

public enum TipoImovelEnum {

	CASA("Casa"), APARTAMENTO("Apartamento"), TERRENO("Terreno"), COMERCIAL("Comercial"), SOBRADO("Sobrado"),
	CHACARA("Chácara"), SITIO("Sítio"), FAZENDA("Fazenda"), COBERTURA("Cobertura"), KITNET("Kitnet"), LOFT("Loft"),
	SALA_COMERCIAL("Sala Comercial"), GALPAO("Galpão"), PREDIO("Prédio"), CONDOMINIO("Condomínio");

	private final String descricao;

	TipoImovelEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
