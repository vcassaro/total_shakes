# ToTal Shakes

```
Desafios criados por:

Arnald da Costa Queiroga @arnald
André Luiz Vieira Mostaro @amostaro
Elvis William De Oliveira Barbieri @ebarbieri
Eric de Sousa Andrade @ericsousa
Jezielle de Fátima Farias da Cunha @jezielle
Rebeca Baptista Fonseca Viana @rebecav
```

<h2>Proposta da semana 1:</h2>
Foi solicitado que fosse criado um sistema para uma Loja de Shakes, e você como desenvolvedor 
recebeu a tarefa de implementá-lo. E para isso você deve seguir as seguintes especificações.


<h3>Dentro do package de Ingrediente temos a seguinte estrutura <code><b>OK</b></code></h3>
<ul>
    <li><code>Interface</code> Ingrediente <code><b>OK</b></code></li>
    <ul>
        <li>Método(s):</li>
        <ul>
            <li>Enum obterTipo();</li>
        </ul>
    </ul>
    <li><code>Interface</code> Adicional <code><b>OK</b></code></li>
        <ul>
            <li>Extends:</li>
            <ul>
                <li>Ingrediente</li>
            </ul>
        </ul>
    <li><code>Enum</code> TipoBase <code><b>OK</b></code></li>
    <ul>
        <li>Valores: Iorgurte, Sorvete e Leite.</li>
    </ul>
    <li><code>Enum</code> TipoTopping <code><b>OK</b></code></li>
    <ul>
        <li>Valores: Aveia, Mel e Chocolate.</li>
    </ul>
    <li><code>Enum</code> TipoFruta <code><b>OK</b></code></li>
    <ul>
        <li>Valores: Morango, Banana e Abacate.</li>
    </ul>
    <li><code>Class</code> Base <code><b>OK</b></code></li>
    <ul>
        <li>Implements:</li>
        <ul>
            <li>Ingrediente</li>
            <li>Comparable&lt;Ingrediente&gt;</li>
        </ul>
    </ul>
    <ul>
        <li>Atributo(s):</li>
        <ul>
            <li><code>private</code> TipoBase tipoBase;</li>
        </ul>
        <li>Método(s):</li>
        <ul>
            <li><code>public</code> Base(TipoBase tipoBase)</li>
            <li><code>public</code> TipoBase getTipoBase()</li>
            <li><code>public</code> Enum obterTipo()</li>
            <li><code>public</code> boolean equals(Object o)</li>
            <li><code>public</code> int hashCode()</li>
            <li><code>public</code> int compareTo(Ingrediente ingrediente)</li>
            <li><code>public</code> String toString()</li>
        </ul>
        </ul>
    <li><code>Class</code> Topping <code><b>OK</b></code></li>
    <ul>
        <li>Implements:</li>
        <ul>
            <li>Adicional</li>
            <li>Comparable&lt;Ingrediente&gt;</li>
        </ul>
    </ul>
    <ul>
        <li>Atributo(s):</li>
        <ul>
            <li><code>private</code> TipoTopping tipoTopping;</li>
        </ul>
        <li>Método(s):</li>
        <ul>
            <li><code>public</code> Topping(TipoTopping tipoTopping)</li>
            <li><code>public</code> TipoTopping getTipoTopping()</li>
            <li><code>public</code> Enum obterTipo()</li>
            <li><code>public</code> boolean equals(Object o)</li>
            <li><code>public</code> int hashCode()</li>
            <li><code>public</code> int compareTo(Ingrediente ingrediente)</li>
            <li><code>public</code> String toString()</li>
        </ul>
    </ul>
    <li><code>Class</code> Fruta <code><b>OK</b></code></li>
    <ul>
        <li>Implements:</li>
        <ul>
            <li>Adicional</li>
            <li>Comparable&lt;Ingrediente&gt;</li>
        </ul>
    </ul>
    <ul>
        <li>Atributo(s):</li>
        <ul>
            <li><code>private</code> TipoFruta tipoFruta;</li>
        </ul>
        <li>Método(s):</li>
        <ul>
            <li><code>public</code> Fruta(TipoFruta tipoFruta)</li>
            <li><code>public</code> TipoFruta getTipoFruta()</li>
            <li><code>public</code> Enum obterTipo()</li>
            <li><code>public</code> boolean equals(Object o)</li>
            <li><code>public</code> int hashCode()</li>
            <li><code>public</code> int compareTo(Ingrediente ingrediente)</li>
            <li><code>public</code> String toString()</li>
        </ul>
    </ul>
