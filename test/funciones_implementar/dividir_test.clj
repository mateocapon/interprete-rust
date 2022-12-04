(ns funciones-implementar.dividir-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.dividir :refer :all]))


(deftest dividir-test-1
  (testing "DIVIDIR-1"
    (is (= 
          (dividir 12 3)
          4
))))

(deftest dividir-test-2
  (testing "DIVIDIR-2"
    (is (= 
          (dividir 12.0 3)
          4.0
))))

(deftest dividir-test-3
  (testing "DIVIDIR-3"
    (is (= 
          (dividir 12 3.0)
          4.0
))))

(deftest dividir-test-4
  (testing "DIVIDIR-4"
    (is (= 
          (dividir 12.0 3.0)
          4.0
))))

(deftest dividir-test-5
  (testing "DIVIDIR-5"
    (is (= 
          (dividir 1 2)
          0
))))

(deftest dividir-test-6
  (testing "DIVIDIR-6"
    (is (= 
          (dividir 1 2.0)
          0.5
))))

(deftest dividir-test-7
  (testing "DIVIDIR-7"
    (is (= 
          (dividir 1.0 2)
          0.5
))))