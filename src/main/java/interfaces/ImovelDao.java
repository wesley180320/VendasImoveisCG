package interfaces;

import java.sql.SQLException;
import java.util.List;

import dto.ImovelDTO;
import model.Imovel;

public interface ImovelDao {

	void salvarImovel(ImovelDTO imovelDto) throws SQLException;
	Imovel buscarImolvelPorId(Integer imovelId)throws SQLException;
	void deletarImovelPorId(Integer imovelId)throws SQLException;
	List<ImovelDTO> buscarImoveis()throws SQLException;
	List<ImovelDTO> buscarImoveisPorParamentros(ImovelDTO imovelDTO)throws SQLException;
	String montarQueryComFiltros(ImovelDTO imovelDto);
	List<Object> montarParametros(ImovelDTO imovelDTO);
}