</ul>

<h3>Dentro do package de Produto temos a seguinte estrutura <code><b>OK</b></code></h3>
<ul>
    <li><code>Enum</code> TipoTamanho <code><b>OK</b></code></li>
    <ul>
        <li>Valores: P, M, e G</li>
        <li>Implementar regra do fator de multiplicação do tamanho dos shakes (regra 2) no Enum</li>
    </ul>
    <li><code>Class</code> Shake <code><b>OK</b></code></li>
    <ul>
        <li>Atributo(s):</li>
    <ul>
        <li><code>private</code> Base base</li>
        <li><code>private</code> Fruta fruta</li>
        <li><code>private</code> Topping topping</li>
        <li><code>private</code> List&lt;Adicional&gt; adicionais</li>
        <li><code>private</code> TipoTamanho tipoTamanho</li>
    </ul>
    <li>Método(s):</li>
    <ul>
         <li><code>public</code> Shake(Base base, Fruta fruta, Topping topping, List&lt;Adicional&gt; adicionais, TipoTamanho tipoTamanho)</li>
         <li><code>public</code> Shake(Base base, Fruta fruta, Topping topping, TipoTamanho tipoTamanho)</li>
         <li><code>public</code> Base getBase()</li>
         <li><code>public</code> Fruta getFruta()</li>
         <li><code>public</code> Topping getTopping()</li>
         <li><code>public</code> List&lt;Adicional&gt; getAdicionais()</li>
         <li><code>public</code> TipoTamanho getTipoTamanho()</li>
         <li><code>public</code> String toString()</li>
   </ul>
   </ul>
   </ul>

<h3>Dentro do package de Pedido temos a seguinte estrutura <code><b>OK</b></code></h3>
<ul>
    <li><code>Class</code> Cardapio <code><b>OK</b></code></li>
        <ul>
           <li>Atributo(s):</li>
        <ul>
            <li><code>private</code> TreeMap&lt;Ingrediente,Double&gt; precos</li>
    </ul>
    <li>Método(s):</li>
    <ul>
         <li><code>public</code> Cardapio()</li>
         <li><code>public</code> void adicionarIngrediente(Ingrediente ingrediente, Double preco)</li>
         <li><code>public</code> boolean atualizarIngrediente(Ingrediente ingrediente, Double preco)</li>
         <li><code>public</code> boolean removerIngrediente(Ingrediente ingrediente)</li>
         <li><code>public</code> Double buscarPreco(Ingrediente ingrediente)</li>
         <li><code>public</code> String toString()</li>
   </ul>
   </ul>
    <li><code>Class</code> Cliente <code><b>OK</b></code></li>
         <ul>
           <li>Atributo(s):</li>
         <ul>
            <li><code>private</code> int id</li>
            <li><code>private</code> String nome</li>
            <li><code>private</code> String email</li>
         </ul>
         <li>Método(s):</li>
         <ul>
            <li><code>public</code> Cliente(int id, String nome, String email)</li>
            <li><code>public</code> void serializarCliente()</li>
            <li><code>public static</code> Cliente desserializarCliente(int id)</li>
            <li><code>public</code> boolean equals(Object o)</li>
            <li><code>public</code> int hashCode()</li>
            <li><code>public</code> String toString()</li>
         </ul>
         </ul>
    <li><code>Class</code> ItemPedido <code><b>OK</b></code></li>
          <ul>
           <li>Atributo(s):</li>
          <ul>
            <li><code>private</code> Shake shake</li>
            <li><code>private</code> int quantidade</li>
         </ul>
         <li>Método(s):</li>
         <ul>
            <li><code>public</code> ItemPedido(Shake shake, int quantidade)</li>
            <li><code>public</code> Shake getShake()</li>
            <li><code>public</code> int getQuantidade()</li>
            <li><code>public</code> setQuantidade(int quantidade)</li>
            <li><code>public</code> String toString()</li>
         </ul>
         </ul>
    <li><code>Class</code> Pedido <code><b>OK</b></code></li>
       <ul>
           <li>Atributo(s):</li>
          <ul>
            <li><code>private</code> int id</li>
            <li><code>private</code> ArrayList&lt;ItemPedido&gt; itens</li>
            <li><code>private</code> Cliente cliente</li>
         </ul>
         <li>Método(s):</li>
         <ul>
            <li><code>public</code> Pedido(int id, ArrayList&lt;ItemPedido&gt; itens,Cliente cliente)</li>
            <li><code>public</code> ArrayList&lt;ItemPedido&gt; getItens()</li>
            <li><code>public</code> int getId()</li>
            <li><code>public</code> Cliente getCliente()</li>
            <li><code>public</code> double calcularTotal(Cardapio cardapio)</li>
            <li><code>public</code> adicionarItemPedido(ItemPedido itemPedidoAdicionado)</li>
            <li><code>public</code> boolean removeItemPedido(ItemPedido itemPedidoRemovido)</li>
            <li><code>public</code> String toString()</li>
         </ul>
       </ul>
