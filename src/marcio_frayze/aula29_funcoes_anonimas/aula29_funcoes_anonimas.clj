(ns marcio-frayze.aula29-funcoes-anonimas.aula29-funcoes-anonimas)

;;O "defn" cria uma função e associa essa função com o nome "dobro".

(defn dobro
  [x]
  (* 2 x))

;;Se utilizarmos o "fn", não temos um símbolo associado à essa função. Ou seja, estamos
;;criando uma função anônima.
(fn
  [x]
  (* 2 x))

;;As funções anônimas normalmente são utilizadas para serem passadas como parâmetro para o
;;método.

;;Abaixo, estamos executando uma função anônima e passando um valor para essa
;;execução. Elas, normalmente, serão utilizadas em "map", "filter" e etc.
((fn
   [x]
   (* 2 x)) 2)

;;Modo simplificado de criar funções anônimas:

#(* 2 %)

;;O símbolo "#" define que queremos criar uma função anônima que
;;não daremos nome para os parâmetros, e a "%" representa os parâmetros
;;que serão passados para a função anônima.

(#(* 2 %) 2)

;;Estamos definindo e utilizando a função anônima acima.

;;Estamos criando uma função anônima com dois argumentos e a
;;executando.
(#(+ %1 %2) 8 9)


;;Essa função retorna uma nova função que sempre vai retornar 0.2.
;;Independentemente dos parâmetros que forem passados para ela, o resultado será
;;sempre 0.2
((constantly 0.2) 1 2 3 4 5)
