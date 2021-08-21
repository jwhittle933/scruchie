(ns scrunchie.errors.core
  (:gen-class))

(defn exit
  ([] (exit 0))
  ([code] (exit code "Done"))
  ([code message]
   (System/exit code)))

(defn fatal
  ([] (exit 1))
  ([code] (exit code "A Fatal error occurred"))
  ([code message] (exit code message)))
