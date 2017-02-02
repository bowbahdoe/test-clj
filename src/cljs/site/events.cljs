(ns site.events
    (:require [re-frame.core :as re-frame]
              [site.db :as db]))

;; ----------------------------------------------------------------------------
;; EVENT: initialize-db
;; ARGS: nil
;; EFFECT: initialize the app state to the default value
(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

;; ----------------------------------------------------------------------------
;; EVENT: change-page
;; ARGS: new-page: Page (def @ db.cljs)
;; EFFECT: Changes the page to the one supplied by
;; provided Page
(re-frame/reg-event-db
  :change-page
  (fn [db [_ new-page]]
    (assoc-in db [:current-page] new-page)))

(re-frame/reg-event-db
  :toggle-navbar-expansion
  (fn [db _]
    (update-in db [:navbar :expanded?] not)))
