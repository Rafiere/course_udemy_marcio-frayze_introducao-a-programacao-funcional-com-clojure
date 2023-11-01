(ns marcio-frayze.aula36-mapas.aula36-mapas)

;;Abaixo, temos um mapa vazio.
{}

;;Um mapa deverá ter uma chave e um valor. Ambos poderão ser qualquer coisa, de qualquer tipo.

{"nome" "Rafael"}

;;Apesar do Clojure aceitar qualquer tipo de valor para as chaves, por
;;padronização, costumamos utilizar apenas "Keywords" como chaves.

;;A única coisa que não podemos ter é uma chave sem um valor.

{:nome "Rafael"
 :sobrenome "Teste"
 :idade 100}

;;Carrinho de Compras:

;;A vírgula não é obrigatória, mas pode ser utilizada.

(defn compras
  []
  {:tomate {:quantidade 2,
            :preco      5}
   :arroz  {:quantidade 1
            :preco      4}
   :feijao {:quantidade 2
            :preco      10
            }
   })

;;Essa função retornará o mapa acima.
(compras)

;;Obtendo informações de um mapa:

;;A função "get" recebe um mapa e uma chave, e retorna o valor da chave.
;;Se o mapa estiver "nil", será retornado "nil".
(get (compras) :tomate)

;;Podemos utilizar o mapa como uma função, e passarmos a chave desse mapa para
;;obtermos o valor dessa chave.
;;Se o mapa estiver "nil", será lançado um NullPointerException.
((compras) :tomate)

;;Podemos utilizar a chave como uma função, e passarmos o mapa para obtermos o
;;valor dessa chave.
;;Se o mapa estiver "nil", será retornado "nil".
(:tomate (compras))

;;O "get" é a forma mais utilizada.

;;Para recuperarmos apenas o "preco" de um "tomate", temos algumas formas:

;;Será retornado o preço do tomate, que é "5".
(:preco (:tomate (compras)))

;;Se não encontrarmos um valor, podemos retornar um valor padrão:
;;Será retornado um objeto com a quantidade 0 e o preço 0 ao invés de "nil".
(:batata (compras) {:quantidade 0, :preco 0})