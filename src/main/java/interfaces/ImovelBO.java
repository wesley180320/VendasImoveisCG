package interfaces;

import java.sql.SQLException;
import java.util.List;

import dto.ImovelDTO;
import exception.ImovelException;

public interface ImovelBO {

	void salvarImovel(ImovelDTO imovelDTO)throws SQLException;
	ImovelDTO buscarImovelPorId(Integer idImovel) throws ImovelException, SQLException;
	void deletarImovelPorId(Integer idImovel) throws ImovelException, SQLException;
	List<ImovelDTO> buscarImoveis(ImovelDTO imovelDTO) throws ImovelException, SQLException;
	Boolean validarImovelComFiltro(ImovelDTO imovelDTO);
	public List<ImovelDTO> buscarImoveisPorParamentros(ImovelDTO imovelDTO) throws ImovelException, SQLException;;
}
