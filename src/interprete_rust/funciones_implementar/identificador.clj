(ns interprete-rust.funciones-implementar.identificador)


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
		(contains? 
     #{'bool 'char 'str 'u8 'u16 'u32 'u64 'u128 'usize 'isize
       'i8 'i16 'i32 'i64 'i128 'struct 'enum}
     elemento)
)

