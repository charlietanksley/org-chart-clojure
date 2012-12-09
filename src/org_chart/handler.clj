(ns org-chart.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.data.json :as json]
            [org-chart.github :as github]
            [org-chart.users :as users]))

(defroutes app-routes
  (GET "/" [] "<h1>Org-Chart</h1><p>To get the info on an
  organization, append <code>'/api/:org-name.json'</code>, where
  ':org-name' gets replaced by the name of the organization you are
  looking into, into the address above. But be aware that for the time
  being, since we aren't using any sort of authentication, Github will
  cap your usage at 60 requests an hour. If you look for a big
  organization, you'll use those up before you get one JSON return
  value back. So look for something small (e.g., rspec).</p>")

  (GET "/api/:organization.json" [organization]
       (let [response {:organization (github/full-information-on-organization organization)
                       :members (github/members-in-organization organization)
                       :related-orgnizations (users/all-organizations-for-all-users organization)}]
         (json/write-str response)))

  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
