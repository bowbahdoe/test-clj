(ns site.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

;; Yields the currently selected tab
(re-frame/reg-sub
 :current-tab
 (fn [db]
   (:tab-opened  (:tabbed-view db))))
