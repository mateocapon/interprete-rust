(ns interprete-rust.funciones-implementar.convertir-formato-impresion)
(use '[clojure.string :only (replace-first)])

(defn obtener-formato-clj [elemento]
  (cond
    (string? elemento) "%s"
    (integer? elemento) "%d"
    (float? elemento) "%.0f"
    :else ""
  )

)

(defn reemplazar-uno [lista_convertir nro_parametro]
  (cons 
    (replace-first (first lista_convertir) "{}" 
      (obtener-formato-clj (nth lista_convertir nro_parametro)))
    (rest lista_convertir))
)


(defn convertir-parametro [lista_convertir nro_parametro] 
  (if (= nro_parametro (count lista_convertir))
      lista_convertir
      (recur (reemplazar-uno lista_convertir nro_parametro ) (inc nro_parametro))
  )
)

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
(defn convertir-formato-impresion [lista_argumentos]
  (convertir-parametro lista_argumentos 1)
)
