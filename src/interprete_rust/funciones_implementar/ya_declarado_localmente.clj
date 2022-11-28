(ns interprete-rust.funciones-implementar.ya-declarado-localmente)

; Devuelve el subvector filtrado por el numero del contexto actual
; y dejando solamente los identificadores
(defn subvector [contexto]
  (into #{} (map first (subvec (second contexto) (last (first contexto)))))
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; YA-DECLARADO-LOCALMENTE?: Recibe un identificador y un contexto (un vector formado por dos subvectores: el primero
; con las sucesivas posiciones de inicio de los distintos ambitos/scopes y el segundo con ternas
; [identificador, tipo, valor] resultantes de las declaraciones efectuadas, y devuelve true si el identificador esta
; declarado en el segundo subvector a partir de la ultima posicion guardada en el primer subvector (o sea, en el
; ambito/scope local); si no, devuelve false.
; Por ejemplo:
; user=> (ya-declarado-localmente? 'Write [[0] [['io ['lib '()] 0] ['Write ['lib '()] 0] ['entero_a_hexa ['fn [(list ['n (symbol ":") 'i64]) 'String]] 2]]])
; true
; user=> (ya-declarado-localmente? 'Read [[0] [['io ['lib '()] 0] ['Write ['lib '()] 0] ['entero_a_hexa ['fn [(list ['n (symbol ":") 'i64]) 'String]] 2]]])
; false
; user=> (ya-declarado-localmente? 'Write [[0 1] [['io ['lib '()] 0] ['Write ['lib '()] 0] ['entero_a_hexa ['fn [(list ['n (symbol ":") 'i64]) 'String]] 2]]])
; true
; user=> (ya-declarado-localmente? 'Write [[0 2] [['io ['lib '()] 0] ['Write ['lib '()] 0] ['entero_a_hexa ['fn [(list ['n (symbol ":") 'i64]) 'String]] 2]]])
; false
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn ya-declarado-localmente? [identificador contexto] 
  (contains? (subvector contexto) identificador)
)