(ns interprete-rust.funciones-implementar.restaurar-contexto-anterior)

; El primer subvector es el mismo sin el ultimo elemento.
; Al segundo subvector se le filtran los primeros elementos.
(defn actualizar-contexto [contexto]
  [(pop (contexto 0)) (subvec (contexto 1) 0 (last (contexto 0)))]
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; RESTAURAR-CONTEXTO-ANTERIOR: Recibe un ambiente y, si su estado no es :sin-errores, lo devuelve intacto.
; De lo contrario, lo devuelve modificado, quitando la ultima frontera en el primer subvector del vector contexto,
; y sacando del final del segundo subvector del vector contexto los elementos ubicados a partir de la frontera quitada.
; Por ejemplo:
; user=> (restaurar-contexto-anterior ['EOF () ['fn 'main (symbol "(") (symbol ")") (symbol "{") 'let 'x (symbol ":") 'i64 (symbol "=") 10 (symbol ";") 'let 'y (symbol ":") 'i64 (symbol "=") 20 (symbol ";") 'println! (symbol "(") "{}" (symbol ",") 'x '+ 'y (symbol ")") (symbol "}")] 8 [[0 1] [['main ['fn [() ()]] 2] ['x ['var-inmut 'i64] 0] ['y ['var-inmut 'i64] 1]]] 2 [['CAL 2] 'HLT ['PUSHFI 10] ['POP 0] ['PUSHFI 20] ['POP 1] ['PUSHFI "{}"] ['PUSHFM 0] ['PUSHFM 1] 'ADD ['PUSHFI 2] 'OUT 'NL] [[2 ['i64 nil] ['i64 nil]]]])
; [EOF () [fn main ( ) { let x : i64 = 10 ; let y : i64 = 20 ; println! ( "{}" , x + y ) }] 8 [[0 1] [[main [fn [() ()]] 2] [x [var-inmut i64] 0] [y [var-inmut i64] 1]]] 2 [[CAL 2] HLT [PUSHFI 10] [POP 0] [PUSHFI 20] [POP 1] [PUSHFI "{}"] [PUSHFM 0] [PUSHFM 1] ADD [PUSHFI 2] OUT NL] [[2 [i64 nil] [i64 nil]]]]
;                                                                                           ^ 
; user=> (restaurar-contexto-anterior ['EOF () ['fn 'main (symbol "(") (symbol ")") (symbol "{") 'let 'x (symbol ":") 'i64 (symbol "=") 10 (symbol ";") 'let 'y (symbol ":") 'i64 (symbol "=") 20 (symbol ";") 'println! (symbol "(") "{}" (symbol ",") 'x '+ 'y (symbol ")") (symbol "}")] :sin-errores [[0 1] [['main ['fn [() ()]] 2] ['x ['var-inmut 'i64] 0] ['y ['var-inmut 'i64] 1]]] 2 [['CAL 2] 'HLT ['PUSHFI 10] ['POP 0] ['PUSHFI 20] ['POP 1] ['PUSHFI "{}"] ['PUSHFM 0] ['PUSHFM 1] 'ADD ['PUSHFI 2] 'OUT 'NL] [[2 ['i64 nil] ['i64 nil]]]])
; [EOF () [fn main ( ) { let x : i64 = 10 ; let y : i64 = 20 ; println! ( "{}" , x + y ) }] :sin-errores [[0] [[main [fn [() ()]] 2]]] 2 [[CAL 2] HLT [PUSHFI 10] [POP 0] [PUSHFI 20] [POP 1] [PUSHFI "{}"] [PUSHFM 0] [PUSHFM 1] ADD [PUSHFI 2] OUT NL] [[2 [i64 nil] [i64 nil]]]]
;                                                                                           ^^^^^^^^^^^^  ^^^ ^^^^^^^^^^^^^^^^^^^^^^^
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn restaurar-contexto-anterior [ambiente]
  (let [contexto (nth ambiente 4),
        estado (nth ambiente 3) ]

    (if (= estado ':sin-errores)
      (assoc ambiente 4 (actualizar-contexto contexto))
     ambiente
    )
  )
)