(ns site.views.root
  (:require [reagent.core :as r]
            [reagent.interop :refer-macros [$]]
            [re-frame.core :as re-frame]
            [re-com.core :as re-com]
            [site.general :refer [get-unique-id]]
            [site.components.navbar :refer [navbar]]
            [site.components.grid-item :refer [grid-item]]
            [site.components.no-match :refer [no-match]]
            [cljs-react-material-ui.reagent :as ui]
            [cljs-react-material-ui.icons :as ic]
            [cljs-react-material-ui.core :refer [get-mui-theme color]]))



;; ----------------------------------------------------------------------------
(def outer-style
 {:display "flex"
  :flex-direction "column"
  :height "100%"})

(def inner-style
  {:backgroundColor (color :blueGrey50)
   :flexGrow 1})

(defmulti main-panel (fn [] @(re-frame/subscribe [:current-page])))

(defmethod main-panel :default []
  [no-match])

;; ============================================================================

(def mui-theme
  (get-mui-theme
    {:palette {
       :primary1Color (color :blueGrey500)}
     :toolbar {
       :color "rgba(0, 0, 0, .45)",
       :backgroundColor (color :blueGrey100)}}))

(defn root []
  [ui/mui-theme-provider {:mui-theme mui-theme}
    [:div
      [navbar "MakerSpace"  {:label "Dashboard"
                             :link "/home"
                             :icon [ic/action-dashboard]}
                            {:label "Jobs"
                             :link "/jobs"}]
        [:div {:style outer-style}
          [:div {:style inner-style}
            [main-panel]]]]])
