(ns interprete-rust.core
  (:require [interprete-rust.interprete :as interprete])
  (:gen-class)
)

(defn -main
  [& args]
  (interprete/driver-loop)
)


