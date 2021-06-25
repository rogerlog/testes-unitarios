package io.github.rogerlog.servicos;

import static io.github.rogerlog.utils.DataUtils.adicionarDias;

import java.util.Date;

import io.github.rogerlog.entidades.Filme;
import io.github.rogerlog.entidades.Locacao;
import io.github.rogerlog.entidades.Usuario;
import io.github.rogerlog.utils.DataUtils;
import org.junit.Test;
import sun.awt.X11.XSystemTrayPeer;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		return locacao;
	}

	@Test
	public void teste() {

		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuário 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);

		Locacao locacao = service.alugarFilme(usuario, filme);

		System.out.println(locacao.getValor() == 5.0);
		System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));


		
	}
}