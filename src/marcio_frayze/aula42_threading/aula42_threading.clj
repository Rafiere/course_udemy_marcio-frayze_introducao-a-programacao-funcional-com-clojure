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


;;Aula 02

;;Para iterarmos em uma lista de mapas, ou seja, um vetor de mapas,
;;A função ":nome" pegará o valor de todas as chaves "nome" de todos os mapas, que estão
;;no array de disciplinas.
(defn retirar-apenas-o-nome-de-uma-disciplina-em-um-mapa
  [disciplinas]
  (map :nome disciplinas))

(defn transformar-em-maiusculo
  [nomes-das-disciplinas]
  (map clojure.string/upper-case nomes-das-disciplinas))


;;A função "join" serve para juntarmos uma lista com vários elementos, por exemplo:

(defn juntar-nomes-em-uma-unica-string-separada-por-virgula
  [nomes-das-disciplinas]
  (clojure.string/join ", " nomes-das-disciplinas))

;;No exemplo abaixo, estamos filtrando a estrutura de dados "disciplinas", que é
;;um vetor de mapas. Estamos passando como parâmetro para o "filter" uma função
;;anônima que cada um dos "%" será um elemento do vetor, ou seja, um mapa, como em
;;{:nome "Algoritmos", :semestre 1}. Através do ":semestre", estamos pegando o valor
;;da chave "semestre" do mapa atual e estamos comparando com o valor "semestre-atual". Se
;;o semestre do mapa for maior ou igual ao semestre atual, retornaremos "true", caso contrário, retornaremos
;;false e descartaremos o mapa.
(defn nomes-disciplinas-restantes
  [disciplinas semestre-atual]
  (juntar-nomes-em-uma-unica-string-separada-por-virgula
    (transformar-em-maiusculo
      (retirar-apenas-o-nome-de-uma-disciplina-em-um-mapa (filter #(>= (:semestre %) semestre-atual) disciplinas)))))

(nomes-disciplinas-restantes (disciplinas) 2)

;;Resolvendo o problema com threading-last:

(defn nomes-disciplinas-restantes
  [disciplinas semestre-atual]
  (->> disciplinas
       (filter #(>= (:semestre %) semestre-atual))
       (map :nome)
       (map clojure.string/upper-case)
       (clojure.string/join ", ")))

(nomes-disciplinas-restantes (disciplinas) 2)