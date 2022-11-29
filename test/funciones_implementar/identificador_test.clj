(ns funciones-implementar.identificador-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.identificador :refer :all]))

(deftest identificador-test-1
  (testing "IDENTIFICADOR 1"
    (is (identificador? 'boolean)
)))

(deftest identificador-test-2
  (testing "IDENTIFICADOR 2"
    (is (not (identificador? 'bool))
)))

(deftest identificador-test-3
  (testing "IDENTIFICADOR 3"
    (is (identificador? 'e120)
)))

(deftest identificador-test-4
  (testing "IDENTIFICADOR 4"
    (is (not(identificador? '12e0))
)))