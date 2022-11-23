(ns funciones-implementar.listar-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.listar :refer :all]))

(deftest listar-test
  (testing "LISTAR"
    (is (= (string_imprimir (list 'a 'b)) (str ""))))