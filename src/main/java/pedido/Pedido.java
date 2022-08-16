package pedido;

import ingredientes.Adicional;
import ingredientes.Ingrediente;

import java.util.ArrayList;
import java.util.Map;

public class Pedido{

    private int id;
    private  ArrayList<ItemPedido> itens;
    private Cliente cliente;

    public Pedido(int id, ArrayList<ItemPedido> itens,Cliente cliente){
        this.id = id;
        this.itens=itens;
        this.cliente=cliente;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public int getId(){
        return this.id;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public double calcularTotal(Cardapio cardapio){
        return itens.stream().map(item -> {
            double itemPreco = (cardapio.buscarPreco(item.getShake().getBase())*item.getShake().getTipoTamanho().getMultiplicador());
//            itemPreco+=cardapio.getPrecos().get(item.getShake().getFruta());
//            itemPreco+=cardapio.getPrecos().get(item.getShake().getTopping());
            itemPreco+=item.getShake().getAdicionais().stream().map(cardapio::buscarPreco).reduce(0.0, Double::sum);

            return itemPreco*item.getQuantidade();
        }).reduce(0.0, Double::sum);
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado){
        if (itens == null) throw new NullPointerException("Lista de itens é nula");
        itens.stream().filter(item -> item.getShake().equals(itemPedidoAdicionado.getShake()))
                .findFirst()
                .ifPresentOrElse(
                        item -> item.setQuantidade(item.getQuantidade()+itemPedidoAdicionado.getQuantidade()),
                        () -> {itens.add(itemPedidoAdicionado);});
    }

    public boolean removeItemPedido(ItemPedido itemPedidoRemovido) {
        if (itens == null) throw new NullPointerException("Lista de itens é nula");
        itens.stream().filter(item ->  item.getShake().toString().equals(itemPedidoRemovido.getShake().toString())).findFirst().ifPresentOrElse(item -> {
            item.setQuantidade(item.getQuantidade()-1);
            if(item.getQuantidade()==0) itens.remove(item);
        }, () -> {throw new IllegalArgumentException("Item nao existe no pedido.");});
        return true;
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
