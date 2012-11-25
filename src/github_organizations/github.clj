(ns github-organizations.github
  (:use [clojure.string :only [join]])
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]))

(defn members-in-organization
  "Get all the members of an organization."
  [organization]
  (let [{body :body
         headers :headers}
        (client/get (join "/" ["https://api.github.com/orgs" organization "members"]))]
    {:body body, :headers headers}))

(defn organizations-by-member
  "Get all the organizations a member belongs to."
  [member]
  (let [{body :body
         headers :headers}
        (client/get (join "/" ["https://api.github.com/users" member "orgs"]))]
    {:body body, :headers headers}))

;(def e (json/read-str (apply :body example) :key-fn keyword))
