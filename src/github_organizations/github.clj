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
    (json/read-str body
                   :key-fn keyword)))

(defn organizations-for-member
  "Get all the organizations a member belongs to."
  [member]
  (let [{body :body
         headers :headers}
        (client/get (join "/" ["https://api.github.com/users" member "orgs"]))]
    (json/read-str body
                   :key-fn keyword)))
