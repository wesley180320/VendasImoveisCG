package validacao;

import dto.ImovelDTO;
import interfaces.ValidadorFiltroImovel;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ValidadorValor implements ValidadorFiltroImovel{

	@Override
	public boolean validar(ImovelDTO imovelDTO) {
		return imovelDTO.getValor() != null;
	}

}
