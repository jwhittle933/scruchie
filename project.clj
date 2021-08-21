(defproject scrunchie "0.1.0-preview"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license
  {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
   :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/tools.cli "1.0.206"]
                 [org.clojure/data.json "2.4.0"]
                 [mvxcvi/puget "1.3.1"]]
  :main ^:skip-aot scrunchie.core
  :target-path "target/%s"
  :profiles
  {:uberjar {:aot      :all
             :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
