package pedido;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {
    private int id;
    private String nome;
    private String email;

    public Cliente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public void serializarCliente(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            fos = new FileOutputStream("./Clientes/Cliente-" + this.id + ".txt");
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

    public static Cliente desserializarCliente(int id){
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            fis = new FileInputStream("./Clientes/Cliente-" + id + ".txt");
            ois = new ObjectInputStream(fis);

            @SuppressWarnings("unchecked") Cliente cliente = (Cliente) ois.readObject();

            return cliente;
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
            fos = new FileOutputStream("./Clientes/NumeroClientes.txt");
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

    public static int desserializarNumeroClientes(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            fis = new FileInputStream("./Clientes/NumeroClientes.txt");
            ois = new ObjectInputStream(fis);

            @SuppressWarnings("unchecked") int numero = (int) ois.readObject();

            return numero;
        }catch(FileNotFoundException e){
            System.out.println("Ainda não há clientes registrados.");
            return 0;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return 0;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;

        Cliente cliente = (Cliente) o;

        if (id != cliente.id) return false;
        if (!nome.equals(cliente.nome)) return false;
        return email.equals(cliente.email);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nome.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    public static List<Cliente> desserializarClientes(){
        List<Cliente> clientes = new ArrayList<>();
        for (int i = 1 ; i <= desserializarNumeroClientes(); i++){
            clientes.add(desserializarCliente(i));
        }
        return clientes;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.nome + " - " + this.email;
    }
}
