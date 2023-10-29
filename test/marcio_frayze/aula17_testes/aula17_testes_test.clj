(ns marcio-frayze.aula17-testes.aula17-testes-test
  (:require [clojure.test :refer :all]
            [marcio-frayze.aula17-testes.aula17-testes :refer :all]))

;;Basicamente, estamos pegando todas as funções do namespace que está sendo testado e
;;importando para o namespace de testes, para que elas possam ser testadas.

;;ENUNCIADO

;;Se o valor da compra for até 100, deve-se cobrar 15 reais de taxa de entrega.
;;Se for maior que 100 e menor que 200, 5 reais.
;;Se for acima de 200, a taxa é gratuita.


;;O "testing" não é obrigatório, mas ele definirá o que estamos testando.

;;O '(is)" é uma asserção. Ele vai verificar se o valor "15" será igual ao valor da função "taxa-entrega" quando passarmos o valor "1".

(deftest nao-sei-test
  (testing "Dado um valor abaixo de 100 reais, então a taxa de entrega deve ser de 15 reais."
    (is (= 15 (taxa-de-entrega 1)))
    (is (= 15 (taxa-de-entrega 100))))
  (testing "Dado um valor entre 100 e 200 reais, então a taxa de entrega deve ser de 5 reais."
    (is (= 5 (taxa-de-entrega 101)))
    (is (= 5 (taxa-de-entrega 199))))
  (testing "Dado um valor acima de 200 reais, então a taxa de entrega deve ser gratuita."
    (is (= 0 (taxa-de-entrega 201)))))
