(ns interprete-rust.funciones-implementar.generar-ref
  (:require [interprete-rust.funciones-implementar.identificador :refer [identificador?]])
)


; Estas tres funciones estan copiadas del interprete.
(defn bytecode [amb]
  (amb 6)
)

(defn estado [amb]
  (amb 3)
)

(defn generar 
  ([amb instr]
    (if (= (estado amb) :sin-errores)
        (assoc amb 6 (conj (bytecode amb) instr))
        amb))
  ([amb instr val]
    (if (= (estado amb) :sin-errores)
        (assoc amb 6 (conj (bytecode amb) [instr val]))
        amb))
)


(defn obtener-ult-identificador [simb-ya-parseados]
  (last (filter identificador? simb-ya-parseados))
)


(defn es-igual-simbolo [simbolo simbolo-contexto]
  (= simbolo (first simbolo-contexto))
)

(defn obtener-direccion [simbolo contexto]
  (last (last (filter (partial es-igual-simbolo simbolo)(second contexto))))
)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; GENERAR-REF: Recibe un ambiente y, si su estado no es :sin-errores, lo devuelve intacto.
; De lo contrario, lo devuelve modificado, generando (llamando a generar) una instruccion PUSHADDR con la direccion
; de la ultima variable proveniente de simb-ya-parseados. Esta direccion sera la de la ultima coincidencia de la
; variable anterior en el segundo subvector del vector contexto.
; Por ejemplo:
; user=> (generar-ref [(symbol ")") (list (symbol ";") 'println! (symbol "(") "{}" (symbol ",") 'v (symbol ")") (symbol ";") (symbol "}")) ['fn 'inc (symbol "(") 'v (symbol ":") (symbol "&") 'mut 'i64 (symbol ")") (symbol "{") '* 'v (symbol "+=") 1 (symbol ";") (symbol "}") 'fn 'main (symbol "(") (symbol ")") (symbol "{") 'let 'mut 'v (symbol ":") 'i64 (symbol "=") 5 (symbol ";") 'inc (symbol "(") (symbol "&") 'mut 'v] 8 [[0 2] [['inc ['fn [(list ['v (symbol ":") (symbol "&") 'mut 'i64]) ()]] 2] ['main ['fn [() ()]] 6] ['v ['var-mut 'i64] 0]]] 1 [['CAL 6] 'HLT ['POPARG 0] ['PUSHFI 1] ['POPADDREF 0] 'RETN ['PUSHFI 5] ['POP 0]] [[2 ['i64 nil]] [6 ['i64 nil]]]])
; [) (; println! ( "{}" , v ) ; }) [fn inc ( v : & mut i64 ) { * v += 1 ; } fn main ( ) { let mut v : i64 = 5 ; inc ( & mut v] 8 [[0 2] [[inc [fn [([v : & mut i64]) ()]] 2] [main [fn [() ()]] 6] [v [var-mut i64] 0]]] 1 [[CAL 6] HLT [POPARG 0] [PUSHFI 1] [POPADDREF 0] RETN [PUSHFI 5] [POP 0]] [[2 [i64 nil]] [6 [i64 nil]]]]
;                                                                                                                              ^
; user=> (generar-ref [(symbol ")") (list (symbol ";") 'println! (symbol "(") "{}" (symbol ",") 'v (symbol ")") (symbol ";") (symbol "}")) ['fn 'inc (symbol "(") 'v (symbol ":") (symbol "&") 'mut 'i64 (symbol ")") (symbol "{") '* 'v (symbol "+=") 1 (symbol ";") (symbol "}") 'fn 'main (symbol "(") (symbol ")") (symbol "{") 'let 'mut 'v (symbol ":") 'i64 (symbol "=") 5 (symbol ";") 'inc (symbol "(") (symbol "&") 'mut 'v] :sin-errores [[0 2] [['inc ['fn [(list ['v (symbol ":") (symbol "&") 'mut 'i64]) ()]] 2] ['main ['fn [() ()]] 6] ['v ['var-mut 'i64] 0]]] 1 [['CAL 6] 'HLT ['POPARG 0] ['PUSHFI 1] ['POPADDREF 0] 'RETN ['PUSHFI 5] ['POP 0]] [[2 ['i64 nil]] [6 ['i64 nil]]]])
; [) (; println! ( "{}" , v ) ; }) [fn inc ( v : & mut i64 ) { * v += 1 ; } fn main ( ) { let mut v : i64 = 5 ; inc ( & mut v] :sin-errores [[0 2] [[inc [fn [([v : & mut i64]) ()]] 2] [main [fn [() ()]] 6] [v [var-mut i64] 0]]] 1 [[CAL 6] HLT [POPARG 0] [PUSHFI 1] [POPADDREF 0] RETN [PUSHFI 5] [POP 0] [PUSHADDR 0]] [[2 [i64 nil]] [6 [i64 nil]]]]
;                                                                                                                           ^  ^^^^^^^^^^^^                                                                    ^^^^^^^^^^^^^^^^^                                                                               ^^^^^^^^^^^^
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn generar-ref [ambiente]
  (let [contexto (nth ambiente 4),
        estado (nth ambiente 3),
        simb-ya-parseados (nth ambiente 2)]

    (if (= estado ':sin-errores)
     (generar ambiente 'PUSHADDR (obtener-direccion (obtener-ult-identificador simb-ya-parseados) contexto))
     ambiente
    )
  )
)