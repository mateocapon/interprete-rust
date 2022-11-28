(ns funciones-implementar.dump-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.dump :refer :all]))

(deftest dump-test-1
  (testing "DUMP-1"
    (is (= 
          (dump-str '[[POPREF 2] [PUSHFI 2] MUL [PUSHFI 1] ADD NEG])
          (str "0 [POPREF 2]\n"
               "1 [PUSHFI 2]\n"
               "2 MUL\n"
               "3 [PUSHFI 1]\n"
               "4 ADD\n"
               "5 NEG\n")
))))

(deftest dump-test-2
  (testing "DUMP-2"
    (is (= 
          (dump-str '[HLT])
          (str "0 HLT\n")
))))


(deftest dump-test-3
  (testing "DUMP-3"
    (is (= 
          (dump-str nil)
          (str "0 nil \n")
))))
