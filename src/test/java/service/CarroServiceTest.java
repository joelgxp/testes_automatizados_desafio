package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;

public class CarroServiceTest {
    @Test
    public void deveAcelerarCorretamtente() {
        CarroService carroService = new CarroServiceImpl();

        //dado
        Carro carro = new Carro("azul", "fiat", "uno", 2020, 150);
        carroService.ligar(carro);

        //quando
        carroService.acelerar(carro, 10);

        //entao
        Assert.assertEquals(10, carro.getVelocidadeAtual());
    }

    @Test
    public void naoDevePassarDaVelocidadeMaxima (){
        //dado
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("azul", "fiat", "uno", 2020, 100);
        carroService.ligar(carro);

        //quando


        //entao


    }

    @Test
    public void umCarroDeveIniciarDesligado(){
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("azul", "fiat", "uno", 2020, 100);
        carroService.ligar(carro);

        //entao

        //Assert.assertTrue();
        Assert.assertFalse(carro.isLigado());


    }
}
