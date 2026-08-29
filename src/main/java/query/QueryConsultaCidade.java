package query;

import dto.ImovelDTO;
import interfaces.MontarQueryImovelComFiltros;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QueryConsultaCidade implements MontarQueryImovelComFiltros {

	@Override
	public String queryConsulta(ImovelDTO imovelDto) {
		if (imovelDto.getCidade() != null && !imovelDto.getCidade().isBlank()) {
			return " AND UPPER(cidade) LIKE ?";
		}
		return "";
	}

}
