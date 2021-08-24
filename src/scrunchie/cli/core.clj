(ns scrunchie.cli.core
  (:require [scrunchie.file.core :as fs]
            [scrunchie.errors.core :as errors]
            [clojure.java.io :as io])
  (:gen-class))

(defn validate [args errfn]
  (let [{:keys [errors]} args]
    (do
      (errfn errors)
      args)))

(defn exit-on-error [e]
  (when (not (nil? e)) (errors/fatal 1 e)))
