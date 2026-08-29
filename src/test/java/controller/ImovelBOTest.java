package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import Exception.ImovelException;
import bo.ImovelBOImpl;
import dto.ImovelDTO;
import interfaces.ImovelDao;

public class ImovelBOTest {

	@InjectMocks
	ImovelBOImpl imovelBO;
	
	@Mock 
	ImovelDao imovelDao;

    @BeforeEach
    void setup() throws Exception {

        MockitoAnnotations.openMocks(this);
        
    }
	
	@Test
	void deveBuscarListaImoveis() throws Exception {

		List<ImovelDTO> imoveis = new ArrayList<ImovelDTO>();
		
		imoveis.add(new ImovelDTO());
		
		when(imovelDao.buscarImoveis()).thenReturn(imoveis);
		
        List<ImovelDTO> resultado = imovelBO.buscarImoveis(new ImovelDTO());

        assertEquals(1, resultado.size());
	}
	
	@Test
	void deveLancarExcessaoAoBuscarListaImoveis() throws Exception {

		List<ImovelDTO> imoveis = new ArrayList<ImovelDTO>();
				
		when(imovelDao.buscarImoveis()).thenReturn(imoveis);
		
        assertThrows(ImovelException.class,
                () -> imovelBO.buscarImoveisPorParamentros(new ImovelDTO()));
        
    }
	
}
