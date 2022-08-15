import ingredientes.*;
import pedido.Cardapio;
import pedido.Cliente;
import pedido.ItemPedido;
import pedido.Pedido;
import produto.Shake;
import produto.TipoTamanho;

import java.io.IOException;
import java.util.*;

public class ToTalShakeApplication {
    static Scanner scanner = new Scanner(System.in);
    static Cardapio cardapio = Cardapio.desserializarCardapio();
    public static void main(String[] args) throws IOException {
        System.out.print("Deseja:\n1-Manipular itens no cardapio\n2-Fazer um pedido\n3-Encerrar programa\n");
        int num = scanner.nextInt();
        limparBuffer(scanner);
        if (num == 1){
            cadastrarCardapio();
        } else if (num == 2) {
            gerarPedido(verificarRegistro());
        }
    }

    public static void cadastrarCardapio() {
        System.out.println(cardapio.toString());
        System.out.print("Deseja:\n1-Registrar item no cardapio\n2-Atualizar item no cardapio\n3-Remover item no cardapio\n4-Encerrar programa\n");
        int num = scanner.nextInt();
        limparBuffer(scanner);
        switch (num){
            case 1 : {
                System.out.print("O item desejado é: \n1-Base\n2-Fruta\n3-Cobertuta\n");
                int num1 = scanner.nextInt();
                limparBuffer(scanner);
                switch (num1){
                    case 1 : {
                        Ingrediente ingrediente = null;
                        boolean valorBaseInvalido = false;
                        do{
                            System.out.print("Escolha o item:\n1-Iorgute\n2-Sorvete\n3-Leite\n");
                            int numBase = scanner.nextInt();
                            limparBuffer(scanner);
                            if (numBase==1)ingrediente= new Base(TipoBase.Iorgute);
                            else if (numBase==2)ingrediente= new Base(TipoBase.Sorvete);
                            else if (numBase==3)ingrediente= new Base(TipoBase.Leite);
                            else {
                                valorBaseInvalido=true;
                                System.out.println("O valor fornecido é invalido!!!");
                            }
                        }while (valorBaseInvalido);
                        System.out.print("Preço do item: ");
                        double preco = scanner.nextDouble();
                        limparBuffer(scanner);
                        cardapio.adicionarIngrediente(ingrediente, preco);
                        cardapio.serializarCardapio();
                        break;
                    }
                    case 2 : {
                        Ingrediente ingrediente = null;
                        boolean valorFrutaInvalido=false;
                        do{
                            System.out.print("Escolha o item:\n1-Morango\n2-Banana\n3-Abacate\n");
                            int numFruta = scanner.nextInt();
                            limparBuffer(scanner);
                            if (numFruta==1)ingrediente= new Fruta(TipoFruta.Morango);
                            else if (numFruta==2)ingrediente= new Fruta(TipoFruta.Banana);
                            else if (numFruta==3)ingrediente= new Fruta(TipoFruta.Abacate);
                            else {
                                valorFrutaInvalido=true;
                                System.out.println("O valor fornecido é invalido!!!");
                            }
                        }while (valorFrutaInvalido);
                        System.out.print("Preço do item: ");
                        double preco = scanner.nextDouble();
                        limparBuffer(scanner);
                        cardapio.adicionarIngrediente(ingrediente, preco);
                        cardapio.serializarCardapio();
                        break;
                    }
                    case 3 : {
                        Ingrediente ingrediente = null;
                        boolean valorToppingInvalido=false;
                        do{
                            System.out.print("\"Escolha o item:\n1-Aveia\n2-Mel\n3-Chocolate\n");
                            int numCobertura = scanner.nextInt();
                            limparBuffer(scanner);
                            if (numCobertura==1)ingrediente= new Topping(TipoTopping.Aveia);
                            else if (numCobertura==2)ingrediente= new Topping(TipoTopping.Mel);
                            else if (numCobertura==3)ingrediente= new Topping(TipoTopping.Chocolate);
                            else {
                                valorToppingInvalido=true;
                                System.out.println("O valor fornecido é invalido!!!");
                            }
                        }while (valorToppingInvalido);
                        System.out.print("Preço do item: ");
                        double preco = scanner.nextDouble();
                        limparBuffer(scanner);
                        cardapio.adicionarIngrediente(ingrediente, preco);
                        cardapio.serializarCardapio();
                        break;
                    }
                    default: return;
                }
                cadastrarCardapio();
                break;
            }
            case 2 : {
                System.out.print("O item desejado é: \n1-Base\n2-Fruta\n3-Cobertuta\n");
                int num1 = scanner.nextInt();
                limparBuffer(scanner);
                Ingrediente ingrediente = null;
                switch (num1){
                    case 1 : {
                        boolean valorBaseInvalido = false;
                        do{
                            System.out.print("Escolha o item:\n1-Iorgute\n2-Sorvete\n3-Leite\n");
                            int numBase = scanner.nextInt();
                            limparBuffer(scanner);
                            if (numBase==1)ingrediente=converterStringIngrediente("Iorgute");
                            else if (numBase==2)ingrediente=converterStringIngrediente("Sorvete");
                            else if (numBase==3)ingrediente=converterStringIngrediente("Leite");
                            else {
                                valorBaseInvalido=true;
                                System.out.println("O valor fornecido é invalido!!!");
                            }
                        }while (valorBaseInvalido);
                        System.out.print("Preço do item: ");
                        double preco = scanner.nextDouble();
                        limparBuffer(scanner);
                        cardapio.atualizarIngrediente(ingrediente, preco);
                        break;
                    }
                    case 2 : {
                        boolean valorFrutaInvalido=false;
                        do{
                            System.out.print("\"Escolha o item:n1-Morango\n2-Banana\n3-Abacate\n");
                            int numFruta = scanner.nextInt();
                            limparBuffer(scanner);
                            if (numFruta==1)ingrediente=converterStringIngrediente("Morango");
                            else if (numFruta==2)ingrediente=converterStringIngrediente("Banana");
                            else if (numFruta==3)ingrediente=converterStringIngrediente("Abacate");
                            else {
                                valorFrutaInvalido=true;
                                System.out.println("O valor fornecido é invalido!!!");
                            }
                        }while (valorFrutaInvalido);
                        System.out.print("Preço do item: ");
                        double preco = scanner.nextDouble();
                        limparBuffer(scanner);
                        cardapio.atualizarIngrediente(ingrediente, preco);
                        break;
                    }
                    case 3 : {
                        boolean valorToppingInvalido=false;
                        do{
                            System.out.print("\"Escolha o item:\n1-Aveia\n2-Mel\n3-Chocolate\n");
                            int numCobertura = scanner.nextInt();
                            limparBuffer(scanner);
                            if (numCobertura==1)ingrediente=converterStringIngrediente("Aveia");
                            else if (numCobertura==2)ingrediente=converterStringIngrediente("Mel");
                            else if (numCobertura==3)ingrediente=converterStringIngrediente("Chocolate");
                            else {
                                valorToppingInvalido=true;
                                System.out.println("O valor fornecido é invalido!!!");
                            }
                        }while (valorToppingInvalido);
                        System.out.print("Preço do item: ");
                        double preco = scanner.nextDouble();
                        limparBuffer(scanner);
                        cardapio.atualizarIngrediente(ingrediente, preco);
                        break;
                    }
                    default: return;
                }
                cadastrarCardapio();
                break;
            }
            case 3 : {
                Ingrediente ingrediente = null;
                System.out.print("O item desejado é: \n1-Base\n2-Fruta\n3-Cobertuta\n");
                int num1 = scanner.nextInt();
                limparBuffer(scanner);
                switch (num1){
                    case 1 : {
                        boolean valorBaseInvalido = false;
                        do{
                            System.out.print("Escolha o item:\n1-Iorgute\n2-Sorvete\n3-Leite\n");
                            int numBase = scanner.nextInt();
                            limparBuffer(scanner);
                            if (numBase==1)ingrediente=converterStringIngrediente("Iorgute");
                            else if (numBase==2)ingrediente=converterStringIngrediente("Sorvete");
                            else if (numBase==3)ingrediente=converterStringIngrediente("Leite");
                            else {
                                valorBaseInvalido=true;
                                System.out.println("O valor fornecido é invalido!!!");
                            }
                        }while (valorBaseInvalido);
                        break;
                    }
                    case 2 : {
                        boolean valorFrutaInvalido=false;
                        do{
                            System.out.print("\"Escolha o item:n1-Morango\n2-Banana\n3-Abacate\n");
                            int numFruta = scanner.nextInt();
                            limparBuffer(scanner);
                            if (numFruta==1)ingrediente=converterStringIngrediente("Morango");
                            else if (numFruta==2)ingrediente=converterStringIngrediente("Banana");
                            else if (numFruta==3)ingrediente=converterStringIngrediente("Abacate");
                            else {
                                valorFrutaInvalido=true;
                                System.out.println("O valor fornecido é invalido!!!");
                            }
                        }while (valorFrutaInvalido);
                        break;
                    }
                    case 3 : {
                        boolean valorToppingInvalido=false;
                        do{
                            System.out.print("\"Escolha o item:\n1-Aveia\n2-Mel\n3-Chocolate\n");
                            int numCobertura = scanner.nextInt();
                            limparBuffer(scanner);
                            if (numCobertura==1)ingrediente=converterStringIngrediente("Aveia");
                            else if (numCobertura==2)ingrediente=converterStringIngrediente("Mel");
                            else if (numCobertura==3)ingrediente=converterStringIngrediente("Chocolate");
                            else {
                                valorToppingInvalido=true;
                                System.out.println("O valor fornecido é invalido!!!");
                            }
                        }while (valorToppingInvalido);
                        break;
                    }
                    default: return;
                }
                cardapio.removerIngrediente(ingrediente);
                cadastrarCardapio();
                break;
            }
            default: return;
        }
    }

