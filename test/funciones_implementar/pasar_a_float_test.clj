(ns funciones-implementar.pasar-a-float-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.pasar-a-float :refer :all]))


(deftest pasar-a-float-test-1
  (testing "PASAR-A-FLOAT 1"
    (is (= 
          (pasar-a-float "10")
          10.0
))))

(deftest pasar-a-float-test-2
  (testing "PASAR-A-FLOAT 2"
    (is (= 
          (pasar-a-float 10)
          10.0
))))

(deftest pasar-a-float-test-3
  (testing "PASAR-A-FLOAT 3"
    (is (= 
          (pasar-a-float 10.0)
          10.0
))))

(deftest pasar-a-float-test-4
  (testing "PASAR-A-FLOAT 4"
    (is (= 
          (pasar-a-float 'a)
          'a
))))

(deftest pasar-a-float-test-5
  (testing "PASAR-A-FLOAT 5"
    (is (= 
          (pasar-a-float [10])
          [10]
))))
