(defproject github-organizations "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.3"]
                 [clj-http "0.5.8"]
                 [org.clojure/data.json "0.2.0"]
                 ]
  :plugins [[lein-ring "0.7.5"]]
  :ring {:handler github-organizations.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
