package query;

import dto.ImovelDTO;
import interfaces.MontarParametrosImovelComFiltros;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ParametroConsultaFinalidadeImovel implements MontarParametrosImovelComFiltros {

	@Override
	public String montar(ImovelDTO imovelDto) {
		if (imovelDto.getFinalidadeImovel() != null) {
			return imovelDto.getFinalidadeImovel().toString();
		}
		return "";
	}

}
