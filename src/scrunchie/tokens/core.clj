(ns scrunchie.tokens.core
  (:require [scrunchie.file.core :as fs]
            [scrunchie.errors.core :as errors]
            [clojure.java.io :as io])
  (:gen-class))

(defn append-file
  "append-file associates the file content to the file name in the map"
  ;; if no encoding is specified, assume it's json
  ([f tokens] (assoc tokens (keyword (fs/file->name f)) (fs/file->readjson f)))
  ;; Parse with specified encoding
  ([f tokens encoding] (assoc tokens (keyword (fs/file->name f)) (fs/file->readjson f))))

(defn map-files
  ([] (errors/fatal 1 "Files required"))
  ([files] (map-files files {}))
  ([files tokens]
   (if (empty? files)
     tokens
     (let [f (first files)]
       (recur (rest files) (append-file f tokens))))))

(defn generate
  ([args] (generate args {}))
  ([args config]
   (let [{:keys [files opts]} args]
     (map-files files))))

