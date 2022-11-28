(ns funciones-implementar.identificador-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.identificador :refer :all]))

(deftest identificador-test-1
  (testing "IDENTIFICADOR 1"
    (is (not (identificador? 'while))
)))