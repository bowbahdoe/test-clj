(ns site.views
  (:require [reagent.core :as r]
            [reagent.interop :refer-macros [$]]
            [re-frame.core :as re-frame]
            [re-com.core :as re-com]
            [site.general :refer [get-unique-id]]
            [site.dependencies :refer [react-player]]
            [site.components.glyph :refer [glyph]]
            [site.components.navbar :refer [navbar]]))



;; ----------------------------------------------------------------------------
(defn main-panel []
  (fn []
    [:div
    [navbar "site"]
     [:h2 @(re-frame/subscribe [:current-page])]
     [:> react-player {:url "https://www.youtube.com/watch?v=ysz5S6PUM-U" :controls true}]]))
;; ============================================================================
