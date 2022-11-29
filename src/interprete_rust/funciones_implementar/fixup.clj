(ns interprete-rust.funciones-implementar.fixup)


(defn actualizar-bytecode [bytecode ubicacion_jmp]
  (assoc bytecode ubicacion_jmp ['JMP (count bytecode)])
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; FIXUP: Recibe un ambiente y la ubicacion de un JMP ? a corregir en el vector de bytecode. Si el estado no es
; :sin-errores, devuelve el ambiente intacto. De lo contrario, lo devuelve con el JMP corregido con el tamano del
; vector de bytecode.
; Por ejemplo:
; user=> (fixup [(symbol "{") (list 'x '= 20 (symbol ";") (symbol "}") (symbol ";") 'println! (symbol "(") "{}" (symbol ",") 'x (symbol ")") (symbol "}")) ['fn 'main (symbol "(") (symbol ")") (symbol "{") 'let 'x (symbol ":") 'i64 (symbol ";") 'if false (symbol "{") 'x '= 10 (symbol ";") (symbol "}") 'else] 8 [[0 1 2] [['main ['fn [() ()]] 2] ['x ['var-inmut 'i64] 0]]] 1 [['CAL 2] 'HLT ['PUSHFI false] ['JC 5] ['JMP '?] ['PUSHFI 10] ['POP 0] ['JMP '?]] [[2 ['i64 nil]]]] 4)
; [{ (x = 20 ; } ; println! ( "{}" , x ) }) [fn main ( ) { let x : i64 ; if false { x = 10 ; } else] 8 [[0 1 2] [[main [fn [() ()]] 2] [x [var-inmut i64] 0]]] 1 [[CAL 2] HLT [PUSHFI false] [JC 5] [JMP ?] [PUSHFI 10] [POP 0] [JMP ?]] [[2 [i64 nil]]]]
;                                                                                                    ^ 
; user=> (fixup [(symbol "{") (list 'x '= 20 (symbol ";") (symbol "}") (symbol ";") 'println! (symbol "(") "{}" (symbol ",") 'x (symbol ")") (symbol "}")) ['fn 'main (symbol "(") (symbol ")") (symbol "{") 'let 'x (symbol ":") 'i64 (symbol ";") 'if false (symbol "{") 'x '= 10 (symbol ";") (symbol "}") 'else] :sin-errores [[0 1 2] [['main ['fn [() ()]] 2] ['x ['var-inmut 'i64] 0]]] 1 [['CAL 2] 'HLT ['PUSHFI false] ['JC 5] ['JMP '?] ['PUSHFI 10] ['POP 0] ['JMP '?]] [[2 ['i64 nil]]]] 4)
; [{ (x = 20 ; } ; println! ( "{}" , x ) }) [fn main ( ) { let x : i64 ; if false { x = 10 ; } else] :sin-errores [[0 1 2] [[main [fn [() ()]] 2] [x [var-inmut i64] 0]]] 1 [[CAL 2] HLT [PUSHFI false] [JC 5] [JMP 8] [PUSHFI 10] [POP 0] [JMP ?]] [[2 [i64 nil]]]]
;                                                                                                    ^^^^^^^^^^^^                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^: tamano 8                                                                                                                                                                                                                                        ^ ubicacion de JMP ? en contexto
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn fixup [ambiente ubicacion_jmp]
  (let [bytecode (nth ambiente 6),
        estado (nth ambiente 3)]

    (if (= estado ':sin-errores)
     (assoc ambiente 6 (actualizar-bytecode bytecode ubicacion_jmp))
     ambiente
    )
  )
)