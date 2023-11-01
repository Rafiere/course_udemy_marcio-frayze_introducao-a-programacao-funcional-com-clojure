(ns marcio-frayze.aula30-filter-map-e-reduce.aula30-filter-map-e-reduce)

;;Nessa aula, aprenderemos essas funções na prática.

;;Imagine que tenhamos um vetor de números onde cada número representa o ano
;;que a estudante está.

;;Exemplo: [5 6 6] -> Temos um estudante no quinto ano e dois no sexto.

;;Desafio 1: Crie uma função que recebe este vetor como entrada e retorna a
;;quantidade de estudantes que estão no quinto ano.

;;Vetor inicial: [5 5 6 7 8 6 5 5]


;;O primeiro parâmetro da função "filter" é um predicado, e o segundo parâmetro
;;É a coleção que queremos fazer o filtro.

;;Para cada elemento da coleção, o "filter" aplicará o predicado e retornará
;;apenas os elementos que retornarem "true" na função do "predicado". Se for um
;;false, vamos descartar o elemento.

(defn esta-no-quinto-ano?
  [ano]
  (= ano 5))

(defn quantidade-estudantes-no-quinto-ano
  [estudantes]
  (count (filter esta-no-quinto-ano? estudantes)))

(quantidade-estudantes-no-quinto-ano [5 5 6 7 8 6 5 5])


;;Podemos resolver o problema acima utilizando funções anônimas, por exemplo:

(defn quantidade-de-estudantes-no-quinto-ano-anonima
  [estudantes]
  (count (filter #(= % 5) estudantes)))

(quantidade-de-estudantes-no-quinto-ano-anonima [5 5 6 7 8 6 5 5])

;;Na programação funcional, temos um código que possui a visão declarativa. Não precisamos de
;;uma variável para armazenar os valores, e criar um loop para iterar sob eles. Com a programação
;;funcional, conseguimos enxergar de forma declarativa o que é cada coisa.

;;Desafio 2: Crie uma função que recebe um vetor de idades e retorna a soma.
;;Ex: (soma-das-idades [5 10 5]) deve retornar 20.

(defn soma-das-idades
  [idades]
  (reduce + idades))

(soma-das-idades [5 10 5])

;;Sempre devemos olhar a estrutura de dados que temos de entrada e pensar em quais valores
;;devemos utilizar para transformar a estrutura atual na estrutura desejada.

;;O reduce funciona de uma forma parecida com o filter. Ele recebe uma função e uma coleção. A
;;função que passamos para o reduce deve receber dois parâmetros, e o primeiro parâmetro é o
;;resultado da função anterior. O segundo parâmetro é o elemento da coleção que está sendo
;;processado no momento. Para cada elemento da coleção, o reduce vai aplicar a função que
;;passamos para ele, e o resultado dessa função será o primeiro parâmetro da próxima função.

;;Basicamente, se temos uma estrutura de dados com muitas coisas e queremos apenas um elemento, podemos
;;utilizar o "reduce".


;;Podemos utilizar a função "reduce" com dois e com três parâmetros.

;;A função que será passada para o "reduce", que, nesse caso, é o "+", também deverá ter
;;um comportamento para quando passarmos zero elementos.


;;Desafio 03

;;Crie uma função que recebe um vetor de nomes e retorne o tamanho médio dos nomes.

;;Ex: (tamanho-medio-dos-nomes ["Jurema", "Lorena"]) ; Deve retornar 6.

(defn tamanho-medio-dos-nomes
  [nomes]
  (/ (reduce + (map count nomes)) (count nomes)))

;;O "map" sempre retornará a mesma estrutura com a mesma quantidade de elementos.

;;O "map" receberá uma função que espera um argumento como entrada, e ela terá um determinado
;;retorno. O "map" vai executar essa função para cada elemento da coleção, e o resultado será
;;uma nova coleção com o mesmo tamanho da coleção original, mas com os valores transformados.

;;Um dos objetivos desse curso é pararmos de enxergar a programação como algo imperativo e começarmos
;;a enxergar a programação como algo declarativo.

;;Desafio 04

;; Crie uma função que recebe um vetor de nomes e retorne o tamanho médio dos nomes, mas deve-se ignorar
;;nomes com três ou menos caracteres.

;;Ex: (tamanho-medio-dos-nomes ["Jurema", "Lorena", "Ana"]) ; Deve retornar 6.

(defn tamanho-medio-dos-nomes-com-mais-de-tres-caracteres
  [nomes]
  (let [quantidade-minima-de-caracteres 4
        nomes-com-o-minimo-de-caracteres (filter #(>= (count %) quantidade-minima-de-caracteres) nomes)]
    (/
      (reduce + (map count nomes-com-o-minimo-de-caracteres))
      (count nomes-com-o-minimo-de-caracteres))))

(tamanho-medio-dos-nomes-com-mais-de-tres-caracteres ["Jurema", "Lorena", "Ana"])