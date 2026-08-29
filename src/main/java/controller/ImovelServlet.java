package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import Exception.ImovelException;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dto.ImovelDTO;
import interfaces.ImovelBO;

@WebServlet("/listarImoveis")
public class ImovelServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ImovelBO imovelBO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ImovelDTO imovelDto = new ImovelDTO();

		imovelDto.setFinalidadeImovel(request.getParameter("tipoNegocio"));
		imovelDto.setTipoImovel(request.getParameter("tipoImovel"));
		imovelDto.setCidade(request.getParameter("cidade"));
		String valorMaximo = request.getParameter("valorMaximo");
		if (valorMaximo != null && !valorMaximo.isBlank()) {
			imovelDto.setValor(new BigDecimal(valorMaximo));
		}

		List<ImovelDTO> imoveis;
		try {
			if (imovelBO.validarImovelComFiltro(imovelDto)) {
				imoveis = imovelBO.buscarImoveisPorParamentros(imovelDto);
			} else {
				imoveis = imovelBO.buscarImoveis(imovelDto);
			}
			request.setAttribute("imoveis", imoveis);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ImovelException e) {
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
