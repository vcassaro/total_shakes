package br.com.ToTalShakes.demo;

import br.com.ToTalShakes.ingredientes.*;
import br.com.ToTalShakes.pedido.Cardapio;
import br.com.ToTalShakes.pedido.Cliente;
import br.com.ToTalShakes.pedido.ItemPedido;
import br.com.ToTalShakes.pedido.Pedido;
import br.com.ToTalShakes.produto.Shake;
import br.com.ToTalShakes.produto.TipoTamanho;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1,"Pedro","pedro@email.com");
        Cardapio cardapio = new Cardapio();

        Base sorvete = new Base(TipoBase.Sorvete);
        Base iogurte = new Base(TipoBase.Iogurte);
        Fruta banana = new Fruta(TipoFruta.Banana);
        Fruta morango = new Fruta(TipoFruta.Morango);
        Topping mel = new Topping(TipoTopping.Mel);
        Topping aveia = new Topping(TipoTopping.Aveia);

        cardapio.adicionarIngrediente(sorvete,10.0);
        cardapio.adicionarIngrediente(iogurte,8.0);
        cardapio.adicionarIngrediente(banana,5.0);
        cardapio.adicionarIngrediente(morango,7.5);
        cardapio.adicionarIngrediente(mel,1.0);
        cardapio.adicionarIngrediente(aveia, 3.0);

        Shake shake1 = new Shake(sorvete,banana,mel, TipoTamanho.P);

        ItemPedido itemPedido1 = new ItemPedido(shake1,1);
        Pedido pedido1 = new Pedido(1, new ArrayList<>(List.of(itemPedido1)),cliente);

        System.out.println("::::: Cardapio ShakeCIT");
        System.out.println(cardapio.getPrecos());

        System.out.println("::::: Criando um Shake Básico 1:1:1:0");
        System.out.println(pedido1);
        System.out.println(pedido1.calcularTotal(cardapio));

        System.out.println("::::: Criando um Shake Básico 1:1:1:1");
        Shake shake2 = new Shake(sorvete, banana, mel, TipoTamanho.G, new ArrayList<>(List.of(aveia)));
        ItemPedido itemPedido2 = new ItemPedido(shake2, 1);
        Pedido pedido2 = new Pedido(2, new ArrayList<>(List.of(itemPedido2)), cliente);

        System.out.println(pedido2);
        System.out.println(pedido2.calcularTotal(cardapio));

        System.out.println("::::: Adicionando um Shake igual no mesmo br.com.ToTalShakes.pedido");
        pedido2.adicionarItemPedido(itemPedido2);
        System.out.println(pedido2);
        System.out.println(pedido2.calcularTotal(cardapio));

        System.out.println("::::: Adicionando um Shake diferente no mesmo br.com.ToTalShakes.pedido");
        pedido2.adicionarItemPedido(itemPedido1);
        System.out.println(pedido2);
        System.out.println(pedido2.calcularTotal(cardapio));

        System.out.println("::::: Removendo um itemPedido de um br.com.ToTalShakes.pedido");
        System.out.println(pedido2);
        pedido2.removeItemPedido(itemPedido2);
        System.out.println(pedido2);
        pedido2.removeItemPedido(itemPedido2);
        System.out.println(pedido2);
        pedido2.removeItemPedido(itemPedido1);
        System.out.println(pedido2);

        System.out.println("::::: Item br.com.ToTalShakes.pedido com dois adicionais");
        Shake shake3 = new Shake(iogurte, morango, mel, TipoTamanho.P, new ArrayList<>(List.of(morango, banana)));
        ItemPedido itemPedido3 = new ItemPedido(shake3, 1);
        Pedido pedido3 = new Pedido(3, new ArrayList<>(List.of(itemPedido3)), cliente);
        System.out.println(pedido3);
        System.out.println(pedido3.calcularTotal(cardapio));

        Shake shake4 = new Shake(iogurte, morango, mel, TipoTamanho.P, new ArrayList<>(List.of(banana, morango)));
        ItemPedido itemPedido4 = new ItemPedido(shake4, 2);
        pedido3.adicionarItemPedido(itemPedido4);
        System.out.println(pedido3);
        System.out.println(pedido3.calcularTotal(cardapio));

        System.out.println("::::: Serializando Cliente 1 e Desserializando Cliente 1");
        cliente.serializarCliente();
        Cliente cliente2 = Cliente.desserializarCliente(1);
        System.out.println(cliente2);
        System.out.println(cliente.equals(cliente2));

    }
}
