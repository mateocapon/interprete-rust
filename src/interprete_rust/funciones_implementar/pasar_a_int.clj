(ns interprete-rust.funciones-implementar.pasar-a-int)

(defn string-a-int [elemento]
  (let [entero (read-string elemento)]
    (if (or (float? entero) (integer? entero)) (int entero) elemento)
  )  
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; PASAR-A-INT: Recibe un elemento. Si puede devolverlo expresado como un entero, lo hace. Si no, lo devuelve intacto.
; Por ejemplo:
; user=> (pasar-a-int "10")
; 10
; user=> (pasar-a-int 10.0)
; 10
; user=> (pasar-a-int 10)
; 10
; user=> (pasar-a-int 'a)
; a
; user=> (pasar-a-int [10.0])
; [10.0]
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn pasar-a-int [elemento]
  (cond
    (float? elemento) (int elemento)
    (string? elemento) (string-a-int elemento)
    :else elemento
  )
)
