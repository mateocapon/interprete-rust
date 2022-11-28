(ns funciones-implementar.ya-declarado-localmente-test
  (:require [clojure.test :refer :all]
            [interprete-rust.funciones-implementar.ya-declarado-localmente :refer :all]))

(deftest ya-declarado-localmente-test-1
  (testing "DUMP-1"
    (is (ya-declarado-localmente? 
        'Write [[0] [['io ['lib '()] 0] ['Write ['lib '()] 0] 
        ['entero_a_hexa ['fn [(list ['n (symbol ":") 'i64]) 'String]] 2]]])
    )
))

(deftest ya-declarado-localmente-test-2
  (testing "DUMP-2"
    (is (not (ya-declarado-localmente? 
        'Read [[0] [['io ['lib '()] 0] ['Write ['lib '()] 0] 
        ['entero_a_hexa ['fn [(list ['n (symbol ":") 'i64]) 'String]] 2]]]))
    )
))


(deftest ya-declarado-localmente-test-3
  (testing "DUMP-3"
    (is (ya-declarado-localmente? 
        'Write [[0 1] [['io ['lib '()] 0] ['Write ['lib '()] 0]
        ['entero_a_hexa ['fn [(list ['n (symbol ":") 'i64]) 'String]] 2]]])
    )
))

(deftest ya-declarado-localmente-test-4
  (testing "DUMP-4"
    (is (not (ya-declarado-localmente? 
        'Write [[0 2] [['io ['lib '()] 0] ['Write ['lib '()] 0]
        ['entero_a_hexa ['fn [(list ['n (symbol ":") 'i64]) 'String]] 2]]]))
    )
))
