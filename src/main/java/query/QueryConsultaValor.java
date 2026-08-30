package query;

import dto.ImovelDTO;
import interfaces.MontarQueryImovelComFiltros;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QueryConsultaValor implements MontarQueryImovelComFiltros {

	@Override
	public String queryConsulta(ImovelDTO imovelDto) {
		if (imovelDto.getValor() != null) {
			return " AND valor <= ?::NUMERIC";
		}
		return "";
	}
	
}
