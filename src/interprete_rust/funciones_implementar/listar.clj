(ns interprete-rust.funciones-implementar.listar)


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

(defn procesar_literal [literal] 
    ; Agrego un cero para indicar la identacion inicial 0.
    (list literal 0)
)


; Agrega la cantidad de espacios necesarios para identar.
(defn agregar_identacion [identado]
  (apply str (take (+ identado 1) (repeat " ")))
)


; Agrega la cantidad de espacios necesarios para identar.
(defn quitar_identacion [identado]
  (if (< identado 1) 
    ""
    (apply str (take (- identado 1) (repeat " ")))
  )  
)


(defn formatear [lista_izq lista_der]
  (let [str_izq (first lista_izq),
        str_der (first lista_der),
        identacion (second lista_izq)]
    (cond 
      (= str_der (symbol "{"))
        (list (str str_izq " " str_der "\n" (agregar_identacion identacion)) (+ identacion 2))
      (= str_der (symbol "}"))
        (list (str str_izq "\n" str_der "\n" (quitar_identacion identacion)) (- identacion 2))
      :else 
        (list (str str_izq " " str_der) (second lista_izq))
    )
  )
)


(defn string_imprimir [lista] 
    (first (reduce formatear (map procesar_literal lista))) 
)


(defn listar [lista]
    (println (string_imprimir lista))
)

