package pedido;

import ingredientes.Ingrediente;

import java.io.*;
import java.util.TreeMap;

public class Cardapio implements Serializable {
    private TreeMap<Ingrediente,Double> precos;

    public Cardapio(){
        this.precos= new TreeMap<>();
    }

    public TreeMap<Ingrediente, Double> getPrecos(){
        return this.precos;
    }

    public void adicionarIngrediente(Ingrediente ingrediente,Double preco){
        validarPrecoPositivo(preco);
        precos.put(ingrediente, preco);
    }

    public boolean atualizarIngrediente(Ingrediente ingrediente,Double preco){
        validarPrecoPositivo(preco);
        verificarRegistroDeIngrediente(ingrediente);
        if(precos.replace(ingrediente, preco)==null) throw new RuntimeException("Erro ao atualizar ingrediente.");
        return true;
    }

    public boolean removerIngrediente(Ingrediente ingrediente) {
        verificarRegistroDeIngrediente(ingrediente);
        if(precos.remove(ingrediente)==null) throw new RuntimeException("Erro ao remover ingrediente.");
        return true;
    }

    public Double buscarPreco(Ingrediente ingrediente){
        verificarRegistroDeIngrediente(ingrediente);
        return precos.get(ingrediente);
    }

    public void serializarCardapio(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            fos = new FileOutputStream("Cardapio.txt");
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

    public static Cardapio desserializarCardapio(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            fis = new FileInputStream("Cardapio.txt");
            ois = new ObjectInputStream(fis);

            @SuppressWarnings("unchecked") Cardapio cardapio = (Cardapio) ois.readObject();

            return cardapio;
        }catch(FileNotFoundException e){
            System.out.println("Cardapio vazio, registre itens para que possam ser feito pedidos.");
            return new Cardapio();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro: "+e.getMessage());
            return new Cardapio();
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

    @Override
    public String toString() {
        return this.precos.toString();
    }

    public void validarPrecoPositivo(Double preco){
        if(preco<=0) throw new IllegalArgumentException("Preco invalido.");
    }

    public void verificarRegistroDeIngrediente(Ingrediente ingrediente){
        if(!precos.containsKey(ingrediente)) throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
    }
}
