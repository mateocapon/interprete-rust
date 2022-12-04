(ns interprete-rust.funciones-implementar.convertir-formato-impresion)
(use '[clojure.string :only (replace-first)])


(defn generar-lista-a-reemplazar [string]
  (re-seq #"\{:.\d+\}|\{\}" string)
)


(defn nuevo-formato [formato-rust argumento]
  (cond
    (re-matches #"\{:.\d+\}" formato-rust) (str "%." (re-find #"\d+" formato-rust) "f")
    (string? argumento) "%s"
    (char? argumento) "%c"
    (integer? argumento) "%d"
    (float? argumento) "%.0f"
    :else (throw (Exception. "No matchea ningun tipo."))
  )
)

(defn reducir-a-mensaje-formateado [mensaje argumentos lista_reemplazos]
  (if (= (count lista_reemplazos) 0)
    (cons mensaje argumentos)
    (recur 
       (replace-first mensaje #"\{:.\d+\}|\{\}" (first lista_reemplazos))
       argumentos
       (rest lista_reemplazos) 
    )
  )
)


(defn nuevos-formatos [mensaje argumentos]
  (reducir-a-mensaje-formateado mensaje argumentos
    (map nuevo-formato (generar-lista-a-reemplazar mensaje) argumentos)
  )
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; CONVERTIR-FORMATO-IMPRESION: Recibe una lista con los argumentos de print! de Rust y devuelve una lista con los
; argumentos equivalentes de printf de Clojure.
; Por ejemplo:
; user=> (convertir-formato-impresion '("Hola, mundo!"))
; ("Hola, mundo!")
; user=> (convertir-formato-impresion '("- My name is {}, James {}.\n- Hello, {}{}{}!" "Bond" "Bond" 0 0 7))
; ("- My name is %s, James %s.\n- Hello, %d%d%d!" "Bond" "Bond" 0 0 7)
; user=> (convertir-formato-impresion '("{} elevado a la {} es\t{}" 2.0 2 4.0))
; ("%.0f elevado a la %d es\t%.0f" 2.0 2 4.0)
; user=> (convertir-formato-impresion '("Las raices cuadradas de {} son +{:.8} y -{:.8}" 4.0 1.999999999985448 1.999999999985448))
; ("Las raices cuadradas de %.0f son +%.8f y -%.8f" 4.0 1.999999999985448 1.999999999985448)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn convertir-formato-impresion [lista_imprimir]
  (nuevos-formatos (first lista_imprimir) (rest lista_imprimir))
)
