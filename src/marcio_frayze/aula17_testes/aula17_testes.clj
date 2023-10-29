(ns marcio-frayze.aula17-testes.aula17-testes)

;;ENUNCIADO

;;Se o valor da compra for até 100, deve-se cobrar 15 reais de taxa de entrega.
;;Se for maior que 100 e menor que 200, 5 reais.
;;Se for acima de 200, a taxa é gratuita.
(defn taxa-de-entrega
  [valor-da-compra]
  (let [taxa-de-entrega-para-valor-ate-100 15
        taxa-de-entrega-para-valor-ate-200 5
        taxa-de-entrega-para-valor-maior-que-200 0]
  (if (<= valor-da-compra 100)
    taxa-de-entrega-para-valor-ate-100
    (if (<= valor-da-compra 200)
      taxa-de-entrega-para-valor-ate-200
      taxa-de-entrega-para-valor-maior-que-200))))