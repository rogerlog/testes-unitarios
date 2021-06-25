package test.java.io.github.rogerlog;

import main.java.io.github.rogerlog.entidades.Filme;
import main.java.io.github.rogerlog.entidades.Locacao;
import main.java.io.github.rogerlog.servicos.LocacaoService;
import main.java.io.github.rogerlog.utils.DataUtils;
import main.java.io.github.rogerlog.entidades.Usuario;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class LocacaoServiceTest {

    @Test
    public void teste() {

        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuário 1");
        Filme filme = new Filme("Filme 1", 2, 5.0);

        Locacao locacao = service.alugarFilme(usuario, filme);

        Assert.assertTrue(locacao.getValor() == 5.0);
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));


    }

}
