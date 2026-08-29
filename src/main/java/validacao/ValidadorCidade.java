package validacao;

import dto.ImovelDTO;
import interfaces.ValidadorFiltroImovel;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ValidadorCidade implements ValidadorFiltroImovel {

	@Override
	public boolean validar(ImovelDTO imovelDTO) {
		return imovelDTO.getCidade() != null;
	}

}
