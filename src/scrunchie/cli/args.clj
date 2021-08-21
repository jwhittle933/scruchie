(ns scrunchie.cli.args
  (:require [scrunchie.file.core :as fs]
            [clojure.tools.cli :as cli]
            [clojure.java.io :as io])
  (:gen-class))

(def cli-opts
  [["-h", "--help", "Exit with help message"]
   ["-v",
    nil,
    "Verboisty level; may be specified multiple time to increase value"
    :id        :verbosity
    :default   0
    :update-fn inc]
   ["-C",
    "--config FILE",
    "Path to config file; default is ./scrunchie.yml"
    :default  nil
    :validate [fs/file->exists, "Invalid config file"]]])

(defn parse [args] (cli/parse-opts args cli-opts))
