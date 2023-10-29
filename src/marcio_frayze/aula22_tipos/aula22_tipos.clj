(ns marcio-frayze.aula22-tipos.aula22-tipos)

(defn soma
  [x y]
  (+ x y))

(defn imprime-soma
  []
  (println (soma 1 2)))

(defn imprime-soma-2
  []
  (println (soma 2.0 2.0)))

;;Ao executarmos o código abaixo, tomaremos um "ClassCastException", pois estamos
;;passando duas strings para uma função que não aceita strings. O Clojure é
;;uma linguagem fortemente tipada, mas não estática. Isso significa que o Clojure
;;não verifica os tipos de dados em tempo de compilação, mas em tempo de execução.
(defn imprime-soma-3
  []
  (println (soma "2" "2")))

;;O Clojure possui uma função chamada "type", que retorna o tipo de dado de um valor.
(type 10)                                                   ;;Long
(type 10.0)                                                 ;;Double
(type "10")                                                 ;;String
(type (/ 10 3))                                             ;;Ratio - Tipo do Clojure
(type (* 3 (/ 10 3)))                                       ;;BigInt - Tipo do Clojure
(type 10N)                                                  ;;Podemos forçar o BigInt. - Tipo do Clojure
(type 10M)                                                  ;;Podemos forçar o BigDecimal.
(type nil)                                                  ;;nil - Tipo Especial
(type [])                                                   ;;PersistentVector - Tipo do Clojure
(type ())                                                   ;;PersistentList - Tipo do Clojure
(type println)                                              ;;É uma função declarada no pacote "clojure.core".

;;O Clojure possui uma função chamada "class", que retorna o tipo de dado de um valor.
(class 10)