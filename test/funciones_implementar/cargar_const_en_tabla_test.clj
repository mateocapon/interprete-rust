(ns funciones-implementar.cargar-const-en-tabla-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.cargar-const-en-tabla :refer :all]))

(deftest cargar-const-en-tabla-test-1
  (testing "CONST-EN-TABLA 1"
    (is (= 
          (cargar-const-en-tabla [
            (symbol ";")
            (list 'fn 'main (symbol "(") (symbol ")") (symbol "{") 'println! (symbol "(") "{}" (symbol ",") 'TRES (symbol ")") (symbol "}")) 
            ['use 'std (symbol "::") 'io (symbol ";") 'const 'TRES (symbol ":") 'i64 (symbol "=") 3] 
            8 
            [[0] [['io ['lib '()] 0]]]
            0 
            [['CAL 0] 'HLT] 
            []
          ])
          [
            (symbol ";")
            (list 'fn 'main (symbol "(") (symbol ")") (symbol "{") 'println! (symbol "(") "{}" (symbol ",") 'TRES (symbol ")") (symbol "}")) 
            ['use 'std (symbol "::") 'io (symbol ";") 'const 'TRES (symbol ":") 'i64 (symbol "=") 3] 
            8 
            [[0] [['io ['lib '()] 0]]]
            0 
            [['CAL 0] 'HLT] 
            []
          ]
))))


(deftest cargar-const-en-tabla-test-1
  (testing "CONST-EN-TABLA 2"
    (is (= 
          (cargar-const-en-tabla [
            (symbol ";") 
            (list 'fn 'main (symbol "(") (symbol ")") (symbol "{") 'println! (symbol "(") "{}" (symbol ",") 'TRES (symbol ")") (symbol "}")) 
            ['use 'std (symbol "::") 'io (symbol ";") 'const 'TRES (symbol ":") 'i64 (symbol "=") 3] 
            :sin-errores 
            [[0] [['io ['lib '()] 0]]] 
            0 
            [['CAL 0] 'HLT] 
            []
          ])
          [
            (symbol ";")
            (list 'fn 'main (symbol "(") (symbol ")") (symbol "{") 'println! (symbol "(") "{}" (symbol ",") 'TRES (symbol ")") (symbol "}")) 
            ['use 'std (symbol "::") 'io (symbol ";") 'const 'TRES (symbol ":") 'i64 (symbol "=") 3] 
            :sin-errores
            [[0] [['io ['lib '()] 0] ['TRES ['const 'i64] 3]]]
            0
            [['CAL 0] 'HLT] 
            []
          ]
          
))))
