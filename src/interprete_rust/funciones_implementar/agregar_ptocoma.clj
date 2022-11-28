(ns interprete-rust.funciones-implementar.agregar-ptocoma)



(defn procesar_literal [literal] 
    ; Agrego un cero para indicar la identacion inicial 0.
    (list list(literal) 0)
)

; Lo que haria es mapear a una lista de un elemento y un cero y 
; despues voy reduciendo haciendo crecer la lista de la izquierda
; e incrementando el contador cuando estoy en un bloque que necesite
; ptocoma.


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; AGREGAR-PTOCOMA: Recibe una lista con los tokens de un programa en Rust y la devuelve con un token ; insertado a continuacion de ciertas } (llaves de cierre, pero no a continuacion de todas ellas).
; Esto se debe a que los programas correctos de Rust no separan con ; las expresiones presentes dentro de un bloque cuando estas terminan en }.
; Por ejemplo:
; user=> (agregar-ptocoma (list 'fn 'main (symbol "(") (symbol ")") (symbol "{") 'if 'x '< '0 (symbol "{") 'x '= '- 'x (symbol ";") (symbol "}") 'renglon '= 'x (symbol ";") 'if 'z '< '0 (symbol "{") 'z '= '- 'z (symbol ";") (symbol "}") (symbol "}") 'fn 'foo (symbol "(") (symbol ")") (symbol "{") 'if 'y '> '0 (symbol "{") 'y '= '- 'y (symbol ";") (symbol "}") 'else (symbol "{") 'x '= '- 'y (symbol ";") (symbol "}") (symbol "}")))
; (fn main ( ) { if x < 0 { x = - x ; } ; renglon = x ; if z < 0 { z = - z ; } } fn foo ( ) { if y > 0 { y = - y ; } else { x = - y ; } })
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn agregar-ptocoma [lista]
		nil

)