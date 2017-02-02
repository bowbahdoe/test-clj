(ns site.components.grid-item
  (:require [cljsjs.material-ui]))

(def material-ui js/MaterialUI)
(def material-ui-styles js/MaterialUIStyles)

;; & HTML -> HTML
;; renders a grid-item
(defn grid-item [& children]
  [:>  (.-MuiThemeProvider material-ui)
    [:> (.-Paper material-ui) {:style
                                {:marginBottom "10px", :padding "10px"}
                               :zDepth 1}
      children]])