    public static Cliente verificarRegistro() throws IOException {
        Cliente cliente = null;
        boolean verificadorRegistro = false;
        List<Cliente> clientes = Cliente.desserializarClientes();
        do {
            if (!clientes.isEmpty()){
                System.out.println("Você possue Registro no sistema?(S/N)");
                char caracter = (char) System.in.read();
                if (caracter == 's' || caracter == 'S') {
                    System.out.print("Digite seu E-mail:");
                    String email = scanner.next();
                    limparBuffer(scanner);
                    Optional<Cliente> clienteOptional = clientes.stream().filter(clienteRegistro -> clienteRegistro.getEmail().equals(email)).findAny();
                    if(clienteOptional.isEmpty()){
                        verificadorRegistro=true;
                        System.out.println("Usuario não encontrado, tente novamente ou realize o cadastro.");
                    }
                } else {
                    System.out.println("Preencha os dados do cadastro");
                    System.out.print("Digite seu nome:");
                    String name = scanner.next();
                    limparBuffer(scanner);
                    System.out.print("Digite seu e-mail:");
                    String email = scanner.next();
                    limparBuffer(scanner);
                    cliente = new Cliente(Cliente.desserializarNumeroClientes() + 1, name, email);
                    Cliente.serealizarNumeroClientes(Cliente.desserializarNumeroClientes() + 1);
                    cliente.serializarCliente();

                }
            } else {
                System.out.println("Preencha os dados do cadastro");
                System.out.print("Digite seu nome:");
                String name = scanner.next();
                limparBuffer(scanner);
                System.out.print("Digite seu e-mail:");
                String email = scanner.next();
                limparBuffer(scanner);
                cliente = new Cliente(1, name, email);
                Cliente.serealizarNumeroClientes(1);
                cliente.serializarCliente();
            }

        }while (verificadorRegistro);
        return cliente;
    }

