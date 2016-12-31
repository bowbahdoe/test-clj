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
            [site.components.glyph :refer [glyph]]
            [site.game-of-thrones]))



;; ----------------------------------------------------------------------------
(defn main-panel []
  (fn []
    (def chart js/window.Recharts)
    [:div
      [nav/navbar "title"
        {:title "Title 1" :link "/link1"}
        {:title "Title 4"
         :contents [{:title "some link"
                     :link "/about"}]}]
     [:h2 @(re-frame/subscribe [:current-page])]
     [:> chart.ResponsiveContainer {:minHeight 200}
        [:> chart.LineChart {:width 500
                             :height 300
                             :data [{:name "blah" :val 5}
                                    {:name "wow" :val 2}
                                    {:name "b3dlah" :val 4}
                                    {:name "b3lah" :val 8}
                                    {:name "bl332ah" :val 4}
                                    {:name "bla2h" :val 3}]}
        [:> chart.XAxis {:dataKey "name"}]
        [:> chart.YAxis]
        [:> chart.CartesianGrid {:stroke "#eee"
                                 :strokeDasharray "5 5"}]
        [:> chart.Line {:type "monotone"
                        :dataKey "val"
                        :stroke "#8884d8"}]]]]))
;; ============================================================================
