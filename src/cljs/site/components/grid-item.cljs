(ns site.components.grid-item
  (:require [cljs-react-material-ui.reagent :as ui]))


;; & HTML -> HTML
;; renders a grid-item
(defn grid-item [& children]
  [ui/paper {:style
              {:marginBottom "10px", :padding "10px"}
               :zDepth 1}
    children])
