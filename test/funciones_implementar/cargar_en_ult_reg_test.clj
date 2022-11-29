(ns funciones-implementar.cargar-en-ult-reg-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.cargar-en-ult-reg :refer :all]))


(deftest cargar-en-ult-reg-test-1
  (testing "CARGAR-ULT-REGISTRO-1"
    (is (= 
          (cargar-en-ult-reg 
            [[['String "2"] ['i64 6] ['i64 2] ['i64 3] ['i64 0]] [['i64 nil] ['i64 nil]]] 
            1 'i64 0)
          [[['String "2"] ['i64 6] ['i64 2] ['i64 3] ['i64 0]] [['i64 nil] ['i64 0]]]
))))

(deftest cargar-en-ult-reg-test-2
  (testing "CARGAR-ULT-REGISTRO-2"
    (is (= 
          (cargar-en-ult-reg 
            [[['String "2"] ['i64 6] ['i64 2] ['i64 3] ['i64 0]] [['i64 nil] ['i64 0]]] 
            0 'f64 3)
          [[['String "2"] ['i64 6] ['i64 2] ['i64 3] ['i64 0]] [['f64 3] ['i64 0]]]
))))
