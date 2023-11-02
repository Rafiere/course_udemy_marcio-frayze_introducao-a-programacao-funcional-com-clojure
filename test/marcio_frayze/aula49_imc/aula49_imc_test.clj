(ns marcio-frayze.aula49-imc.aula49-imc-test
  (:require [clojure.test :refer :all]
            [marcio-frayze.aula49-imc.aula49-imc :refer :all]))

;;Cada "testing" é um cenário de teste.
;;Todo teste deve ter ao menos uma asserção, representado pelo "is".
;;Em cenários em que a quantidade de possibilidades é finita, é comum
;;utilizarmos as "Keywords".
(deftest valor-imc-test
  []
  (testing "Uma pessoa muito magra deve ter o IMC baixo."
    (is (= :peso-baixo (indicador-imc 20 1.90))))
  (testing "Uma pessoa com peso ideal deve ter o IMC ideal."
    (is (= :peso-ideal (indicador-imc 70 1.70))))
  (testing "Uma pessoa com sobrepeso deve ter o IMC alto."
    (is (= :peso-alto (indicador-imc 90 1.70)))))

