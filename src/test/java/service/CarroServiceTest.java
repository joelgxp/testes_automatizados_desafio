package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarroServiceTest {

    CarroService carroService;

    @Before
    public void setup() {
        carroService = new CarroServiceImpl();

    }

    public void ligarUmCarroEnquantoEstiverDesligado() {

        //dado
        Carro carro = new Carro("prata", "fiat", "uno", 2020, 100);

        //enquanto
        carroService.ligar(carro);

        //entao
        Assert.assertTrue(carro.isLigado());
        System.out.println(carroService.estadoAtual(carro));
    }

    @Test
    public void umCarroDeveDesligaQuandoEstiverLigado() {
        //dado
        Carro carro = new Carro("azul", "fiat", "uno", 2020, 100);

        //enquanto
        carroService.ligar(carro);
        carroService.desligar(carro);

        //entao
        Assert.assertFalse(carro.isLigado());
        System.out.println(carroService.estadoAtual(carro));
    }

    @Test
    public void umCarroLigadoDeveAcelerar() {

        //dado
        Carro carro = new Carro("azul", "fiat", "uno", 2020, 150);
        carroService.ligar(carro);

        //quando
        carroService.acelerar(carro, 10);

        //entao
        Assert.assertEquals(10, carro.getVelocidadeAtual());
        System.out.println(carroService.estadoAtual(carro));

    }

    @Test
    public void umCarroLigadoDeveFrear(){
        //dado
        Carro carro = new Carro("azul", "fiat", "uno", 2020, 150);

        //enquanto
        carroService.ligar(carro);
        carroService.acelerar(carro, 60);
        carroService.frear(carro, 70);

        //entao
        Assert.assertTrue(carro.isLigado());
        System.out.println(carroService.estadoAtual(carro));

    }
 @Test
    public void umCarroDeveAcelerarSomenteLigado(){
        //dado
        Carro carro = new Carro("azul", "fiat", "uno", 2020, 150);

        //enquanto
        carroService.ligar(carro);
        carroService.acelerar(carro, 60);

        //entao
        Assert.assertTrue(carro.isLigado());
        System.out.println(carroService.estadoAtual(carro));

    }
    @Test
    public void umCarroDeveFrearSomenteLigado(){
        //dado
        Carro carro = new Carro("azul", "fiat", "uno", 2020, 150);

        //enquanto
        carroService.ligar(carro);

        carroService.frear(carro, 60);

        //entao
        Assert.assertTrue(carro.getVelocidadeAtual() == 0 && carro.isLigado());
        System.out.println(carroService.estadoAtual(carro));

    }

    @Test
    public void umCarroSoPodeDesligarQuandoEstiverTotalmenteParado(){
        //dado
        Carro carro = new Carro("azul", "fiat", "uno", 2020, 150);

        //enquanto
        carroService.ligar(carro);
        carroService.acelerar(carro, 80);
        carroService.frear(carro, 80);

        //entao
        Assert.assertEquals(0, carro.getVelocidadeAtual());
        System.out.println(carroService.estadoAtual(carro));

    }

    @Test
    public void naoDeveTerVelocidadeNegativa() {
        //dado
        Carro carro = new Carro("azul", "fiat", "uno", 2020, 100);

        //quando
        carroService.ligar(carro);
        carroService.acelerar(carro, 80);
        carroService.frear(carro,100);

        //entao
        Assert.assertTrue(carro.getVelocidadeAtual() < carro.getVelocidadeMaxima());
        System.out.println(carroService.estadoAtual(carro));
    }


}
