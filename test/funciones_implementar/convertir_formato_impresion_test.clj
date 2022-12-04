(ns funciones-implementar.convertir-formato-impresion-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.convertir-formato-impresion :refer :all]))


(deftest convertir-formato-impresion-test-1
  (testing "CONVERTIR-FORMATO-IMPRESION-1"
    (is (= 
          (convertir-formato-impresion '("Hola, mundo!"))
          '("Hola, mundo!")
))))


(deftest convertir-formato-impresion-test-2
  (testing "CONVERTIR-FORMATO-IMPRESION-2"
    (is (= 
          (convertir-formato-impresion '("- My name is {}, James {}.\n- Hello, {}{}{}!" "Bond" "Bond" 0 0 7))
          '("- My name is %s, James %s.\n- Hello, %d%d%d!" "Bond" "Bond" 0 0 7)
))))


(deftest convertir-formato-impresion-test-3
  (testing "CONVERTIR-FORMATO-IMPRESION-3"
    (is (= 
          (convertir-formato-impresion '("{} elevado a la {} es\t{}" 2.0 2 4.0))
           '("%.0f elevado a la %d es\t%.0f" 2.0 2 4.0)
))))


(deftest convertir-formato-impresion-test-4
  (testing "CONVERTIR-FORMATO-IMPRESION-4"
    (is (= 
        (convertir-formato-impresion '("Las raices cuadradas de {} son +{:.8} y -{:.8}"
                                        4.0 1.999999999985448 1.999999999985448))
        '("Las raices cuadradas de %.0f son +%.8f y -%.8f"
           4.0 1.999999999985448 1.999999999985448)
))))