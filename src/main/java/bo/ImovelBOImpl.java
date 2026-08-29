package bo;

import java.sql.SQLException;
import java.util.List;

import Exception.ImovelException;
import dto.ImovelDTO;
import interfaces.ImovelBO;
import interfaces.ImovelDao;
import interfaces.ValidadorFiltroImovel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@ApplicationScoped
public class ImovelBOImpl implements ImovelBO {

	@Inject
    private ImovelDao imovelDao;
	
	@Inject
	private Instance<ValidadorFiltroImovel> validadores;

	public void salvarImovel(ImovelDTO imovelDTO) throws SQLException {
		imovelDao.salvarImovel(imovelDTO);
	}

	@Override
	public ImovelDTO buscarImovelPorId(Integer idImovel) throws ImovelException, SQLException {
		ImovelDTO imovel = new ImovelDTO().from(imovelDao.buscarImolvelPorId(idImovel));
		if (imovel == null) {
			throw new ImovelException("Erro: Imovel nao encontrado idImovel:" + idImovel);
		}
		return imovel;
	}

	@Override
	public void deletarImovelPorId(Integer idImovel) throws ImovelException, SQLException {
		buscarImovelPorId(idImovel);
		imovelDao.deletarImovelPorId(idImovel);
	}

	@Override
	public List<ImovelDTO> buscarImoveis(ImovelDTO imovelDTO) throws ImovelException, SQLException {
		List<ImovelDTO> imoveis = imovelDao.buscarImoveis();
		if (imoveis.isEmpty()) {
			throw new ImovelException("Erro: Imoveis nao encontrados.");
		}
		return imoveis;
	}

	@Override
	public List<ImovelDTO> buscarImoveisPorParamentros(ImovelDTO imovelDTO) throws ImovelException, SQLException {
		List<ImovelDTO> imoveis = imovelDao.buscarImoveisPorParamentros(imovelDTO);
		if (imoveis.isEmpty()) {
			throw new ImovelException("Erro: Imoveis nao encontrados.");
		}
		return imoveis;
	}

	@Override
	public Boolean validarImovelComFiltro(ImovelDTO imovelDTO) {
		for (ValidadorFiltroImovel validador : validadores) {
			if (validador.validar(imovelDTO)) {
				return true;
			}
		}
		return false;
	}
}
