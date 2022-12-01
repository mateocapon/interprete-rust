(ns interprete-rust.funciones-implementar.listar)


(defn procesar-literal [literal] 
  ; Agrego un cero para indicar la identacion inicial 0.
  (list literal 0)
)


(defn identar [identado] 
  (if (< identado 1) 
    ""
    (apply str (take identado (repeat " ")))
  )
)

; Agrega la cantidad de espacios necesarios para identar.
(defn agregar-identacion [identado]
  (identar (+ identado 1))
)


; Agrega la cantidad de espacios necesarios para identar.
(defn quitar-identacion [identado]
  (identar (- identado 3)) 
)


(defn procesar-caracteres-especiales [string]
  (if (string? string) (str \"(clojure.string/replace string #"\n|\t" {"\n" "\\n" "\t" "\\t"}) \")
    (clojure.string/replace string #"\n|\t" {"\n" "\\n" "\t" "\\t"})
  )
)

(defn formatear [lista_izq lista_der]
  (let [str_izq (first lista_izq),
        str_der (first lista_der),
        identacion (second lista_izq)]
    (cond 
      (= str_der (symbol "{"))
        (list (str str_izq " " str_der "\n" (agregar-identacion identacion)) (+ identacion 2))
      (= str_der (symbol "}"))
        (list (str str_izq "\n" (identar (- identacion 2)) str_der "\n" (quitar-identacion identacion)) (- identacion 2))
      (= str_der (symbol ";"))
        (list (str str_izq str_der "\n" (identar (- identacion 1))) identacion)
      (= str_der 'fn)
        (list (str str_izq str_der) identacion)
      :else 
        (list (str str_izq " " (procesar-caracteres-especiales str_der)) (second lista_izq))

    )
  )
)


(defn string-imprimir [lista] 
  (first (reduce formatear (map procesar-literal lista))) 
)




;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; LISTAR: Recibe una lista con los tokens de un programa en Rust (o de parte de un programa) y muestra el codigo fuente formateado. Retorna nil.
; Por ejemplo:
; user=> (listar (list 'fn 'main (symbol "(") (symbol ")") (symbol "{") 'println! (symbol "(") "Hola, mundo!" (symbol ")") (symbol "}")))
; fn main ( )
; {
;   println! ( "Hola, mundo!" )
; }
; 
; nil
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn listar [lista]
    (println (string-imprimir lista))
)
