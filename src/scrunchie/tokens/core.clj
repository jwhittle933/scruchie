(ns scrunchie.tokens.core
  (:require [scrunchie.file.core :as fs])
  (:gen-class))

(defn generate
  ([opts] (generate opts {}))
  ([opts config])
   (let [{:keys [files opts]}]
     files))
