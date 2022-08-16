package pedido;

import ingredientes.Adicional;
import ingredientes.Ingrediente;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class Pedido implements Serializable {

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

    public void serializarPedido(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            fos = new FileOutputStream("./Pedidos/Pedido-" + this.id + ".txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
        }catch(Exception e){
            System.out.println("Nao foi possivel serializar");
        }finally{
            if(oos != null){
                try{
                    oos.close();
                }catch(IOException e){
                    System.out.println("Nao foi possivel fechar o arquivo");
                }
            }
        }
    }

    public static Pedido desserializarPedido(int id){
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            fis = new FileInputStream("./Pedidos/Pedido-" + id + ".txt");
            ois = new ObjectInputStream(fis);

            @SuppressWarnings("unchecked") Pedido pedido = (Pedido) ois.readObject();

            return pedido;
        }catch(Exception e){
            System.out.println("Nao foi possivel desserializar");
            return null;
        }finally{
            if(ois != null){
                try{
                    ois.close();
                }catch(IOException e){
                    System.out.println("Nao foi possivel fechar o arquivo");
                }
            }
        }
    }

    public static void serealizarNumeroClientes(int numeros){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            fos = new FileOutputStream("./Pedidos/NumeroPedidos.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(numeros);
        }catch(Exception e){
            System.out.println("Nao foi possivel serializar");
        }finally{
            if(oos != null){
                try{
                    oos.close();
                }catch(IOException e){
                    System.out.println("Nao foi possivel fechar o arquivo");
                }
            }
        }
    }

    public static int desserializarNumeroPedidos(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            fis = new FileInputStream("./Pedidos/NumeroPedidos.txt");
            ois = new ObjectInputStream(fis);

            @SuppressWarnings("unchecked") int numero = (int) ois.readObject();

            return numero;
        }catch(FileNotFoundException e){
            System.out.println("Ainda não há pedidos registrados.");
            return 0;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return 0;
        } finally{
            if(ois != null){
                try{
                    ois.close();
                }catch(IOException e){
                    System.out.println("Nao foi possivel fechar o arquivo");
                }
            }
        }
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
