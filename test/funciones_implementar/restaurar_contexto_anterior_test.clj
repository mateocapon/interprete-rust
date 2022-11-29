(ns funciones-implementar.restaurar-contexto-anterior-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.restaurar-contexto-anterior :refer :all]))

(deftest restaurar-contexto-anterior-test-1
  (testing "INICIALIZAR CONTEXTO LOCAL 1"
    (is (= 
      (restaurar-contexto-anterior [
        'EOF 
        () 
        ['fn 'main (symbol "(") (symbol ")") (symbol "{") 'let 'x (symbol ":") 'i64 (symbol "=") 10 (symbol ";") 'let 'y (symbol ":") 'i64 (symbol "=") 20 (symbol ";") 'println! (symbol "(") "{}" (symbol ",") 'x '+ 'y (symbol ")") (symbol "}")] 
        8 
        [[0 1] [['main ['fn [() ()]] 2] ['x ['var-inmut 'i64] 0] ['y ['var-inmut 'i64] 1]]] 
        2 
        [['CAL 2] 'HLT ['PUSHFI 10] ['POP 0] ['PUSHFI 20] ['POP 1] ['PUSHFI "{}"] ['PUSHFM 0] ['PUSHFM 1] 'ADD ['PUSHFI 2] 'OUT 'NL] 
        [[2 ['i64 nil] ['i64 nil]]]
      ])
      [
        'EOF 
        () 
        ['fn 'main (symbol "(") (symbol ")") (symbol "{") 'let 'x (symbol ":") 'i64 (symbol "=") 10 (symbol ";") 'let 'y (symbol ":") 'i64 (symbol "=") 20 (symbol ";") 'println! (symbol "(") "{}" (symbol ",") 'x '+ 'y (symbol ")") (symbol "}")] 
        8 
        [[0 1] [['main ['fn [() ()]] 2] ['x ['var-inmut 'i64] 0] ['y ['var-inmut 'i64] 1]]] 
        2 
        [['CAL 2] 'HLT ['PUSHFI 10] ['POP 0] ['PUSHFI 20] ['POP 1] ['PUSHFI "{}"] ['PUSHFM 0] ['PUSHFM 1] 'ADD ['PUSHFI 2] 'OUT 'NL] 
        [[2 ['i64 nil] ['i64 nil]]]
      ]
    ))
))


(deftest restaurar-contexto-anterior-test-2
  (testing "INICIALIZAR CONTEXTO LOCAL 2"
    (is (= 
      (restaurar-contexto-anterior [
        'EOF 
        () 
        ['fn 'main (symbol "(") (symbol ")") (symbol "{") 'let 'x (symbol ":") 'i64 (symbol "=") 10 (symbol ";") 'let 'y (symbol ":") 'i64 (symbol "=") 20 (symbol ";") 'println! (symbol "(") "{}" (symbol ",") 'x '+ 'y (symbol ")") (symbol "}")] 
        :sin-errores
        [[0 1] [['main ['fn [() ()]] 2] ['x ['var-inmut 'i64] 0] ['y ['var-inmut 'i64] 1]]] 
        2 
        [['CAL 2] 'HLT ['PUSHFI 10] ['POP 0] ['PUSHFI 20] ['POP 1] ['PUSHFI "{}"] ['PUSHFM 0] ['PUSHFM 1] 'ADD ['PUSHFI 2] 'OUT 'NL] 
        [[2 ['i64 nil] ['i64 nil]]]
      ])
      [
        'EOF 
        () 
        ['fn 'main (symbol "(") (symbol ")") (symbol "{") 'let 'x (symbol ":") 'i64 (symbol "=") 10 (symbol ";") 'let 'y (symbol ":") 'i64 (symbol "=") 20 (symbol ";") 'println! (symbol "(") "{}" (symbol ",") 'x '+ 'y (symbol ")") (symbol "}")] 
        :sin-errores
        [[0] [['main ['fn [() ()]] 2]]]
        2 
        [['CAL 2] 'HLT ['PUSHFI 10] ['POP 0] ['PUSHFI 20] ['POP 1] ['PUSHFI "{}"] ['PUSHFM 0] ['PUSHFM 1] 'ADD ['PUSHFI 2] 'OUT 'NL] 
        [[2 ['i64 nil] ['i64 nil]]]
      ]
    ))
))