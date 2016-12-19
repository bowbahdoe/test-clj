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
;; EVENT: change-tab
;; ARGS: new-tab: N
;; EFFECT: Changes the currently selected tab
(re-frame/reg-event-db
  :change-tab
  (fn  [db [_ new-tab]]
      (assoc-in db [:tabbed-view :tab-opened] new-tab)))
