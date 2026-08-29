package query;

import dto.ImovelDTO;
import interfaces.MontarQueryImovelComFiltros;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QueryConsultaTipoImovel implements MontarQueryImovelComFiltros {

	@Override
	public String queryConsulta(ImovelDTO imovelDto) {
		if (imovelDto.getTipoImovel() != null) {
			return " AND tipo_imovel = ?";
		}
		return "";
	}

}