</ul>

<h3>Dentro do package de Demo temos a seguinte estrutura <code><b>OK</b></code></h3>
<ul>
    <li><code>Class</code> Program <code><b>OK</b></code></li>
    <ul>
        <li>Método(s):</li>
        <ul>
            <li><code>public static void</code>main (String[] args)</li>
            <li>Utilize o método main para testar a sua aplicação e verificar se está tendo a saída esperada</li>
        </ul>
    </ul>
</ul>

```
::::: Cardapio ShakeCIT
{Aveia=3.0, Banana=5.0, Iorgute=8.0, Mel=1.0, Morango=7.5, Sorvete=10.0}
::::: Criando um Shake Básico 1:1:1:0
[Sorvete / Banana / Mel / [] / P / x1] - 1 - Pedro - pedro@email.com
10.0
::::: Criando um Shake Básico 1:1:1:1
[Sorvete / Banana / Mel / [Aveia] / G / x1] - 1 - Pedro - pedro@email.com
18.0
::::: Adicionando um Shake igual no mesmo br.com.ToTalShakes.pedido
[Sorvete / Banana / Mel / [Aveia] / G / x2] - 1 - Pedro - pedro@email.com
36.0
::::: Adicionando um Shake diferente no mesmo br.com.ToTalShakes.pedido
[Sorvete / Banana / Mel / [Aveia] / G / x2, Sorvete / Banana / Mel / [] / P / x1] - 1 - Pedro - pedro@email.com
46.0
::::: Removendo um itemPedido de um br.com.ToTalShakes.pedido
[Sorvete / Banana / Mel / [Aveia] / G / x2, Sorvete / Banana / Mel / [] / P / x1] - 1 - Pedro - pedro@email.com
[Sorvete / Banana / Mel / [Aveia] / G / x1, Sorvete / Banana / Mel / [] / P / x1] - 1 - Pedro - pedro@email.com
[Sorvete / Banana / Mel / [] / P / x1] - 1 - Pedro - pedro@email.com
[] - 1 - Pedro - pedro@email.com
::::: Item br.com.ToTalShakes.pedido com dois adicionais
[Iorgute / Morango / Mel / [Banana, Morango] / P / x1] - 1 - Pedro - pedro@email.com
20.5
[Iorgute / Morango / Mel / [Banana, Morango] / P / x3] - 1 - Pedro - pedro@email.com
61.5
::::: Serializando Cliente 1 e Desserializando Cliente 1
1 - Pedro - pedro@email.com
true

Process finished with exit code 0

```

