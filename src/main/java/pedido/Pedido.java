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
        double total= 0;
        for(ItemPedido item : itens){
            double itemPreco = 0;
            itemPreco+=(cardapio.buscarPreco(item.getShake().getBase())*item.getShake().getTipoTamanho().getMultiplicador());
//            itemPreco+=cardapio.getPrecos().get(item.getShake().getFruta());
//            itemPreco+=cardapio.getPrecos().get(item.getShake().getTopping());
            for(Adicional adicional : item.getShake().getAdicionais()){
                itemPreco+=cardapio.buscarPreco(adicional);
            }
            itemPreco*=item.getQuantidade();
            total+=itemPreco;
        }
        return total;
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado){
        boolean duplicated = false;
        for(ItemPedido item :itens){
            if(item.getShake().equals(itemPedidoAdicionado.getShake())){
                item.setQuantidade(item.getQuantidade()+itemPedidoAdicionado.getQuantidade());
                duplicated = true;
            }
        }
        if(!duplicated) itens.add(itemPedidoAdicionado);
    }

    public boolean removeItemPedido(ItemPedido itemPedidoRemovido) {
        if (itens.stream().anyMatch(item -> item.getShake().toString().equals(itemPedidoRemovido.getShake().toString()))) {//TODO: verify only equals
            for(ItemPedido item : itens){
                if(item.getShake().toString().equals(itemPedidoRemovido.getShake().toString())){
                    if((item.getQuantidade()-1)==0){
                        itens.remove(item);
                    } else item.setQuantidade(item.getQuantidade()-1);
                    break;
                }
            }
            return true;
        } else {
            throw new IllegalArgumentException("Item nao existe no pedido.");
        }
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
