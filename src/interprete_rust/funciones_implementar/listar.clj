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
		(literal)
)


(defn string_imprimir [lista] 
		(apply str (map procesar_literal lista)) 
)

(defn listar [lista]
		(println string_imprimir lista)
)

