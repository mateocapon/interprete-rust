(ns funciones-implementar.compatibles-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.compatibles :refer :all]))


(deftest compatibles-test-1
  (testing "COMPATIBLES-1"
    (is (compatibles? 'i64 5)
)))

(deftest compatibles-test-2
  (testing "COMPATIBLES-2"
    (is (not (compatibles? 'i64 5.0))
)))

(deftest compatibles-test-3
  (testing "COMPATIBLES-3"
    (is (compatibles? 'i64 [5.0])
)))

(deftest compatibles-test-4
  (testing "COMPATIBLES-4"
    (is (compatibles? 'f64 5.0)
)))

(deftest compatibles-test-5
  (testing "COMPATIBLES-5"
    (is (compatibles? 'String "Hola")
)))

(deftest compatibles-test-6
  (testing "COMPATIBLES-6"
    (is (compatibles? 'bool true)
)))

(deftest compatibles-test-7
  (testing "COMPATIBLES-7"
    (is (not (compatibles? 'bool 1))
)))

(deftest compatibles-test-8
  (testing "COMPATIBLES-8"
    (is (compatibles? 'usize 1)
)))

(deftest compatibles-test-9
  (testing "COMPATIBLES-9"
    (is (compatibles? 'char \a)
)))

(deftest compatibles-test-10
  (testing "COMPATIBLES-10"
    (is (not(compatibles? 'char 'a))
)))

(deftest compatibles-test-11
  (testing "COMPATIBLES-11"
    (is (compatibles? 'char ['a])
)))