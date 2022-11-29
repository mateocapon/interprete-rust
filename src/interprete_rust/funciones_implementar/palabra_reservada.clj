(ns interprete-rust.funciones-implementar.palabra-reservada)

; Las palabras reservadas se obtienen de https://doc.rust-lang.org/reference/keywords.html

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; PALABRA-RESERVADA?: Recibe un elemento y devuelve true si es una palabra reservada de Rust; si no, false.
; Por ejemplo:
; user=> (palabra-reservada? 'while)
; true
; user=> (palabra-reservada? 'until)
; false
; user=> (palabra-reservada? 13)
; false
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn palabra-reservada? [elemento]
  (contains? 
     #{'break 'as 'const 'continue 'crate 'else 'enum 'extern 
     'false 'fn 'for 'if 'impl 'in 'let 'loop 'match 'mod 'move 
     'mut 'pub 'ref 'return 'self 'Self 'static 'struct 'super 
     'trait 'true 'type 'unsafe 'use 'where 'while 'async 'await 
     'dyn 'abstract 'become 'box 'do 'final 'macro 'override 'priv 
     'typeof 'unsized 'virtual 'yield 'try 'union } 
    elemento
  )
)
 

