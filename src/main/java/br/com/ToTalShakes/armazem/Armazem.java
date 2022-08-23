package br.com.ToTalShakes.armazem;

import br.com.ToTalShakes.exceptions.DuplicatedIngredienteException;
import br.com.ToTalShakes.exceptions.IngredienteNotFoundException;
import br.com.ToTalShakes.ingredientes.Ingrediente;

import java.util.TreeMap;

public class Armazem {

    TreeMap<Ingrediente, Integer> estoque;


    public Armazem() {
        this.estoque = new TreeMap<>();
    }
    public Armazem(TreeMap<Ingrediente, Integer> estoque) {
        this.estoque = estoque;
    }

    public TreeMap<Ingrediente, Integer> getEstoque() {
        return estoque;
    }

    public void cadastrarIngredienteEmEstoque(Ingrediente ingrediente) throws DuplicatedIngredienteException {
        verificarIngredienteDuplicado(ingrediente);
        estoque.put(ingrediente, 0);
    }

    public void descadastrarIngredienteEmEstoque(Ingrediente ingrediente) throws IngredienteNotFoundException {
        verificarIngredienteNaoRegistrado(ingrediente);
        estoque.remove(ingrediente);
    }

    public void adicionarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) throws IllegalArgumentException, IngredienteNotFoundException {
        verificarIngredienteNaoRegistrado(ingrediente);
        verificarQuatidadeMenorOuIgualZero(quantidade);
        estoque.replace(ingrediente,(estoque.get(ingrediente)+quantidade));
    }

    public void reduzirQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) throws IllegalArgumentException, IngredienteNotFoundException {
        verificarIngredienteNaoRegistrado(ingrediente);
        verificarQuatidadeMenorOuIgualZero(quantidade);
        verificarEstoqueInsuficiente(ingrediente, quantidade);
        estoque.replace(ingrediente, (estoque.get(ingrediente)-quantidade));
    }

    public Integer consultarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente) throws IngredienteNotFoundException {
        verificarIngredienteNaoRegistrado(ingrediente);
        return estoque.get(ingrediente);
    }

    public void verificarIngredienteNaoRegistrado(Ingrediente ingrediente) throws IngredienteNotFoundException {
        if(!estoque.containsKey(ingrediente)) throw new IngredienteNotFoundException("Ingrediente não encontrado.");
    }

    public void verificarIngredienteDuplicado(Ingrediente ingrediente) throws DuplicatedIngredienteException{
        if(estoque.containsKey(ingrediente)) throw new DuplicatedIngredienteException("Ingrediente já cadastrado.");
    }

    public void verificarQuatidadeMenorOuIgualZero(Integer quantidade) throws IllegalArgumentException{
        if(quantidade<=0) throw new IllegalArgumentException("Quantidade invalida.");
    }

    public void verificarEstoqueInsuficiente(Ingrediente ingrediente, Integer quantidade) throws IllegalArgumentException{
        if((estoque.get(ingrediente)-quantidade)<0) throw new IllegalArgumentException("Quantidade invalida.");
    }
}