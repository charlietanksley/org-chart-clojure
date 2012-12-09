(ns github-organizations.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.data.json :as json]
            [github-organizations.github :as github]
            [github-organizations.users :as users]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/api/:organization" [organization]
       (let [response {:organization (github/full-information-on-organization organization)
                       :members (github/members-in-organization organization)
                       :related-orgnizations (users/all-organizations-for-all-users organization)}]
         (json/write-str response)))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

