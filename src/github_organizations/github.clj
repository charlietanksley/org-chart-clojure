(ns github-organizations.github
  (:use [clojure.string :only [join]])
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]))

(defn api-call
  "Construct the url for the api call."
  [class variable end-point]
  (join "/" (cons "https://api.github.com" [class variable end-point])))

(defn members-in-organization
  "Get all the members of an organization, as Github returns that data
  as JSON."
  [organization]
  (let [{body :body
         headers :headers}
        (client/get (api-call "orgs" organization "members"))]
    (json/read-str body
                   :key-fn keyword)))

(defn organizations-for-member
  "Get all the organizations a member belongs to, with all the
  attendant information, in JSON."
  [member]
  (let [{body :body
         headers :headers}
        (client/get (api-call "users" member "orgs"))]
    (json/read-str body
                   :key-fn keyword)))