<h3>Regras de negócio <code><b>OK</b></code></h3>
<ul>
    <li><code>Shake</code>:</li>
    <ul>
        <li>Regra 1: um <code>Shake</code> é composto obrigatoriamente de uma <code>Base</code>, uma <code>Fruta</code>, um <code>Topping</code>, um <code>TipoTamanho</code> e opcionalmente por uma <code>List&lt;Adicional&gt;</code></li>
    </ul>
    <li><code>Pedido <code><b>OK</b></code></code>:</li>
    <ul>
        <li>Regra 1: Quando adicionar um novo <code>ItemPedido</code> em um <code>Pedido</code> que já contenha um outro <code>ItemPedido</code> com o mesmo <code>Shake</code> nos dois <code>ItemPedido</code>, então o <code>Pedido</code> deve conter apenas um <code>ItemPedido</code> daquele <code>Shake</code>, porém com a <code>quantidade</code> atualizada do <code>Shake</code></li>
        <li>Regra 2: O preço de um <code>Shake</code> é calculado com o valor da <code>Base</code> de acordo com o <code>TipoTamanho</code>, somado com o custo dos <code>adicionais</code></li>
        <ul>
            <li><code>P</code>: preco da <code>Base</code> original no <code>Cardapio</code></li>
            <li><code>M</code>: preco da <code>Base</code> acrescentado de 30%</li>
            <li><code>G</code>: preco da <code>Base</code> acrescentado de 50%</li>         
        </ul>   
        <li>Regra 3: O custo de um <code>Pedido</code> é o somatório do custo de todos os <code>Shake</code> presentes nos <code>ItemPedido</code> desse <code>Pedido</code> (dica: <code>ItemPedido</code> possui um atributo <code>quantidade</code>)</li>
        <li>Regra 4: A função <code>boolean removeItemPedido(ItemPedido itemPedidoRemovido)</code> deve lançar uma exceção do tipo <code>IllegalArgumentException</code> com a mensagem <code>Item nao existe no br.com.ToTalShakes.pedido.</code> caso o <code>ItemPedido</code> a ser removido não exista no <code>Pedido</code></li>
        <li>Regra 5: A função <code>boolean removeItemPedido(ItemPedido itemPedidoRemovido)</code> irá sempre reduzir apenas UMA unidade do <code>ItemPedido</code>, independente da <code>quantidade</code> que foi informada no parâmetro da função.</li>
    </ul>
    <li><code>Cardapio <code><b>OK</b></code></code>:</li>
    <ul>
        <li>Regra 1: O preco de um <code>Ingrediente</code> deve ser <code>maior que zero</code>, caso contrário irá disparar uma exceção do tipo <code>IllegalArgumentException</code> com a mensagem <code>Preco invalido.</code></li>
        <li>Regra 2: Os métodos <code>boolean atualizarIngrediente(Ingrediente ingrediente,Double preco)</code>, <code>boolean removerIngrediente(Ingrediente ingrediente)</code> e <code>Double buscarPreco(Ingrediente ingrediente)</code> devem disparar uma exceção do tipo <code>IllegalArgumentException</code> com a mensagem <code>Ingrediente nao existe no cardapio.</code> caso o <code>Ingrediente</code> passado como parâmetro não exista no cardápio.</li>
        <li>Regra 3: Os itens do <code>Cardapio</code> devem estar sempre ordenados em ordem alfabética do nome do <code>Ingrediente</code>.</li>
    </ul>
</ul>

<h3>Desafio <code><b>OK</b></code></h3>

```
O seu objetivo é fazer o código funcionar. 
Para isso complete os métodos que estão sem implementação
E faça as correções necessárias nos outros arquivos
Sempre consultando a estrutura e as regras de negócio que foram passadas aqui e verificando
a saída do Program esperada.
```

<h3>Desafio Extra</h3>

```
O seu objetivo agora é fazer uma Interface
Utilizando uma classe chamada Main
Você deve criar uma interface onde o usuario irá fazer o br.com.ToTalShakes.pedido
Armazenando em variaveis todos os dados do br.com.ToTalShakes.pedido 
Você ira salvar esses pedidos em um arquivo
Lembrando algumas classes irão precisar Implementar o Serializable
```

<h2>Proposta da semana 2: </h2>
Após cumprir o desafio do sistema para uma Loja de Shakes, foi solicidado 
a criação de um armazem, para um maior controle dos br.com.ToTalShakes.ingredientes.
Para isso, você como desenvolvedor precisará desenvolver uma classe Armazem 
usando o TDD (Test-driven development) seguindo as seguintes especificações.

<h3>Primeiro passo para a continuação do desafio <code><b>OK</b></code></h3>
No mesmo projeto que foi desenvolvido na semana 1, você irá criar uma nova branch (<code>git checkout -b “feature/week-2”</code>) e desenvolver a solução nela. Após finalizar o desafio, abrir um Pull Request no GitHub (para a main do seu projeto) para que então o grupo possa fazer o Code Review.
<br>

<h3>Criar uma classe Armazém que irá armazenar os Ingredientes e a quantidade de Ingrediente <code><b>OK</b></code></h3>
<ul>
    <li>A classe deve ter um atributo private TreeMap&lt;Ingrediente, Integer&gt; chamado estoque.</li>
    <li>Criar um package chamado armazem e criar a classe Armazem dentro deste package.</li>
