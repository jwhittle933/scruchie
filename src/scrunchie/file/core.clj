(ns scrunchie.file.core
  (:require [clojure.java.io :as io]
            [clojure.data.json :as json])
  (:gen-class))

(defn file->exists [f] (.exists (io/file f)))
(defn file->glob [f] (file-seq (io/file f)))
(defn file->abspath [f] (.getAbsolutePath (io/file f)))

(defn file->json [f] (json/read-str f :key-fn keyword))

(defn file->readjson [f]
  (-> f
      (file->abspath)
      (slurp)
      (file->json)))
