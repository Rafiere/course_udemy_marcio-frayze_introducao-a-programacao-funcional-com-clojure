(ns marcio-frayze.aula23-namespaces-e-simbolos.aula23-namespaces-e-simbolos_test

(:require [clojure.test :refer :all]
          [marcio-frayze.aula23-namespaces-e-simbolos.aula23-namespaces-e-simbolos :refer [imposto-retido-fonte]]))

;;Enunciado

;;Os valores abaixo de 1000 reais não têm imposto retido na fonte.
;;Acima disso, pagam 10% de imposto.

(deftest imposto-retido-fonte-test
  (testing "Deve calcular o imposto retido na fonte corretamente."
    (is (= 0 (imposto-retido-fonte 999.00)))
    (is (= 100.0 (imposto-retido-fonte 1000.00)))
    (is (= 1000.0 (imposto-retido-fonte 10000.00)))))