(ns funciones-implementar.listar-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.listar :refer :all]))

(deftest listar-test-2
  (testing "LISTAR-1"
    (is (= 
          (string_imprimir (list 'fn 'main (symbol "(") (symbol ")")
                                 (symbol "{") 'println! (symbol "(") 
                                 "Hola, mundo!" (symbol ")") (symbol "}")))
          (str "fn main ( ) {\n"
               "  println! ( Hola, mundo! )\n"
               "}\n")
))))  

(deftest listar-test-1
  (testing "LISTAR-2"
    (is (= 
          (string_imprimir (list 'fn 'main (symbol "(") (symbol ")") 
                                 (symbol "{") 'if 'x '< '0 (symbol "{") 
                                 'x '= '- 'x (symbol ";") (symbol "}") 
                                 'renglon '= 'x (symbol ";") 'if 'z '< '0 
                                 (symbol "{") 'z '= '- 'z (symbol ";") 
                                 (symbol "}") (symbol "}") 'fn 'foo (symbol "(") 
                                 (symbol ")") (symbol "{") 'if 'y '> '0 (symbol "{") 
                                 'y '= '- 'y (symbol ";") (symbol "}") 'else (symbol "{") 
                                 'x '= '- 'y (symbol ";") (symbol "}") (symbol "}")))
          (str "fn main ( ) {\n"
               "  if x < 0 {\n"
               "    x = - x;\n"
               "   \n"
               "  }\n"
               "  renglon = x;\n"
               "  if z < 0 {\n"
               "    z = - z;\n"
               "   \n"
               "  }\n"
               " \n"
               "}\n"
               "fn foo ( ) {\n"
               "  if y > 0 {\n"
               "    y = - y;\n"
               "   \n"
               "  }\n"
               "  else {\n"
               "    x = - y;\n"
               "   \n"
               "  }\n"
               " \n"
               "}\n")
)))) 



