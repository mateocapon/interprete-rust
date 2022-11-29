(ns interprete-rust.funciones-implementar.cargar-const-en-tabla)


(defn filtrar_const [indice palabra]
  (if (= palabra 'const)
    indice
    -1
  )
)

(defn obtener-pos-const [simb-ya-parseados]
  (first (filter pos? (map-indexed filtrar_const simb-ya-parseados)))
)

(defn obtener-identificador [simb-ya-parseados pos_const]
  (simb-ya-parseados (+ pos_const 1))
)

(defn obtener-tipo [simb-ya-parseados pos_const]
  ['const (simb-ya-parseados (+ pos_const 3))]
)

(defn obtener-valor [simb-ya-parseados pos_const]
  (simb-ya-parseados (+ pos_const 5))
)

(defn obtener-constante-nueva [simb-ya-parseados]
  (let [pos_const (obtener-pos-const simb-ya-parseados)]
    [(obtener-identificador simb-ya-parseados pos_const) 
     (obtener-tipo simb-ya-parseados pos_const) 
     (obtener-valor simb-ya-parseados pos_const)
    ]
  )
)

(defn actualizar-contexto [contexto simb-ya-parseados]
  (assoc contexto 1 (conj (contexto 1) (obtener-constante-nueva simb-ya-parseados)))
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; CARGAR-CONST-EN-TABLA: Recibe un ambiente 
; [simb-actual  simb-no-parseados-aun  simb-ya-parseados  estado  contexto  prox-var  bytecode mapa-regs-de-act]
; Si su estado no es :sin-errores, lo devuelve intacto. De lo contrario, lo devuelve modificado con la constante
; declarada como terna [identificador, tipo, valor] en el segundo subvector del vector contexto.
; Por ejemplo:
; user=> (cargar-const-en-tabla [(symbol ";") (list 'fn 'main (symbol "(") (symbol ")") (symbol "{") 'println! (symbol "(") "{}" (symbol ",") 'TRES (symbol ")") (symbol "}")) ['use 'std (symbol "::") 'io (symbol ";") 'const 'TRES (symbol ":") 'i64 (symbol "=") 3] 8 [[0] [['io ['lib '()] 0]]] 0 [['CAL 0] 'HLT] []])
; [; (fn main ( ) { println! ( "{}" , TRES ) }) [use std :: io ; const TRES : i64 = 3] 8 [[0] [[io [lib ()] 0]]] 0 [[CAL 0] HLT] []]
;                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ ^ ^^^^^^^^^^^^^^^^^^^^^^^ 
; user=> (cargar-const-en-tabla [(symbol ";") (list 'fn 'main (symbol "(") (symbol ")") (symbol "{") 'println! (symbol "(") "{}" (symbol ",") 'TRES (symbol ")") (symbol "}")) ['use 'std (symbol "::") 'io (symbol ";") 'const 'TRES (symbol ":") 'i64 (symbol "=") 3] :sin-errores [[0] [['io ['lib '()] 0]]] 0 [['CAL 0] 'HLT] []])
; [; (fn main ( ) { println! ( "{}" , TRES ) }) [use std :: io ; const TRES : i64 = 3] :sin-errores [[0] [[io [lib ()] 0] [TRES [const i64] 3]]] 0 [[CAL 0] HLT] []]
;                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ ^^^^^^^^^^^^ ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn cargar-const-en-tabla [ambiente]
  (let [contexto (nth ambiente 4),
        estado (nth ambiente 3),
        simb-ya-parseados (nth ambiente 2)]

    (if (= estado ':sin-errores)
     (assoc ambiente 4 (actualizar-contexto contexto simb-ya-parseados))
     ambiente
    )
  )
)