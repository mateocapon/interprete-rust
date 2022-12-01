(ns interprete-rust.funciones-implementar.identificador
  (:require [interprete-rust.funciones-implementar.palabra-reservada :refer :all])
)

(defn tipo-dato? [elemento]
  (contains? 
     #{'String 'str 'char 'usize 'u8 'u16
       'u32 'u64 'u128 'bool 'isize 'i8 
       'i16 'i32 'i64 'i128 'f32 'f64 }  
    elemento
  )
)



(defn alfa-numerico? [elemento]
  (= (str elemento) (re-matches #"^[a-zA-Z0-9\_]+$" (str elemento)))
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; IDENTIFICADOR?: Recibe un elemento y devuelve true si es un identificador valido en Rust; si no, false.
; Por ejemplo:
; user=> (identificador? 'boolean)
; true
; user=> (identificador? 'bool)
; false
; user=> (identificador? 'e120)
; true
; user=> (identificador? '12e0)
; false
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn identificador? [elemento]
    (and (not (palabra-reservada? elemento))
         (not (tipo-dato? elemento)) 
         (not= elemento '_) 
         (alfa-numerico? elemento))
)
