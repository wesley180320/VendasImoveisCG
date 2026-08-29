package query;

import dto.ImovelDTO;
import interfaces.MontarParametrosImovelComFiltros;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ParametroConsultaCidade implements MontarParametrosImovelComFiltros {

	@Override
	public String montar(ImovelDTO imovelDto) {
		if (imovelDto.getCidade() != null && !imovelDto.getCidade().isBlank()) {
			return "%" + imovelDto.getCidade().toUpperCase() + "%";
		}
		return "";
	}

}
