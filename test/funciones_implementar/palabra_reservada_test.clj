(ns funciones-implementar.palabra-reservada-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.palabra-reservada :refer :all]))

(deftest palabra-reservada-test-1
  (testing "PALABRA-RESERVADA 1"
    (is (palabra-reservada? 'while)
)))

(deftest palabra-reservada-test-3
  (testing "PALABRA RESERVADA 2"
    (is (not (palabra-reservada? 'bool))
)))