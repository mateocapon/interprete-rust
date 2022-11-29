(ns interprete-rust.funciones-implementar.inicializar-contexto-local)


(defn actualizar-contexto [contexto]
  (assoc contexto 0 (conj (contexto 0) (count (contexto 1))))
)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; INICIALIZAR-CONTEXTO-LOCAL: Recibe un ambiente y, si su estado no es :sin-errores, lo devuelve intacto.
; De lo contrario, lo devuelve modificado con el tamano del segundo subvector del vector contexto agregado al final
; del primer subvector del vector contexto.
; Por ejemplo:
; user=> (inicializar-contexto-local [(symbol "{") (list 'let 'x (symbol ":") 'i64 (symbol "=") 10 (symbol ";") 'println! (symbol "(") "{}" (symbol ",") 'x (symbol ")") (symbol "}")) ['fn 'main (symbol "(") (symbol ")")] 8 [[0] [['main ['fn [() ()]] 2]]] 0 [['CAL 2] 'HLT] []])
; [{ (let x : i64 = 10 ; println! ( "{}" , x ) }) [fn main ( )] 8 [[0] [[main [fn [() ()]] 2]]] 0 [[CAL 2] HLT] []]
;                                                               ^ 
; user=> (inicializar-contexto-local [(symbol "{") (list 'let 'x (symbol ":") 'i64 (symbol "=") 10 (symbol ";") 'println! (symbol "(") "{}" (symbol ",") 'x (symbol ")") (symbol "}")) ['fn 'main (symbol "(") (symbol ")")] :sin-errores [[0] [['main ['fn [() ()]] 2]]] 0 [['CAL 2] 'HLT] []])
; [{ (let x : i64 = 10 ; println! ( "{}" , x ) }) [fn main ( )] :sin-errores [[0 1] [[main [fn [() ()]] 2]]] 0 [[CAL 2] HLT] []]
;                                                               ^^^^^^^^^^^^     ^  ^^^^^^^^^^^^^^^^^^^^^^^
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn inicializar-contexto-local [ambiente]
  (let [contexto (nth ambiente 4),
        estado (nth ambiente 3) ]

    (if (= estado ':sin-errores)
     (assoc ambiente 4 (actualizar-contexto contexto))
     ambiente
    )
  )
)