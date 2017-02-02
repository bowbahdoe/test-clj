(ns site.views
  (:require [reagent.core :as r]
            [reagent.interop :refer-macros [$]]
            [re-frame.core :as re-frame]
            [re-com.core :as re-com]
            [site.general :refer [get-unique-id]]
            [site.components.navbar :refer [navbar]]
            [site.components.grid-item :refer [grid-item]]
            [cljsjs.material-ui]))



;; ----------------------------------------------------------------------------
(def outer-style
 {:display "flex"
  :flex-direction "column"
  :height "100%"
  :color "red"})
(def inner-style
  {:backgroundColor js/MaterialUIStyles.colors.blueGrey50
   :flexGrow 1})

(defn main-panel []
    [:div

      [navbar "Maker Space" {:label "Dashboard"
                             :link "/home"}
                            {:label "Jobs"
                             :link "/jobs"}]

      [:div {:style outer-style}
        [:div {:style inner-style}]
        [grid-item [:p "Hey asshole"]]]
     [:h2 @(re-frame/subscribe [:current-page])]])
;; ============================================================================
