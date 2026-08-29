package query;

import dto.ImovelDTO;
import interfaces.MontarParametrosImovelComFiltros;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ParametroConsultaValor implements MontarParametrosImovelComFiltros {

	@Override
	public String montar(ImovelDTO imovelDto) {
		if (imovelDto.getValor() != null) {
			return imovelDto.getValor().toString();
		}
		return "";
	}

}
