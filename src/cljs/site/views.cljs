(ns site.views
  (:require [cljsjs.material-ui]
            [cljs-react-material-ui.core :refer [get-mui-theme color]]
            [cljs-react-material-ui.reagent :as ui]
            [cljs-react-material-ui.icons :as ic]
            [reagent.core :as r]
            [re-frame.core :as re-frame]
            [re-com.core :as re-com]
            [site.components.tabbed-view :as tv]
            [site.components.navbar :as nav]
            [site.components.glyph :refer [glyph]]))


;; ----------------------------------------------------------------------------
(defn main-panel []
  (let [side? (r/atom false)] (fn []
  [ui/mui-theme-provider
    [re-com/v-box
     :height "100%"
     :width "100%"
     :children
     [[ui/app-bar {:onLeftIconButtonTouchTap #(do (prn @side?)(swap! side? not))
                   :title "Menu"}]
      [ui/drawer {:open @side?
                  :docked false
                  :width 200
                  :onRequestChange #(do (prn @side?)(swap! side? not))}
        [ui/menu-item {:onTouchTap  #(swap! side? not)} "ITEMS!"]
        [ui/menu-item {:onTouchTap  #(swap! side? not)} "MORE ITEMS!"]
        [ui/menu-item {:onTouchTap  #(js/alert "adwwdaawdawdawd")} "MORE ITEMdS!"]]]]])))
;; ============================================================================
