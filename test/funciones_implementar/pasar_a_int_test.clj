(ns funciones-implementar.pasar-a-int-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.pasar-a-int :refer :all]))


(deftest pasar-a-int-test-1
  (testing "PASAR-A-INT 1"
    (is (= 
          (pasar-a-int "10")
          10
))))

(deftest pasar-a-int-test-2
  (testing "PASAR-A-INT 2"
    (is (= 
          (pasar-a-int 10.0)
          10
))))

(deftest pasar-a-int-test-3
  (testing "PASAR-A-INT 3"
    (is (= 
          (pasar-a-int 10)
          10
))))

(deftest pasar-a-int-test-4
  (testing "PASAR-A-INT 4"
    (is (= 
          (pasar-a-int 'a)
          'a
))))

(deftest pasar-a-int-test-5
  (testing "PASAR-A-INT 5"
    (is (= 
          (pasar-a-int [10.0])
          [10.0]
))))
