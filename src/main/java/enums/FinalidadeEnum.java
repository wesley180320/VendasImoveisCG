package enums;

public enum FinalidadeEnum {

	VENDA("Venda"), ALUGUEL("Aluguel");

	private final String descricao;

	FinalidadeEnum(String descricao) {
        this.descricao = descricao;
    }

	public String getDescricao() {
		return descricao;
	}
}
