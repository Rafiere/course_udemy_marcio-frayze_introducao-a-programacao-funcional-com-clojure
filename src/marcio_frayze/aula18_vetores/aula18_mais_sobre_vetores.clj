(ns marcio_frayze.aula18_vetores.aula18-mais-sobre-vetores)

(conj ["Batata", "Arroz", "Feijão"] "Banana")               ;;Será criada uma nova lista com os elementos da lista original e o novo elemento adicionado ao final da lista.
(pop ["Batata" "Arroz" "Feijão"])                           ;;Será criada uma nova lista com os elementos da lista original, exceto o último elemento.

(defn desistir-ultima-compra
  [compras]
  (pop compras))                                            ;;Será criada uma nova lista com os elementos da lista original, exceto o último elemento.

(desistir-ultima-compra ["Arroz", "Feijão", "Banana"])

(pop ["Banana"])

(defn imprime-primeiro-nome
  [nomes]
  (println (nomes 0)))                                      ;;Será impresso o primeiro elemento da lista.

(defn imprime-primeiro-nome-2
  [nomes]
  (println (first nomes)))                                  ;;Será impresso o primeiro elemento da lista.

(defn substituir-primeiro-nome
  [nomes novo-primeiro-nome]
  (assoc nomes 0 novo-primeiro-nome))                        ;;Será criada uma nova lista com os elementos da lista original, exceto o primeiro elemento, e o novo primeiro elemento adicionado ao início da lista.

(substituir-primeiro-nome ["Teste 01", "Teste 02", "Teste 03"] "Teste 04")