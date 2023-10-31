(ns marcio-frayze.aula23-namespaces-e-simbolos.aula23-namespaces-e-simbolos)

(defn imposto-retido-fonte
  [valor]
  (if (< valor 1000)
    0
    (* 0.1 valor)))


;; O "ns" é uma abreviação de namespace. Isso seria a mesma coisa que um pacote no Java.
;; O nome do namespace deve ser o mesmo nome da hierarquia de arquivos.