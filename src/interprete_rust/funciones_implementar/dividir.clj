(ns interprete-rust.funciones-implementar.dividir)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; DIVIDIR: Recibe dos numeros y devuelve su cociente, manteniendo su tipo.
; Por ejemplo:
; user=> (dividir 12 3)
; 4
; user=> (dividir 12.0 3)
; 4.0
; user=> (dividir 12 3.0)
; 4.0
; user=> (dividir 12.0 3.0)
; 4.0
; user=> (dividir 1 2)
; 0
; user=> (dividir 1 2.0)
; 0.5
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn dividir [dividendo divisor]
  (if (or (float? dividendo) (float? divisor))
    (double (/ dividendo divisor))
    (int (/ dividendo divisor))
   )
)
