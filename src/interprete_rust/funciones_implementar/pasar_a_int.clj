(ns interprete-rust.funciones-implementar.pasar-a-int)


(defn vec-pasar-a-int [elemento]
  (if )
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
    (float? elemento) (float elemento)
    (and (sequential? elemento) (= (count elemento) 1) (vec-pasar-a-int elemento)
    (float? elemento) (float elemento)
    (float? elemento) (float elemento)
    :else elemento
  )
)
