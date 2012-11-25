(ns github-organizations.github
  (:use [clojure.string :only [join]])
  (:require [clj-http.client :as client]))

(defn organization-members
  "Get all the members of an organization."
  [org-name]
  (client/get (join "/" ["https://api.github.com/orgs" org-name "members"])))
