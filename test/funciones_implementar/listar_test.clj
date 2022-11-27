(ns funciones-implementar.listar-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.listar :refer :all]))

(deftest listar-test
  (testing "LISTAR"
    (is (= 
          (string_imprimir (list 'fn 'main (symbol "(") (symbol ")")
                                 (symbol "{") 'println! (symbol "(") 
                                 "Hola, mundo!" (symbol ")") (symbol "}")))
          (str "fn main ( ) {\n"
               "  println! ( Hola, mundo! )\n"
               "}\n ")
))))  