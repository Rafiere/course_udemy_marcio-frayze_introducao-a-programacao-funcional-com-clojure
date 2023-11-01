(ns marcio-frayze.aula37-mais-sobre-mapas.aula37-mais-sobre-mapas)

;;Operações já vistas com vetores

(conj [1 2 3 4] 5)

(conj [1 2 3] 4 5)

(conj [1 2 3] "Teste")

(conj [1 2 3] [4 5])

(pop [1 2 3])

(peek [1 2 3])

;;Operações com mapas:

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

;;Essa função não funciona no mapa, pois ele não possui uma ordem interna.
;;Os vetores guardam as ordens, os mapas, não.
(peek (compras))

;;Teremos o mesmo erro, porque não conseguimos retirar o último valor de um mapa, pois
;;ele não é ordenado.
(pop (compras))

;;Agora, funcionará. O "conj" juntará dois mapas, enquanto que o "assoc" criará um mapa novo com
;;os elementos adicionados.
(conj (compras) {:alface {:quantidade 1 :preco 8}})

;;A função "assoc" recebe um mapa, uma chave e um valor, e retorna um novo mapa com
;;a chave e o valor adicionados.
(assoc (compras) :alface {:quantidade 2, :preco 8})

;;A função "dissoc" recebe um mapa e uma chave, e retorna um novo mapa sem a chave
;;passada como parâmetro.
(dissoc (compras) :tomate)

;;Conseguimos passar várias chaves para removê-las todas de uma vez.
(dissoc (compras) :arroz :tomate)


;;Atualizando um valor em um mapa de uma melhor forma do que o assoc.

;;Essa função soma "1" ao valor passado por parãmetro.
(inc 39)

(update {:nome "Rafa" :idade "100"} :idade inc)
