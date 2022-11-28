(ns interprete-rust.funciones-implementar.dump)


(defn agregar-numero [nro_linea instruccion]
  (str nro_linea " " instruccion "\n")
)

(defn dump-str [vector_ri]
  (if (nil? vector_ri) 
    "0 nil \n" 
    (apply str (map-indexed agregar-numero vector_ri))
  )
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; DUMP: Recibe un vector con instrucciones de la RI y las imprime numeradas a partir de 0. Siempre devuelve nil.
; Por ejemplo:
; user=> (dump '[[POPREF 2] [PUSHFI 2] MUL [PUSHFI 1] ADD NEG])
; 0 [POPREF 2]
; 1 [PUSHFI 2]
; 2 MUL
; 3 [PUSHFI 1]
; 4 ADD
; 5 NEG
; nil
; user=> (dump '[HLT])
; 0 HLT
; nil
; user=> (dump nil)
; 0 nil
; nil
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn dump [vector_ri]
  (println (dump-str vector_ri))
)
