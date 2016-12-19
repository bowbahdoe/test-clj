(ns site.views
  (:require [re-frame.core :as re-frame]
            [re-com.core :as re-com]
            [site.components.tabbed-view :as tv]))


;; ----------------------------------------------------------------------------
(defn main-panel []
  (fn []
    [re-com/v-box
     :height "100%"
     :children
     [[tv/tabbed-view
        [:h1 "welcome"]
        [:h2 "to"]
        [:code {:style {:font-size "72px"}}"my arbitrarily complex"
          [:p {:style {:color "blue"}}
              "domain"]]]]]))

;; ============================================================================
