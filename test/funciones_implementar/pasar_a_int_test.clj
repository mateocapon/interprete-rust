(ns funciones-implementar.pasar-a-int-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.pasar-a-int :refer :all]))


(deftest pasar-a-int-test-1
  (testing "DIVIDIR-1"
    (is (= 
          (pasar-a-int 12 3)
          4
))))