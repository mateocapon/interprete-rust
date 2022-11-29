(ns interprete-rust.funciones-implementar.cargar-en-ult-reg)



(defn ultimo-actualizado [ultimo-registro direccion tipo valor] 
  (assoc ultimo-registro direccion [tipo valor])
)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; CARGAR-EN-ULT-REG: Recibe un vector de registros de activacion, una direccion, un tipo y un valor. Devuelve el
; vector de registros de activacion con el ultimo registro actualizado, en la direccion indicada, con el nuevo tipo
; y el nuevo valor.
; Por ejemplo:
; user=> (cargar-en-ult-reg [[['String "2"] ['i64 6] ['i64 2] ['i64 3] ['i64 0]] [['i64 nil] ['i64 nil]]] 1 'i64 0)
; [[[String "2"] [i64 6] [i64 2] [i64 3] [i64 0]] [[i64 nil] [i64 0]]]
;                                                             ^^^ ^
; user=> (cargar-en-ult-reg [[['String "2"] ['i64 6] ['i64 2] ['i64 3] ['i64 0]] [['i64 nil] ['i64 0]]] 0 'f64 3)
; [[[String "2"] [i64 6] [i64 2] [i64 3] [i64 0]] [[f64 3] [i64 0]]]
;                                                   ^^^ ^
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn cargar-en-ult-reg [registros_activacion direccion tipo valor]
  (assoc registros_activacion 
         (dec (count registros_activacion)) 
         (ultimo-actualizado (last registros_activacion) direccion tipo valor)
  )
)
