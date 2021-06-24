package io.github.rogerlog.servicos;

import static io.github.rogerlog.utils.DataUtils.adicionarDias;

import java.util.Date;

import io.github.rogerlog.entidades.Filme;
import io.github.rogerlog.entidades.Locacao;
import io.github.rogerlog.entidades.Usuario;

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

	public static void main(String[] args) {
		
	}
}