package query;

import dto.ImovelDTO;
import interfaces.MontarQueryImovelComFiltros;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QueryConsultaFinalidadeImovel implements MontarQueryImovelComFiltros {

	@Override
	public String queryConsulta(ImovelDTO imovelDto) {
		if (imovelDto.getFinalidadeImovel() != null) {
			return " AND finalidade_imovel = ?";
		}
		return "";
	}

}
