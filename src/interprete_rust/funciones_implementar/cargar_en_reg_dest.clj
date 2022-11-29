(ns interprete-rust.funciones-implementar.cargar-en-reg-dest)


(defn actualizar-registro [registro coordenada tipo valor]
  (assoc registro coordenada [tipo valor])
)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; CARGAR-EN-REG-DEST: Recibe un vector de registros de activacion, coordenadas, un tipo y un valor. Devuelve el
; vector de registros de activacion con el registro indicado por las coordenadas actualizado, con el nuevo tipo
; y el nuevo valor.
; 
; Por ejemplo:
; user=> (cargar-en-reg-dest [[['String "2"] ['i64 6] ['i64 2] ['i64 2] ['i64 2]] [['i64 6] ['i64 2] ['i64 [0 3]] ['i64 [0 4]] ['i64 2] ['i64 2]]] [0 4] 'i64 0)
; [[[String "2"] [i64 6] [i64 2] [i64 2] [i64 0]] [[i64 6] [i64 2] [i64 [0 3]] [i64 [0 4]] [i64 2] [i64 2]]]
;                                         ^^^ ^
; user=> (cargar-en-reg-dest [[['String "2"] ['i64 6] ['i64 2] ['i64 2] ['i64 0]] [['i64 6] ['i64 2] ['i64 [0 3]] ['i64 [0 4]] ['i64 2] ['i64 2]]] [0 3] 'f64 3)
; [[[String "2"] [i64 6] [i64 2] [f64 3] [i64 0]] [[i64 6] [i64 2] [i64 [0 3]] [i64 [0 4]] [i64 2] [i64 2]]]
;                                 ^^^ ^
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn cargar-en-reg-dest [registros_activacion coordenadas tipo valor]
  (let [coord_x (first coordenadas),
        coord_y (second coordenadas)]
    (assoc registros_activacion 
           coord_x
           (actualizar-registro (registros_activacion coord_x) coord_y tipo valor)
    )
  )
)