</ul>

<h3>Criar um TDD para os seguintes métodos dessa classe: <code><b>OK</b></code></h3>
<ul>
    <li>Método(s):</li>
    <br>
    <ul>
        <li><code>public void cadastrarIngredienteEmEstoque(Ingrediente ingrediente)</code></li>
        <ul>
            <li>Reponsabilidade: Cadastrar no estoque um novo ingrediente. </li>
<li> Regra: A quantidade deve ser setada como zero sempre que for cadastrar um novo ingrediente. </li>
<li> Exception: Caso o ingrediente já esteja cadastrado deve retornar IllegalArgumentException com a seguinte mensagem de erro: “Ingrediente já cadastrado”.</li>
        </ul>
    </ul>
    <ul><br>
        <li><code>public void descadastrarIngredienteEmEstoque(Ingrediente ingrediente)</code></li>
        <ul>
            <li>Responsabilidade: Descadastra o ingrediente do estoque.</li>
<li> Regra: O ingrediente deve ser excluido do estoque. </li>
<li> Exception: Caso o ingrediente não exista no estoque deve retornar IllegalArgumentException com a seguinte mensagem de erro: “Ingrediente não encontrado”.</li>
        </ul>
    </ul>
    <ul><br>
        <li><code>public void adicionarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) </code></li>
        <ul>
            <li>Reponsabilidade: Adicionar uma determinada quantidade de um ingrediente específico no estoque.</li>
<li> Regra: Deve ser somado a quantidade solicitada do ingrediente a quantidade que estava no estoque; a quantidade tem que ser maior que zero e o ingrediente que vai receber a quantidade deve existir no estoque.</li>
<li> Exception: Caso o ingrediente não exista no estoque deve retornar IllegalArgumentException com a seguinte mensagem de erro: “Ingrediente não encontrado” e caso a quantidade que foi passada para ser somada for menor ou igual a zero deve retornar IllegalArgumentException com a seguinte mensagem de erro: “Quantidade invalida” </li>
        </ul>
    </ul>
    <ul><br>
        <li><code>public void reduzirQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade)</code></li>
        <ul>
            <li>Reponsabilidade:Reduzir a quantidade de um determinado ingrediente no estoque. </li>
            <li> Regra: Deve ser subtraído a quantidade solicitada do ingrediente a quantidade que estava no estoque. Caso a quantidade a ser removida seja a mesma da quantidade em estoque, o ingrediente deve ser excluído do estoque.</li>
            <li> Exception: Caso o ingrediente não exista no estoque deve retornar IllegalArgumentException com a seguinte mensagem de erro: “Ingrediente não encontrado” e caso a quantidade que foi passada para ser excluida for menor ou igual a zero e a quantidade em estoque seja insuficiente para ser removida retornar um IllegalArgumentException com a seguinte mensagem de erro: “Quantidade invalida”.</li>
         </ul>
	</ul>
    <ul><br>
        <li><code>public Integer consultarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente)</code></li>
        <ul>
            <li>Reponsabilidade: Busca a quantidade de um determinado ingrediente no estoque. </li>
<li> Exception: Caso o ingrediente não exista no estoque deve retornar IllegalArgumentException com a seguinte mensagem de erro: “Ingrediente não encontrado”. </li>
        </ul>
    </ul>
</ul>

<h3>Atenção</h3>
O objetivo deste desafio é que você escreva primeiro os testes e depois desenvolva a classe (caso tiver dificuldade, escrever os cenários de testes pode ajudar no desenvolvimento).

<h3>Desafio Extra <code><b>OK</b></code></h3>
Refatoração dos testes e do projeto. Tem alguns fatores que podem ser melhorados nos testes e no projeto. Desta forma, você como desenvolvedor deve ter um olhar crítico e levar em consideração as boas práticas de Clean Code e refatorar o projeto. Segue alguns exemplos a serem refatorados: 
<ul>
	<li>Classes de teste: Nomenclatura dos testes, utilização da anotação <code>@DisplayName</code>, substituição dos try/catch por <code>assertThrows</code> e entre outros. </li>
<li>Classe main: Nome do enum em maiúsculo, criação de Exceções específicas (IngredienteNotFoundException, por exemplo), utilização do modificador <code>final</code> e entre outros. </li>
</ul>
Além disso, implementar testes parametrizados nas classes de teste.