    public static void gerarPedido(Cliente cliente) throws IOException {
        Pedido pedido = new Pedido(Pedido.desserializarNumeroPedidos()+1, gerarItensPedido(new ArrayList<>()), cliente);
        System.out.print("Deseja:\n1-Registrar\n2-Visualizar\n");
        int num = scanner.nextInt();
        limparBuffer(scanner);
        if (num == 1){
            pedido.serializarPedido();
            Pedido.serealizarNumeroClientes(Pedido.desserializarNumeroPedidos()+1);
            System.out.print("Pedido Registrado\nObrigado e volte sempre!!!");
        } else if (num == 2) {
            visualizarPedido(pedido);
        }
    }

    public static ArrayList<ItemPedido> gerarItensPedido(ArrayList<ItemPedido> itens) throws IOException {
        System.out.println("Escolha os ingredientes do shake");
        boolean valorBaseInvalido=false;
        Base base = null;
        do{
            System.out.print("Base:\n1-Iorgute\n2-Sorvete\n3-Leite\n");
            int numBase = scanner.nextInt();
            limparBuffer(scanner);
            if (numBase==1)base= (Base) converterStringIngrediente("Iorgute");
            else if (numBase==2)base= (Base) converterStringIngrediente("Sorvete");
            else if (numBase==3)base= (Base) converterStringIngrediente("Leite");
            else {
                valorBaseInvalido=true;
                System.out.println("O valor fornecido é invalido!!!");
            }
        }while (valorBaseInvalido);


        boolean valorFrutaInvalido=false;
        Fruta fruta = null;
        do{
        System.out.print("Fruta:\n1-Morango\n2-Banana\n3-Abacate\n");
        int numFruta = scanner.nextInt();
        limparBuffer(scanner);
        if (numFruta==1)fruta= (Fruta) converterStringIngrediente("Morango");
        else if (numFruta==2)fruta= (Fruta) converterStringIngrediente("Banana");
        else if (numFruta==3)fruta= (Fruta) converterStringIngrediente("Abacate");
        else {
                valorFrutaInvalido=true;
                System.out.println("O valor fornecido é invalido!!!");
            }
        }while (valorFrutaInvalido);

        boolean valorToppingInvalido=false;
        Topping topping = null;
        do{
        System.out.print("Cobertura\n1-Aveia\n2-Mel\n3-Chocolate\n");
        int numCobertura = scanner.nextInt();
        limparBuffer(scanner);
        if (numCobertura==1)topping= (Topping) converterStringIngrediente("Aveia");
        else if (numCobertura==2)topping= (Topping) converterStringIngrediente("Mel");
        else if (numCobertura==3)topping= (Topping) converterStringIngrediente("Chocolate");
        else {
                valorToppingInvalido=true;
                System.out.println("O valor fornecido é invalido!!!");
            }
        }while (valorToppingInvalido);

        System.out.println("Deseja algum adicional no shake?(S/N)");
        char caracterAdicional = (char)System.in.read();
        limparBuffer(scanner);
        List<Adicional> adicionais = new ArrayList<>();
        if(caracterAdicional=='s'||caracterAdicional=='S'){
            adicionais = adicionarIngrediente(adicionais);
        }

        boolean valorTamanhoInvalido=false;
        TipoTamanho tamanho = null;
        do{
        System.out.print("Qual o tamanho desejado? \nP-pequeno\nM-medio\nG-grande\n");
        char tamanhoChar = (char)System.in.read();
        limparBuffer(scanner);
            if (tamanhoChar=='p'||tamanhoChar=='P')tamanho= TipoTamanho.P;
            else if (tamanhoChar=='m'||tamanhoChar=='M')tamanho= TipoTamanho.M;
            else if (tamanhoChar=='g'||tamanhoChar=='G')tamanho= TipoTamanho.G;
            else {
                valorTamanhoInvalido=true;
                System.out.println("O valor fornecido é invalido!!!");
            }
        }while (valorTamanhoInvalido);

        System.out.print("Quantos desses shakes você vai querer: ");
        int quantidade = scanner.nextInt();
        limparBuffer(scanner);
        itens.add(new ItemPedido(new Shake(base,fruta,topping, TipoTamanho.valueOf(String.valueOf(tamanho)),adicionais), quantidade));//Adicionar ingredientes

        System.out.println("Deseja adicionar outro shake ao pedido?(S/N)");
        char caracterNewShake = (char)System.in.read();
        if(caracterNewShake=='s'||caracterNewShake=='S'){
            gerarItensPedido(itens);
        }
        return itens;
    }

