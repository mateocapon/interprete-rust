(ns interprete-rust.funciones-implementar.compatibles)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; COMPATIBLES?: Recibe dos elementos. Si el primero es un tipo de dato de Rust y el segundo es un valor de Clojure
; de un tipo de dato compatible con el mismo o un vector, devuelve true. Si no, false.
; Por ejemplo:
; user=> (compatibles? 'i64 5)
; true
; user=> (compatibles? 'i64 5.0)
; false
; user=> (compatibles? 'i64 [5.0])
; true
; user=> (compatibles? 'f64 5.0)
; true
; user=> (compatibles? 'String "Hola")
; true
; user=> (compatibles? 'bool true)
; true
; user=> (compatibles? 'bool 1)
; false
; user=> (compatibles? 'usize 1)
; true
; user=> (compatibles? 'char \a)
; true
; user=> (compatibles? 'char 'a)
; false
; user=> (compatibles? 'char ['a])
; true
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn compatibles? [t_dato valor]
  (cond
    (contains? #{'String 'str} t_dato) 
      (or (string? valor) (vector? valor))
    (contains? #{'char} t_dato) 
      (or (char? valor) (vector? valor))
    (contains? #{'usize 'u8 'u16 'u32 'u64 'u128} t_dato) 
      (or (and (integer? valor) (pos? valor)) (vector? valor))
    (contains? #{'bool} t_dato)
      (or (boolean? valor) (vector? valor))
    (contains? #{'isize 'i8 'i16 'i32 'i64 'i128} t_dato)
      (or (integer? valor) (vector? valor))
    (contains? #{'f32 'f64} t_dato)
      (or (float? valor) (vector? valor))
    :else false
  )
)