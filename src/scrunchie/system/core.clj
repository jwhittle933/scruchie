(ns scrunchie.system.core
  (:gen-class))

(defn exit
  ([] (exit 0))
  ([code] (exit code "Done"))
  ([code message]
   (System/exit code)))
