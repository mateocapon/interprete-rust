(ns interprete-rust.core
  (:require [interprete-rust.interprete :as interprete])
  (:gen-class)
)

(defn -main
  [& args]
  (println "Hello, World!")
  (interprete/driver-loop)
)


