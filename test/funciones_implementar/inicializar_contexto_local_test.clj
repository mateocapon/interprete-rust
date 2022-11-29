(ns funciones-implementar.inicializar-contexto-local-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.inicializar-contexto-local :refer :all]))

(deftest inicializar-contexto-local-test-1
  (testing "INICIALIZAR CONTEXTO LOCAL 1"
    (is (= 
      (inicializar-contexto-local [
        (symbol "{") 
        (list 'let 'x (symbol ":") 'i64 (symbol "=") 10 (symbol ";") 'println! (symbol "(") "{}" (symbol ",") 'x (symbol ")") (symbol "}")) 
        ['fn 'main (symbol "(") (symbol ")")] 
        8 
        [[0] [['main ['fn [() ()]] 2]]] 
        0 
        [['CAL 2] 'HLT] 
        []
      ])
      [
        (symbol "{") 
        (list 'let 'x (symbol ":") 'i64 (symbol "=") 10 (symbol ";") 'println! (symbol "(") "{}" (symbol ",") 'x (symbol ")") (symbol "}")) 
        ['fn 'main (symbol "(") (symbol ")")] 
        8 
        [[0] [['main ['fn [() ()]] 2]]] 
        0 
        [['CAL 2] 'HLT] 
        []
      ]
    ))
))


(deftest inicializar-contexto-local-test-2
  (testing "INICIALIZAR CONTEXTO LOCAL 2"
    (is (= 
      (inicializar-contexto-local [
        (symbol "{") 
        (list 'let 'x (symbol ":") 'i64 (symbol "=") 10 (symbol ";") 'println! (symbol "(") "{}" (symbol ",") 'x (symbol ")") (symbol "}")) 
        ['fn 'main (symbol "(") (symbol ")")] 
        :sin-errores 
        [[0] [['main ['fn [() ()]] 2]]] 
        0 
        [['CAL 2] 'HLT] 
        []
      ])
      [
        (symbol "{") 
        (list 'let 'x (symbol ":") 'i64 (symbol "=") 10 (symbol ";") 'println! (symbol "(") "{}" (symbol ",") 'x (symbol ")") (symbol "}")) 
        ['fn 'main (symbol "(") (symbol ")")] 
        :sin-errores
        [[0 1] [['main ['fn [() ()]] 2]]] 
        0 
        [['CAL 2] 'HLT] 
        []
      ]
    ))
))

