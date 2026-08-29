package query;

import dto.ImovelDTO;
import interfaces.MontarParametrosImovelComFiltros;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ParametroConsultaTipoImovel implements MontarParametrosImovelComFiltros {

	@Override
	public String montar(ImovelDTO imovelDto) {
		if (imovelDto.getTipoImovel() != null) {
			return imovelDto.getTipoImovel().toString();
		}
		return "";
	}

}
