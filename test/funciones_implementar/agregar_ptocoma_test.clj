(ns funciones-implementar.agregar-ptocoma-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.agregar-ptocoma :refer :all]))


(deftest agregar-ptocoma-test-1
  (testing "PTOCOMA-1"
    (is (= 
          (agregar-ptocoma (list 
          'fn 'main (symbol "(") (symbol ")") (symbol "{") 
            'if 'x '< '0 (symbol "{") 
              'x '= '- 'x (symbol ";") 
             (symbol "}") 
             'renglon '= 'x (symbol ";") 
             'if 'z '< '0 (symbol "{") 
               'z '= '- 'z (symbol ";") 
             (symbol "}") 
           (symbol "}") 
           'fn 'foo (symbol "(") (symbol ")") (symbol "{") 
            'if 'y '> '0 (symbol "{") 
              'y '= '- 'y (symbol ";") 
            (symbol "}") 'else (symbol "{") 
            'x '= '- 'y (symbol ";") 
           (symbol "}") 
           (symbol "}")))

          (list 
          'fn 'main (symbol "(") (symbol ")") (symbol "{") 
            'if 'x '< '0 (symbol "{") 
              'x '= '- 'x (symbol ";") 
             (symbol "}") (symbol ";")
             'renglon '= 'x (symbol ";") 
             'if 'z '< '0 (symbol "{") 
               'z '= '- 'z (symbol ";") 
             (symbol "}") 
           (symbol "}") 
           'fn 'foo (symbol "(") (symbol ")") (symbol "{") 
            'if 'y '> '0 (symbol "{") 
              'y '= '- 'y (symbol ";") 
            (symbol "}") 'else (symbol "{") 
            'x '= '- 'y (symbol ";") 
           (symbol "}") 
           (symbol "}"))
))))