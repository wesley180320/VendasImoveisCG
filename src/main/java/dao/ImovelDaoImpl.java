package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ImovelDTO;
import interfaces.ImovelDao;
import interfaces.MontarParametrosImovelComFiltros;
import interfaces.MontarQueryImovelComFiltros;
import interfaces.ValidadorFiltroImovel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import model.Imovel;
import util.SqlUtil;

@ApplicationScoped
public class ImovelDaoImpl implements ImovelDao {

	@Inject
	private Instance<MontarQueryImovelComFiltros> montarQueryComFiltros;

	@Inject
	private Instance<MontarParametrosImovelComFiltros> montarParametrosComFiltros;

	private static final String SALVAR_IMOVEL = "INSERT INTO imovel (fotoImovel, titulo, cidade, valor) "
			+ "VALUES (?, ?, ?, ?, ?)";
	private static final String DELETAR_IMOVEL_POR_ID = "DELETE FROM imovel WHERE idImovel = ?";

	private static final String ATUALIZAR_IMOVEL_POR_ID = "UPDATE imovel SET fotoImovel = ?, titulo = ?, cidade = ?, valor = ? WHERE idImovel = ?";

	private static final String BUSCAR_IMOVEIS_POR_ID = "SELECT id_Imovel, foto_Imovel, titulo, cidade, valor FROM imovel WHERE id_Imovel = ?";

	private static final String BUSCAR_IMOVEIS = "SELECT id_Imovel, foto_Imovel, titulo, cidade, tipo_imovel AS tipoImovel, finalidade_imovel AS finalidadeImovel, valor FROM imovel";

	private static final String BUSCAR_IMOVEL = "SELECT id_Imovel, foto_Imovel, titulo, cidade, tipo_imovel AS tipoImovel, finalidade_imovel AS finalidadeImovel, valor FROM imovel WHERE 1=1 ";

	@Override
	public void salvarImovel(ImovelDTO imovelDto) throws SQLException {
		SqlUtil.getInstance().executeQueryPorParametros(SALVAR_IMOVEL, Imovel.class, imovelDto.getFotoImovel(),
				imovelDto.getTitulo(), imovelDto.getCidade(), imovelDto.getValor());
	}

	@Override
	public Imovel buscarImolvelPorId(Integer imovelId) throws SQLException {
		return SqlUtil.getInstance().executeQueryPorParametros(BUSCAR_IMOVEIS_POR_ID, Imovel.class, imovelId);
	}

	@Override
	public void deletarImovelPorId(Integer imovelId) throws SQLException {
		SqlUtil.getInstance().executeQueryPorParametros(DELETAR_IMOVEL_POR_ID, Imovel.class, imovelId);
	}

	@Override
	public List<ImovelDTO> buscarImoveis() throws SQLException {
		return SqlUtil.getInstance().executeQuery(BUSCAR_IMOVEIS, ImovelDTO.class);
	}

	@Override
	public List<ImovelDTO> buscarImoveisPorParamentros(ImovelDTO imovelDTO) throws SQLException {
		return SqlUtil.getInstance().executeQueryListaPorParametros(montarQueryComFiltros(imovelDTO), ImovelDTO.class,
				montarParametros(imovelDTO).toArray());
	}

	@Override
	public String montarQueryComFiltros(ImovelDTO imovelDto) {

		StringBuilder query = new StringBuilder(BUSCAR_IMOVEL);

		for (MontarQueryImovelComFiltros montar : montarQueryComFiltros) {
			query.append(montar.queryConsulta(imovelDto));
		}
		return query.toString();
	}

	@Override
	public List<Object> montarParametros(ImovelDTO imovelDTO) {

		List<Object> parametros = new ArrayList<>();

		for (MontarParametrosImovelComFiltros montar : montarParametrosComFiltros) {
			if (montar.montar(imovelDTO) != "") {
				parametros.add(montar.montar(imovelDTO));
			}
		}
		return parametros;
	}
}
