(ns site.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [site.dependencies]
              [site.events]
              [site.subs]
              [site.routes :as routes]
              [site.views :as views]
              [site.config :as config] ))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))
