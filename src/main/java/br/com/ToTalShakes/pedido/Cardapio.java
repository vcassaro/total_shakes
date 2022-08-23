package br.com.ToTalShakes.pedido;

import br.com.ToTalShakes.ingredientes.Ingrediente;

import java.util.TreeMap;

public class Cardapio {
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