    public static List<Adicional> adicionarIngrediente(List<Adicional> adicionais) throws IOException {
        boolean valorAdicionalInvalido=false;
        Adicional adicional = null;
        do {
            System.out.print("Escolha o adicional: \n1-Iorgute\n2-Sorvete\n3-Leite\n4-Morango\n5-Banana\n6-Abacate\n7-Aveia\n8-Mel\n9-Chocolate\n");
            int num = scanner.nextInt();
            limparBuffer(scanner);
            switch (num){
                case 1 : {
                    adicional = (Adicional) converterStringIngrediente("Iorgute");
                    break;
                }
                case 2 : {
                    adicional = (Adicional) converterStringIngrediente("Sorvete");
                    break;
                }
                case 3 : {
                    adicional = (Adicional) converterStringIngrediente("Leite");
                    break;
                }
                case 4 : {
                    adicional = (Adicional) converterStringIngrediente("Morango");
                    break;
                }
                case 5 : {
                    adicional = (Adicional) converterStringIngrediente("Banana");
                    break;
                }
                case 6 : {
                    adicional = (Adicional) converterStringIngrediente("Abacate");
                    break;
                }
                case 7 : {
                    adicional = (Adicional) converterStringIngrediente("Aveia");
                    break;
                }
                case 8 : {
                    adicional = (Adicional) converterStringIngrediente("Mel");
                    break;
                }
                case 9 : {
                    adicional = (Adicional) converterStringIngrediente("Chocolate");
                    break;
                }
                default: valorAdicionalInvalido=true;
            }

        }while (valorAdicionalInvalido);
        adicionais.add(adicional);
        System.out.println("Deseja outro adicional no shake?(S/N)");
        char caracter = (char)System.in.read();
        limparBuffer(scanner);
        if(caracter=='s'||caracter=='S'){
            adicionarIngrediente(adicionais);
        }
        return adicionais;
    }

