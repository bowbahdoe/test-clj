(ns site.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))


(re-frame/reg-sub
  :current-page
  (fn [db]
    (:current-page db)))

(re-frame/reg-sub
  :navbar-expanded?
  (fn [db]
    (:expanded? (:navbar db))))

(re-frame/reg-sub
  :job-category
  (fn [db]
    (:selected-category (:jobs-page db))))
