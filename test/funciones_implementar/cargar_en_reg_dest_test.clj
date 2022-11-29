(ns funciones-implementar.cargar-en-reg-dest-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.cargar-en-reg-dest :refer :all]))


(deftest cargar-en-reg-dest-test-1
  (testing "CARGAR-EN-REGISTRO-DESTINO-1"
    (is (= 
          (cargar-en-reg-dest 
            [
              [['String "2"] ['i64 6] ['i64 2] ['i64 2] ['i64 2]] 
              [['i64 6] ['i64 2] ['i64 [0 3]] ['i64 [0 4]] ['i64 2] ['i64 2]]
            ] 
            [0 4] 'i64 0)
          [
            [['String "2"] ['i64 6] ['i64 2] ['i64 2] ['i64 0]] 
            [['i64 6] ['i64 2] ['i64 [0 3]] ['i64 [0 4]] ['i64 2] ['i64 2]]
          ]
))))


(deftest cargar-en-reg-dest-test-2
  (testing "CARGAR-EN-REGISTRO-DESTINO-2"
    (is (= 
          (cargar-en-reg-dest 
            [
              [['String "2"] ['i64 6] ['i64 2] ['i64 2] ['i64 0]] 
              [['i64 6] ['i64 2] ['i64 [0 3]] ['i64 [0 4]] ['i64 2] ['i64 2]]
            ] 
            [0 3] 'f64 3)
          [
            [['String "2"] ['i64 6] ['i64 2] ['f64 3] ['i64 0]] 
            [['i64 6] ['i64 2] ['i64 [0 3]] ['i64 [0 4]] ['i64 2] ['i64 2]]
          ]
))))