    public static void visualizarPedido(Pedido pedido) throws IOException {
        System.out.println(pedido.toString());
        System.out.print("Deseja:\n1-Excluir shake (uma unidade por vez)\n2-Deletar pedido\n3-Adicionar outro shake\n");
        int num = scanner.nextInt();
        limparBuffer(scanner);
        switch (num){
            case 1 : {
                System.out.println("Escolha qual shake você deseja excluir uma unidade:");
                int i=1;
                for(ItemPedido item : pedido.getItens()){
                    System.out.println(i+"- "+item.toString());
                    i++;
                }
                int numAdicional = scanner.nextInt();
                limparBuffer(scanner);
                pedido.removeItemPedido(pedido.getItens().get(--numAdicional));
                visualizarPedido(pedido);
            }
                break;
            case 2 : {
                System.out.println("Deseja refazer o pedido?(S/N)");
                char caracter = (char)System.in.read();
                limparBuffer(scanner);
                if(caracter=='s'||caracter=='S'){
                    gerarPedido(pedido.getCliente());
                }else return;
            }
                break;
            case 3 : {
                gerarItensPedido(pedido.getItens()).forEach(pedido::adicionarItemPedido);
                visualizarPedido(pedido);
            }
        }
    }

    private static void limparBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    private static Ingrediente converterStringIngrediente(String ingredienteString){
        for(Map.Entry<Ingrediente, Double> entry : cardapio.getPrecos().entrySet()) {
            if(entry.getKey().obterTipo().toString().equals(ingredienteString)){
                return entry.getKey();
            }
        }
        return null;
    }
}
