(ns
  ^{:author "Jonathan Whittle"
    :doc    "A better style tokenizer for cross-platform DLS management"}
  scrunchie.core
  (:require [scrunchie.cli.args :as cli.args]
            [scrunchie.cli.core :as cli.core]
            [scrunchie.tokens.core :as tokens])
  (:gen-class))

(defn from-cli [args]
  (let [{:keys [arguments options]} args]
    (into {} [{:files arguments} {:opts options}])))

(defn -main
  "Entry to Scrunchie, a style tokenizer"
  [& args]
  (-> args
      (cli.args/parse)
      (cli.core/validate #(cli.core/exit-on-error %))
      (from-cli)
      (tokens/generate)
      (println)))

