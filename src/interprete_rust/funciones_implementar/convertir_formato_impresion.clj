(ns interprete-rust.funciones-implementar.convertir-formato-impresion)

; (defn convertir-parametro [lista_convertir nro_parametro] 
;   (assoc lista_convertir 0 
;          (replace-first (nth lista_convertir 0) 
;           "{}" 
;           (obtener-identificador-clj (nth lista_convertir nro_parametro)))
; )

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; CONVERTIR-FORMATO-IMPRESION: Recibe una lista con los argumentos de print! de Rust y devuelve una lista con los
; argumentos equivalentes de printf de Clojure.
; Por ejemplo:
; user=> (convertir-formato-impresion '("Hola, mundo!"))
; ("Hola, mundo!")
; user=> (convertir-formato-impresion '("- My name is {}, James {}.\n- Hello, {}{}{}!" "Bond" "Bond" 0 0 7))
; ("- My name is %s, James %s.\n- Hello, %d%d%d!" "Bond" "Bond" 0 0 7)
; user=> (convertir-formato-impresion '("{} elevado a la {} es\t{}" 2.0 2 4.0))
; ("%.0f elevado a la %d es\t%.0f" 2.0 2 4.0)
; user=> (convertir-formato-impresion '("Las raices cuadradas de {} son +{:.8} y -{:.8}" 4.0 1.999999999985448 1.999999999985448))
; ("Las raices cuadradas de %.0f son +%.8f y -%.8f" 4.0 1.999999999985448 1.999999999985448)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn convertir-formato-impresion []

)