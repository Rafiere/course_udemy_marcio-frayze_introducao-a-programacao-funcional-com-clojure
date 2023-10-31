(ns marcio-frayze.aula26-implementando-solucoes-sem-o-uso-de-funcao-de-primeira-ordem.aula26-implementando-solucoes-sem-o-uso-de-funcoes-de-primeira-ordem)

;;Enunciado

;;Se o salário é abaixo de 1000 reais, não tem imposto. Acima ou igual a 1000, deve aplicar
;;imposto padrão.

(defn imposto-retido
  [salario]
  (let [imposto-padrao 0.2]
    (if (< salario 1000)
      0
      (* salario imposto-padrao))))

;; Essa função simula uma chamada HTTP para consultar a taxa padrão de imposto.
(defn consulta-taxa-padrao-por-http
  []
  0.20)

;(imposto-retido 1000)

;;Solução sem o uso de função de primeira ordem

(defn imposto-retido
  [salario]
  (let [imposto-padrao 0.2]
    (if (< salario 1000)
      0
      (* salario (consulta-taxa-padrao-por-http)))))        ;;Quando o salário for maior ou igual a 1000, ele chamará essa função.

;(imposto-retido 1000)

;;O problema da função acima é que acoplamos a função "imposto-retido" com a função
;;"consulta-taxa-padrao-por-http". Não conseguimos mudar a taxa, por exemplo, para ser obtida
;;através de outra função.

;; UTILIZANDO FUNÇÕES DE PRIMEIRA ORDEM

;;Ao invés de executarmos uma função e passarmos o resultado dela como parâmetro, vamos
;;passar a função como parâmetro.

;;Se tiramos os parênteses, estamos apenas referenciando a função, e não a executando.

(defn imposto-retido
  [consulta-taxa-padrao salario]
    (if (< salario 1000)
      0
      (* salario (consulta-taxa-padrao))))

(imposto-retido consulta-taxa-padrao-por-http 1000)

;;Com isso, conseguimos passar uma função que será executada APENAS quando necessário. Antes, se
;;passassemos a função com (), ela seria executada, mesmo se, dentro da execução da função
;;"imposto-retido", não caisse no IF para que ela fosse executada.

;;Além disso, conseguimos reaproveitar melhor essa função, pois podemos passar qualquer função para
;;ela, ou seja, qualquer forma de consultar a taxa padrão.

;; CRIANDO UMA FUNÇÃO QUE RETORNA UMA REFERÊNCIA PARA UMA FUNÇÃO

(defn minha-taxa-padrao
  []
  consulta-taxa-padrao-por-http)

;;Temos uma função que está recebendo uma função por parâmetro e passando essa função como
;;parâmetro para a função "imposto-retido".
(imposto-retido (minha-taxa-padrao) 1000)

