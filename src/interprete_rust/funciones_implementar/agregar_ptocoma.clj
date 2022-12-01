(ns interprete-rust.funciones-implementar.agregar-ptocoma)



(defn procesar_literal [literal] 
    (list (list literal) 0)
)

(defn es-fin-funcion? [cantidad]
  (= 1 cantidad)
)

(defn no-hay-que-agregar-pto-coma? [izq der]
  (or (= (first (first der)) (symbol ";")) 
      (= (first (first der)) (symbol "}")) 
      (es-fin-funcion? (second izq))
      (= (first (first der)) 'else)
  )
)

(defn manejar-cerrar [izq der] 
  (if 
    (no-hay-que-agregar-pto-coma? izq der)
      (list (concat (first izq) (first der)) (dec (second izq)))
    (list (concat (first izq) (list (symbol ";")) (first der)) (dec (second izq)))
  )
)

(defn manejar-abrir [izq der] 
  (list (concat (first izq) (first der)) (inc (second izq)))
)


(defn reducir-agregando [izq der]
  (let [literal (last (first izq))] 

    (cond 
      (= literal (symbol "{")) (manejar-abrir izq der)
      (= literal (symbol "}")) (manejar-cerrar izq der)
      :else (list (concat (first izq) (first der)) (second izq))
    )
  )
)




;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; AGREGAR-PTOCOMA: Recibe una lista con los tokens de un programa en Rust y la devuelve con un token ; insertado a continuacion de ciertas } (llaves de cierre, pero no a continuacion de todas ellas).
; Esto se debe a que los programas correctos de Rust no separan con ; las expresiones presentes dentro de un bloque cuando estas terminan en }.
; Por ejemplo:
; user=> (agregar-ptocoma (list 'fn 'main (symbol "(") (symbol ")") (symbol "{") 'if 'x '< '0 (symbol "{") 'x '= '- 'x (symbol ";") (symbol "}") 'renglon '= 'x (symbol ";") 'if 'z '< '0 (symbol "{") 'z '= '- 'z (symbol ";") (symbol "}") (symbol "}") 'fn 'foo (symbol "(") (symbol ")") (symbol "{") 'if 'y '> '0 (symbol "{") 'y '= '- 'y (symbol ";") (symbol "}") 'else (symbol "{") 'x '= '- 'y (symbol ";") (symbol "}") (symbol "}")))
; (fn main ( ) { if x < 0 { x = - x ; } ; renglon = x ; if z < 0 { z = - z ; } } fn foo ( ) { if y > 0 { y = - y ; } else { x = - y ; } })
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn agregar-ptocoma [lista]
    (first (reduce reducir-agregando (map procesar_literal lista)))
)