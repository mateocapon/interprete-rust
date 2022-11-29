(ns interprete-rust.funciones-implementar.pasar-a-float)

(defn string-a-float [elemento]
  (let [numero (read-string elemento)]
    (if (or (float? numero) (integer? numero)) (float numero) elemento)
  )  
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; PASAR-A-FLOAT: Recibe un elemento. Si puede devolverlo expresado como un numero de punto flotante, lo hace. Si no,
; lo devuelve intacto.
; Por ejemplo:
; user=> (pasar-a-float "10")
; 10.0
; user=> (pasar-a-float 10)
; 10.0
; user=> (pasar-a-float 10.0)
; 10.0
; user=> (pasar-a-float 'a)
; a
; user=> (pasar-a-float [10])
; [10]
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn pasar-a-float [elemento]
  (cond
    (integer? elemento) (float elemento)
    (string? elemento) (string-a-float elemento)
    :else elemento
  )
)
