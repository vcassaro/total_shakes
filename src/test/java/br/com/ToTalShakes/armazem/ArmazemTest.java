package br.com.ToTalShakes.armazem;

import br.com.ToTalShakes.exceptions.DuplicatedIngredienteException;
import br.com.ToTalShakes.exceptions.IngredienteNotFoundException;
import br.com.ToTalShakes.ingredientes.Base;
import br.com.ToTalShakes.ingredientes.Ingrediente;
import br.com.ToTalShakes.ingredientes.TipoBase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArmazemTest {

    Armazem armazem;

    //Usado para testar alterações e duplicidades
    Ingrediente baseSorvete;
    //Usado para cadastrar novo
    Ingrediente baseIogurte;
    //Usado para testar não cadastrado
    Ingrediente baseLeite;

    @BeforeAll
    void setUp(){
        armazem = new Armazem();
        baseSorvete =  new Base(TipoBase.Sorvete);;
        baseIogurte =  new Base(TipoBase.Iogurte);;
        baseLeite =  new Base(TipoBase.Leite);;
    }

    @BeforeEach
    void init() {
        armazem.estoque.put(baseSorvete, 5);
    }

    @AfterEach
    void tearDown() {
        if(armazem.estoque.size()>0) armazem.estoque.clear();
    }

    @DisplayName("Cadastro do item no estoque com sucesso.")
    @Test
    void cadastrarIngredienteEmEstoque_properly() {
        armazem.cadastrarIngredienteEmEstoque(baseIogurte);
        Assertions.assertAll(
                () -> Assertions.assertTrue(armazem.getEstoque().containsKey(baseIogurte)),
                () -> Assertions.assertEquals(0, armazem.getEstoque().get(baseIogurte))
        );
    }

    @DisplayName("Cadastro de item duplicado no estoque com retorno DuplicatedIngredienteException.")
    @Test
    void cadastrarIngredienteEmEstoque_ingredienteDuplicado_duplicatedIngredienteException() {
        Assertions.assertThrows(DuplicatedIngredienteException.class, () -> {
            armazem.cadastrarIngredienteEmEstoque(baseSorvete);
        });
    }

    @DisplayName("Descadastro do item no estoque com sucesso.")
    @Test
    void descadastrarIngredienteEmEstoque_properly() {
        armazem.descadastrarIngredienteEmEstoque(baseSorvete);
        Assertions.assertFalse(armazem.getEstoque().containsKey(baseSorvete));
    }

    @DisplayName("Descadastro de item não existente no estoque com retorno IngredienteNotFoundException.")
    @Test
    void descadastrarIngredienteEmEstoque_ingredienteNaoCadastrado_ingredienteNotFoundException() {
        Assertions.assertThrows(IngredienteNotFoundException.class, () -> {
            armazem.descadastrarIngredienteEmEstoque(baseLeite);
        });
    }

    @DisplayName("Adição da quantidade de um item no estoque com sucesso.")
    @ParameterizedTest
    @CsvSource(value = {"1,6", "3,8"})
    void adicionarQuantidadeDoIngredienteEmEstoque_properly(int quantidadeAdicional, int quantidadeTotal) {
        armazem.adicionarQuantidadeDoIngredienteEmEstoque(baseSorvete, quantidadeAdicional);
        Assertions.assertEquals(quantidadeTotal, armazem.getEstoque().get(baseSorvete));
    }

    @DisplayName("Adição da quantidade de um item não existente no estoque com retorno IngredienteNotFoundException.")
    @Test
    void adicionarQuantidadeDoIngredienteEmEstoque_ingredienteNaoCadastrado_ingredienteNotFoundException() {
        Assertions.assertThrows(IngredienteNotFoundException.class, () -> {
            armazem.adicionarQuantidadeDoIngredienteEmEstoque(baseLeite, 3);
        });
    }

    @DisplayName("Adição de quantidade menor e igual a zero em um item no estoque com IllegalArgumentException.")
    @ParameterizedTest
    @ValueSource( ints = {0,-1})
    void adicionarQuantidadeDoIngredienteEmEstoque_quantidadeMenorQueZero_illegalArgumentException(int quantidade) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            armazem.adicionarQuantidadeDoIngredienteEmEstoque(baseSorvete, quantidade);
        });
    }

    @DisplayName("Redução da quantidade de um item no estoque com sucesso.")
    @ParameterizedTest
    @CsvSource(value = {"2,3", "5,0"})
    void reduzirQuantidadeDoIngredienteEmEstoque_properly(int quantidadeRuduzir, int quantidadeTotal) {
        armazem.reduzirQuantidadeDoIngredienteEmEstoque(baseSorvete, quantidadeRuduzir);
        Assertions.assertEquals(quantidadeTotal, armazem.getEstoque().get(baseSorvete));
    }

    @DisplayName("Redução da quantidade de um item não existente no estoque com retorno IngredienteNotFoundException.")
    @Test
    void reduzirQuantidadeDoIngredienteEmEstoque_ingredienteNaoCadastrado_ingredienteNotFoundException() {
        Assertions.assertThrows(IngredienteNotFoundException.class, () -> {
            armazem.reduzirQuantidadeDoIngredienteEmEstoque(baseLeite, 2);
        });
    }

    @DisplayName("Redução da quantidade menor igual a zero em um item no estoque com retorno IllegalArgumentException.")
    @ParameterizedTest
    @ValueSource( ints = {0,-1})
    void reduzirQuantidadeDoIngredienteEmEstoque_quantidadeMenorQueZero_illegalArgumentException(int quantidade) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            armazem.reduzirQuantidadeDoIngredienteEmEstoque(baseSorvete, quantidade);
        });
    }

    @DisplayName("Redução da quantidade maior que estoque de um item com retorno IllegalArgumentException.")
    @Test
    void reduzirQuantidadeDoIngredienteEmEstoque_estoqueIsuficiente_illegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            armazem.reduzirQuantidadeDoIngredienteEmEstoque(baseSorvete, 6);
        });
    }

    @DisplayName("Consulta da quantidade de um item no estoque com sucesso.")
    @Test
    void consultarQuantidadeDoIngredienteEmEstoque_properly() {
        Assertions.assertEquals(5, armazem.consultarQuantidadeDoIngredienteEmEstoque(baseSorvete));
    }

    @DisplayName("Consulta da quantidade de um item não existente no estoque com retorno IngredienteNotFoundException.")
    @Test
    void consultarQuantidadeDoIngredienteEmEstoque_ingredienteNaoCadastrado_notIngredienteNotFoundException() {
        Assertions.assertThrows(IngredienteNotFoundException.class, () -> {
            armazem.consultarQuantidadeDoIngredienteEmEstoque(baseLeite);
        });
    }
}