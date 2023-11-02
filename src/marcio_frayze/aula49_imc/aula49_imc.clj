(ns marcio-frayze.aula49-imc.aula49-imc)

;;Desafio: Dado o peso e altura de uma pessoa, calcular o IMC e
;;retornar o indicador do IMC.

;;Estamos criando uma função privada. Ela só estará exposta dentro do IMC.

;;Em geral, não é uma boa prática criarmos testes automatizados para métodos
;;privados.
(defn- valor-imc
  [peso altura]
  (/ peso (* altura altura)))

(defn indicador-imc
  [peso altura]
  (let [resultado-calculo-imc (valor-imc peso altura)]
  (if (< resultado-calculo-imc 18.5)
    :peso-baixo
    (if (< resultado-calculo-imc 24.9)
           :peso-ideal
           :peso-alto))))

(indicador-imc 70 1.70)