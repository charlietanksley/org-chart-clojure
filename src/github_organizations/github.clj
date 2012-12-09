(ns github-organizations.github
  (:use [clojure.string :only [join]])
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]))

(defn api-call
  "Construct the url for the api call."
  [& args]
  (join "/" (cons "https://api.github.com" args)))

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
  attendant information Github provides, in JSON."
  [member]
  (let [{body :body
         headers :headers}
        (client/get (api-call "users" member "orgs"))]
    (json/read-str body
                   :key-fn keyword)))

(defn full-information-on-organization
  "Get the information from Github on the organization."
  [organization-name]
  (let [{body :body}
        (client/get (api-call "orgs" organization-name))]
    (select-keys (json/read-str body
                                :key-fn keyword)
                 [:name :avatar_url :location :html_url :url])))
