package main.java.io.github.rogerlog.servicos;

import main.java.io.github.rogerlog.entidades.Filme;
import main.java.io.github.rogerlog.entidades.Locacao;
import main.java.io.github.rogerlog.entidades.Usuario;

import java.util.Date;

import static main.java.io.github.rogerlog.utils.DataUtils.adicionarDias;

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


}