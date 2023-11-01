(ns marcio-frayze.aula42-threading.aula42-threading)

;;Enunciado:

;;Desafio: Precisamos criar uma função que, dado um conjunto (vetor) de disciplinas e o
;;semestre do discente, deve:
;; - Filtrar a lista para exibir disciplinas restantes (que sejam do semestre atual ou superior)
;; - Transformar o nome da disciplina para maiúsculo e descartar demais informações.
;; - Criar uma string concatenando o nome de todas as disciplinas filtradas.

;;Exemplo de entrada:
;;[{nome: "Algoritmos", semestre: 1}
;; {nome: "Estrutura de Dados", semestre: 2}
;; {nome: "Inteligência Artificial", semestre: 3}, 2

;;O número "2" representa a partir de qual semestre elas serão filtradas.

;;Saída esperada: "ESTRUTURA DE DADOS, INTELIGÊNCIA ARTIFICIAL"

;;A função abaixo retornará um vetor de mapas.
(defn disciplinas
  []
  [{:nome "Algoritmos" :semestre 1}
   {:nome "Estrutura de Dados" :semestre 2}
   {:nome "Inteligência Artificial" :semestre 3}])

;;Resolvendo o problema sem threading

;;No exemplo abaixo, estamos filtrando a estrutura de dados "disciplinas", que é
;;um vetor de mapas. Estamos passando como parâmetro para o "filter" uma função
;;anônima que cada um dos "%" será um elemento do vetor, ou seja, um mapa, como em
;;{:nome "Algoritmos", :semestre 1}. Através do ":semestre", estamos pegando o valor
;;da chave "semestre" do mapa atual e estamos comparando com o valor "semestre-atual". Se
;;o semestre do mapa for maior ou igual ao semestre atual, retornaremos "true", caso contrário, retornaremos
;;false e descartaremos o mapa.
(defn nomes-disciplinas-restantes
  [disciplinas semestre-atual]
  (filter #(>= (:semestre %) semestre-atual)  disciplinas))

;;Resolvendo o problema com threading